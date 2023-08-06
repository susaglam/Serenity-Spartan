package spartanTest;

import io.restassured.http.*;
import net.serenitybdd.junit5.*;
import net.serenitybdd.rest.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;

@SerenityTest
public class postSpartanTest {

    // BeforeAll method sets up the baseURI before running the tests.
    // This way, all tests will run on the same baseURI.
    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.216.30.92:8000";
    }

    // Test method to send a POST request and add a new Spartan
    @Test
    public void test1() {
        // Create a Map for the request body and add the required fields
        Map<String, Object> body = new HashMap<>();
        body.put("name", "Ahmet");
        body.put("gender", "Male");
        body.put("phone", 1236547895L);

        // Use SerenityRest to send a POST request.
        // Set the "Accept" and "Content-Type" headers to "application/json".
        // The request body is set as the previously created Map data structure.
        SerenityRest.given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        // The response is not directly accessed through lastResponse() in this test.
        // Instead, validations are directly performed on the response.

        // Use Ensure.that to perform validations on the response.
        // This way, it is ensured that the request is successfully completed and the expected results are returned.
        Ensure.that("Status code validation", vR -> vR.statusCode(201));
        Ensure.that("Success message test", vR -> vR.body("success", is("A Spartan is Born!")));
        Ensure.that("Id can not be null", vR -> vR.body("data.id", is(notNullValue())));
        Ensure.that("The name should be correct", vR -> vR.body("data.name", is(body.get("name"))));

        // Note: lastResponse().prettyPrint(); can be used to print the response content,
        // but it is not used in this test. It can be helpful for inspecting the content
        // of the response or for debugging purposes.
    }
}
