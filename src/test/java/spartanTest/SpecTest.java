package spartanTest;

import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SpecTest extends SpartanSpecBase {

    // This test case demonstrates the usage of the RequestSpecification and ResponseSpecification objects.

    @Test
    public void test1(){
        // Use the reqSpec RequestSpecification object from the SpartanSpecBase class to build the request.
        // Here, we are sending a GET request to the endpoint "/api/spartans".
        // The "accept(ContentType.JSON)" specification is applied automatically as it's set in the base class.
        // The request is sent using "given().spec(reqSpec).when().get("/api/spartans")".
        // The response is captured in a Response object.
        Response response = given().spec(reqSpec).when().get("/api/spartans")
                .then().spec(resSpec).extract().response();

        // The prettyPrint() method is used to print the response body in a formatted manner.
        response.prettyPrint();

        // Since the resSpec ResponseSpecification object has the expectation of status code 200,
        // the response will be automatically checked, and an assertion will be triggered if the status code is not 200.
        // This ensures that the response status code is validated without explicitly writing an assertion for it.
    }
}

//In this SpecTest class, we are extending the SpartanSpecBase class, which contains the reqSpec and resSpec objects.
//
//In the test1() method, we are using the reqSpec object to build the GET request to
// the endpoint "/api/spartans" using given().spec(reqSpec).when().get("/api/spartans").
//
//We then use the resSpec object to validate the response by chaining .then().spec(resSpec).
// The resSpec object contains the expectation that the response status code should be 200 (OK).
//
//The response object captures the response of the request.
//
//The response.prettyPrint() method is used to print the response body in a formatted manner.
//
//The resSpec object ensures that the response status code is automatically validated without explicitly writing an assertion for it.
// If the status code is not 200, an assertion will be triggered, indicating a test failure.
// This demonstrates how using specifications simplifies and enhances the test cases by reducing boilerplate code and promoting reusability.