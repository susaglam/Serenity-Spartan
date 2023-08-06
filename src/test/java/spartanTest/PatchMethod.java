package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PatchMethod extends TestBase {

    // Test to demonstrate the PATCH method
    @Test
    public void test1() {
        // Create a map to hold the fields to be updated in the request body
        Map<String, Object> patchBody = new HashMap<>();
        patchBody.put("name", "Harold");

        // Send a PATCH request to "/api/spartans/{id}" with the "Accept" header set to "application/json",
        // content type set to "application/json", and the ID parameter as "300"
        // Set the request body as the patchBody map
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id", 300)
                .and().body(patchBody)
                .when().patch("/api/spartans/{id}");

        // Assert that the response status code is 204 (indicating success with no content returned)
        Assertions.assertEquals(204, response.statusCode());
    }
}
