package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ParametrizeTesting extends TestBase {

    /*
    Parametrize Testing:
    Parametrized testing allows us to run the same test with multiple sets of input data.
    In JUnit 5, we can use various sources to provide data for parametrized testing.
    In this class, we demonstrate four ways to provide data to the test methods:
    1. @ValueSource: It provides simple values as input to the test method.
    2. @MethodSource: It provides input data from a static method of the test class.
    3. @CsvSource: It provides input data from a CSV string directly within the test annotation.
    4. @CsvFileSource: It provides input data from a CSV file.

    */

    // Parameterized test using @ValueSource to pass a list of integers as input
    @ParameterizedTest
    @ValueSource(ints = {4, 6, 7, 8, 9})
    public void valueSource(int id) {
        // Send a GET request to "/api/spartans/{id}" with the "Accept" header set to "application/json" using the given ID
        Response response = given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/" + id + "");
        // Print the response in a pretty-printed format
        response.prettyPrint();
    }

    // Static method to provide a list of partial names for parametrized testing
    public static List<String> getPartialNames() {
        List<String> names = Arrays.asList("va", "ma", "de", "nu");
        return names;
    }

    // Parameterized test using @MethodSource to pass a list of partial names as input
    @ParameterizedTest
    @MethodSource("getPartialNames")
    public void methodSource(String names) {
        // Send a GET request to "/api/spartans/search" with the "Accept" header set to "application/json" and query parameter "nameContains" using the given partial names
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("nameContains", names)
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        // Print the response in a pretty-printed format
        response.prettyPrint();
    }

    // Parameterized test using @CsvSource to pass multiple sets of input data in a CSV format
    @ParameterizedTest
    @CsvSource({"8,Rodolfo", "13,Jaimie", "21,Mark"})
    public void csvSource(int id, String name) {
        // Send a GET request to "/api/spartans/{id}" with the "Accept" header set to "application/json" using the given ID
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", id)
                .when().get("/api/spartans/{id}");

        // Assertions to check if the name in the response matches the expected name
        Assertions.assertEquals(name, response.path("name"));
    }

    // Parameterized test using @CsvFileSource to read input data from a CSV file
    @ParameterizedTest
    @CsvFileSource(resources = "/SpartanDataPOST.csv", numLinesToSkip = 1)
    public void csvFileSource(String name, String gender, Long phone) {
        // Create a body map to send as the request payload
        Map<String, Object> body = new HashMap<>();
        body.put("name", name);
        body.put("gender", gender);
        body.put("phone", phone);

        // Send a POST request to "/api/spartans" with the "Accept" header set to "application/json" and request body as the body map
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        // Print the response in a pretty-printed format
        response.prettyPrint();
    }
}
