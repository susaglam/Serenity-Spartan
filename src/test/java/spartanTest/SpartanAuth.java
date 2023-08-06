package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class SpartanAuth {

    // Test case to perform a GET request with basic authentication
    @Test
    public void test1() {
        // Send a GET request with basic authentication using username "user" and password "user"
        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("user", "user")
                .when().get("http://3.216.30.92:7000/api/spartans");

        // Print the status code of the response
        System.out.println(response.statusCode());
    }

    // Test case to perform a POST request with basic authentication and a JSON body
    @Test
    public void test2() {
        // Create a body map with the data to be sent in the request body
        Map<String, Object> bodyMap = new HashMap();
        bodyMap.put("gender", "Male");
        bodyMap.put("name", "Harry");
        bodyMap.put("phone", 5286398175L);

        // Send a POST request with basic authentication using username "admin" and password "admin"
        // and the JSON body provided in the bodyMap
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .and().body(bodyMap)
                .when().post("http://3.216.30.92:7000/api/spartans");

        // Print the status code of the response
        System.out.println(response.statusCode());
    }
}
