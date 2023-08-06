package spartanTest;

import io.restassured.http.ContentType;
import net.serenitybdd.junit5.SerenityTest;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static org.hamcrest.Matchers.is;

@Disabled
@SerenityTest
public class getSpartanTest {

    // Set up the base URI for all the API requests in the class
    @BeforeAll
    public static void setUpBase() {
        baseURI = "http://3.216.30.92:8000";
    }

    // Test to perform a GET request and validate status code and content type
    @Test
    public void test1() {
        // Send a GET request to "/api/spartans" with the "Accept" header set to "application/json"
        // Check that the response status code is 200 (OK)
        SerenityRest.given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200);

        // Ensure that the status code of the response is 200 using Serenity Ensure.that()
        Ensure.that("Status code validation", validatableResponse -> validatableResponse.statusCode(200));

        // Ensure that the content type of the response is "application/json" using Serenity Ensure.that()
        Ensure.that("Content type validation", vR -> vR.contentType(ContentType.JSON));
    }

    // Test to perform a GET request to retrieve a specific Spartan and validate response attributes
    @Test
    public void test2() {
        // Send a GET request to "/api/spartans/{id}" with ID parameter as 4
        SerenityRest.given().accept(ContentType.JSON)
                .and().pathParam("id", 4)
                .when().get("/api/spartans/{id}");

        // Extract and print the "name" attribute from the response
        System.out.println(lastResponse().path("name").toString());

        // Extract and print the "gender" attribute from the response using JSONPath
        String gender = lastResponse().jsonPath().getString("gender");
        System.out.println(gender);

        // Ensure that the status code of the response is 200 using Serenity Ensure.that()
        Ensure.that("Status code validation", x -> x.statusCode(200));

        // Ensure that the "name" attribute in the response body is equal to "Paige" using Serenity Ensure.that()
        Ensure.that("Body validation -- name", vR -> vR.body("name", is("Paige")));

        // Ensure that the "gender" attribute in the response body is equal to "Female" using Serenity Ensure.that()
        Ensure.that("Body validation -- gender", vR -> vR.body("gender", is("Female")));
    }
}
