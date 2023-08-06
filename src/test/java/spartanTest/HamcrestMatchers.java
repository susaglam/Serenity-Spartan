package spartanTest;

import io.restassured.http.ContentType;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchers extends TestBase {

    // Test using Hamcrest Matchers for basic assertions
    @Test
    public void test1() {
        // Using Hamcrest Matchers to perform various assertions

        // Assert that 5 is equal to 5
        MatcherAssert.assertThat(5, is(5));

        // Assert that 5 is not equal to 10
        MatcherAssert.assertThat(5, not(10));

        // Assert that 5 is not equal to 9
        MatcherAssert.assertThat(5, is(not(9)));

        // Assert that 5 is equal to 5 using assertThat from Hamcrest
        assertThat(5, equalTo(5));

        // Assert that 5 is not null
        assertThat(5, notNullValue());

        // Assert that the String "hello" is equal to "hello"
        assertThat("hello", is("hello"));

        // Assert that two Strings "str1" and "str2" are equal
        String str1 = "house";
        String str2 = "house";
        assertThat(str1, is(str2));

        // Assert that the String "str1" contains the substring "ou"
        String str3 = "ou";
        assertThat(str1, containsString(str3));

        // Assert that an object "obj" is an instance of String class
        Object obj = "hello";
        assertThat(obj, instanceOf(String.class));

        // Assert that every item in the List "numbers" is greater than 0
        List<Integer> numbers = Arrays.asList(3, 4, 5, 6);
        assertThat(numbers, everyItem(greaterThan(0)));
    }

    // Test using Hamcrest Matchers for API response validation
    @Test
    public void test2() {
        // Send a GET request to "http://3.216.30.92:8000/api/spartans/15" with the "Accept" header set to "application/json"
        given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/15")
                .then().statusCode(200) // Assert that the response status code is 200 (OK)
                .and().header("Content-Type", is("application/json")) // Assert that the "Content-Type" header is "application/json"
                .and().body("id", is(15), // Assert that the "id" attribute in the response body is equal to 15
                        "name", equalTo("Meade"), // Assert that the "name" attribute in the response body is equal to "Meade"
                        "gender", not("Female")); // Assert that the "gender" attribute in the response body is not "Female"
    }

    // Test using Hamcrest Matchers to extract and validate JSON data from the response
    @Test
    public void test3() {
        // Send a GET request to "/api/spartans" with the "Accept" header set to "application/json"
        // Extract the name of the 10th Spartan from the JSON response
        String names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getString("[10].name");
    }
}
