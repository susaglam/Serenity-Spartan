package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class PathParams {

    // Test to demonstrate the usage of path parameters
    @Test
    public void test1() {
        // Send a GET request to "/api/spartans/{id}" with the "Accept" header set to "application/json"
        // and the path parameter "id" set to 30
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",30)
                .when().get("http://3.216.30.92:8000/api/spartans/{id}");

        // Assert that the response status code is 200 (indicating success)
        Assertions.assertEquals(200,response.statusCode());
    }
}
