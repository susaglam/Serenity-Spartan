package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PutMethod extends TestBase {

    @Test
    public void test1() {
        // Create a Map for the request body to update the Spartan information
        Map<String, Object> bodyUpdateMap = new HashMap();
        bodyUpdateMap.put("gender", "Male");
        bodyUpdateMap.put("name", "Mike");
        bodyUpdateMap.put("phone", 5286394175L);

        // Send a PUT request to update the Spartan information
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id", 300)
                .and().body(bodyUpdateMap)
                .when().put("/api/spartans/{id}");

        // Use Hamcrest assertions to validate the response status code.
        // We expect a 204 status code for a successful PUT request.
        assertThat(response.statusCode(), is(204));

        // Note: There are no additional assertions or printing of the response in this test.
        // Additional validations or response inspection can be added if required.
    }
}
