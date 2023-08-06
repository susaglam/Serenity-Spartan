package spartanTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstTest extends TestBase {

    // Test to check the status code and headers of the response
    @Test
    public void test1() {
        // Send a GET request to "/api/spartans" and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        // Print the status code of the response
        System.out.println(response.statusCode());

        // Assert that the status code is 200 (OK)
        Assertions.assertEquals(200, response.statusCode(), "Test status code");

        // Assert that the "Content-Type" header is "application/json"
        Assertions.assertEquals("application/json", response.header("Content-Type"));

        // Print the response body in a pretty-printed format
        // response.prettyPrint();

        // Assert that the response content type is "application/json"
        Assertions.assertEquals("application/json", response.contentType());
    }

    // Test to get a single Spartan and assert body values
    @Test
    public void test2() {
        // Send a GET request to "/api/spartans/30" and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/30");

        // Print the status code of the response
        System.out.println(response.statusCode());

        // Print the response body in a pretty-printed format
        response.prettyPrint();

        // Extract and print specific values from the response body (JSON)
        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        // Assert that the "id" value in the response body is "30"
        Assertions.assertEquals("30", response.path("id").toString());

        // Assert that the "name" value in the response body is "Melania"
        Assertions.assertEquals("Melania", response.path("name").toString());
    }

    // Test to search Spartans by name
    @Test
    public void test3() {
        // Send a GET request to "/api/spartans/search" with query parameter "nameContains=Da" and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "Da")
                .when().get("/api/spartans/search");

        // Print the status code of the response
        System.out.println(response.statusCode());

        // Print the response body in a pretty-printed format
        response.prettyPrint();
    }

    // Test to search Spartans by gender
    @Test
    public void test4() {
        // Send a GET request to "/api/spartans/search" with query parameter "gender=Male" and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .when().get("/api/spartans/search");

        // Print the status code of the response
        System.out.println(response.statusCode());

        // Print the response body in a pretty-printed format
        response.prettyPrint();
    }

    // Test to search Spartans by name and gender together
    @Test
    public void test5() {
        // Send a GET request to "/api/spartans/search" with query parameters "gender=Male" and "nameContains=e" and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .and().queryParam("nameContains", "e")
                .when().get("/api/spartans/search");

        // Print the status code of the response
        System.out.println(response.statusCode());

        // Print the response body in a pretty-printed format
        response.prettyPrint();
    }

    // Test to provide query parameters in a map object
    @Test
    public void test6() {
        // Create a Map object to store query parameters (gender=Male, nameContains=e)
        Map<String, Object> query = new HashMap<>();
        query.put("gender", "Male");
        query.put("nameContains", "e");

        // Send a GET request to "/api/spartans/search" with the query parameters from the map object and get the response
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(query)
                .when().get("/api/spartans/search");

        // Print the response body in a pretty-printed format
        response.prettyPrint();
    }
}
