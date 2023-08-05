package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class ParametrizeTesting extends TestBase {

    /*
    we have 4 ways to provide data to test
    1. value source
    2. method source
    3. csv source
    4. csv file source

     */


    @ParameterizedTest
    @ValueSource(ints = {4, 6, 7, 8, 9})
    public void valueSource(int id) {
        Response response = given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/" + id + "");
        response.prettyPrint();
    }


    public static List<String> getPartialNames() {
        List<String> names = Arrays.asList("va", "ma", "de", "nu");
        return names;
    }


    @ParameterizedTest
    @MethodSource("getPartialNames")
    public void methodSource(String names) {
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains", names)
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        response.prettyPrint();
    }

    @ParameterizedTest
    @CsvSource({"8,Rodolfo",
            "13,Jaimie",
            "21,Mark"})
    public void csvSource(int id, String name) {
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("/api/spartans/{id}");

        Assertions.assertEquals(name, response.path("name"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/SpartanDataPOST.csv", numLinesToSkip = 1)
    public void csvFileSource(String name, String gender, Long phone) {
        Map<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("gender", gender);
        body.put("phone", phone);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        response.prettyPrint();
    }
}
