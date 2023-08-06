package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import spartanTest.POJO.Spartan;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostMethod extends TestBase {

    int id;

    // Test to demonstrate adding a new Spartan with request body as String
    @Test
    public void test1() {
        // Define the request body as a JSON-formatted string
        String body = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Micheal\",\n" +
                "  \"phone\": 5286394175\n" +
                "}";

        // Send a POST request to "/api/spartans" with the "Accept" header set to "application/json",
        // content type set to "application/json", and the body as the JSON string
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        // Get the generated ID from the response for later use
        id = response.path("data.id");

        // Print the response for visualization
        response.prettyPrint();

        // Assert that the response status code is 201 (indicating successful creation)
        Assertions.assertEquals(201, response.statusCode());

        // Assert that the "success" message in the response is "A Spartan is Born!"
        Assertions.assertEquals("A Spartan is Born!", response.path("success"));
    }

    // Test to demonstrate adding a new Spartan with request body as a map
    @Test
    public void test2() {
        // Define the request body as a map
        Map<String, Object> bodyMap = new HashMap();
        bodyMap.put("gender", "Male");
        bodyMap.put("name", "Mike");
        bodyMap.put("phone", 5286394175L);

        // Send a POST request to "/api/spartans" with the "Accept" header set to "application/json",
        // content type set to "application/json", and the body as the map
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyMap)
                .when().post("/api/spartans");

        // Assert that the response status code is 201 (indicating successful creation)
        Assertions.assertEquals(201, response.statusCode());

        // Assert that the "success" message in the response is "A Spartan is Born!"
        Assertions.assertEquals("A Spartan is Born!", response.path("success"));
    }

    // Test to demonstrate adding a new Spartan with request body as a POJO object
    @Test
    public void test3() {
        // Create a new Spartan object and set its properties
        Spartan spartanBody = new Spartan();
        spartanBody.setGender("Male");
        spartanBody.setName("Harry");
        spartanBody.setPhone(5286394175L);

        // Send a POST request to "/api/spartans" with the "Accept" header set to "application/json",
        // content type set to "application/json", and the body as the POJO object
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(spartanBody)
                .when().post("/api/spartans");

        // Assert that the response status code is 201 (indicating successful creation)
        Assertions.assertEquals(201, response.statusCode());

        // Assert that the "success" message in the response is "A Spartan is Born!"
        Assertions.assertEquals("A Spartan is Born!", response.path("success"));
    }
}
