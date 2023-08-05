package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class FirstTest {


    // test status code and headers
    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans");

        System.out.println(response.statusCode());
        Assertions.assertEquals(200, response.statusCode(), "Test status code");
        Assertions.assertEquals("application/json", response.header("Content-Type"));
//        response.prettyPrint();
        Assertions.assertEquals("application/json", response.contentType());


    }

    // get single spartan and assert body values
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/30");

        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        Assertions.assertEquals("30", response.path("id").toString());
        Assertions.assertEquals("Melania", response.path("name").toString());
    }

    // search by name
    @Test
    public void test3() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "Da")
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // search by gender
    @Test
    public void test4() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // search by name and gender together
    @Test
    public void test5() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .and().queryParam("nameContains", "e")
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // provide query parameters in a map object
    @Test
    public void test6() {
        Map<String, Object> query = new HashMap<>();
        query.put("gender", "Male");
        query.put("nameContains", "e");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(query)
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        response.prettyPrint();

    }
}