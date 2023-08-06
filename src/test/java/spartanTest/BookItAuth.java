package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class BookItAuth {

    // Test to perform an authorized GET request using a JWT token
    @Test
    public void test1() {
        // Define the JWT token that will be used for authorization
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

        // Send a GET request to "http://api.qa.bookit.cydeo.com/api/batches"
        // Set the "Accept" header to "application/json"
        // Set the "Authorization" header with the JWT token for authorization
        Response response = given().accept(ContentType.JSON)
                .and().header("Authorization", token)
                .when().get("http://api.qa.bookit.cydeo.com/api/batches");

        // Print the response in a pretty-printed format
        response.prettyPrint();
    }
}
