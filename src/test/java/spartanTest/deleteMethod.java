package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class deleteMethod extends TestBase {

    // Test to perform a DELETE request to delete a Spartan by ID
    @Test
    public void test1() {
        // Send a DELETE request to "/api/spartans/{id}" with ID parameter as 300
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 300)
                .when().delete("/api/spartans/{id}");

        // Assert that the response status code is 204 (No Content)
        Assertions.assertEquals(204, response.statusCode());
    }
}
