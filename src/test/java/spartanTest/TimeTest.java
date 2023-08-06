package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TimeTest extends TestBase {

    @Test
    public void test1(){
        // This test case demonstrates how to perform a time-based assertion on the response time.

        // To measure the response time of a request, you can use the "time()" method along with Hamcrest matchers.
        // In this example, we are sending a GET request to the "api/spartans" endpoint and measuring the response time.
        // The "time()" method takes a Hamcrest matcher as an argument. In this case, we are using the "both()" matcher
        // to specify that the response time should be both greater than 1000 milliseconds and less than 2000 milliseconds.
        // This means the response time should be between 1 and 2 seconds.
        // If the response time does not meet this condition, the test will fail.

        // The "extract().response()" method is used to extract the response after the assertion is made. This allows us
        // to perform additional operations on the response, such as printing the response time.

        Response response = given().accept(ContentType.JSON)
                .when().get("api/spartans")
                .then().time(both(greaterThan(1000L)).and(lessThan(2000L)))
                .extract().response();

        // After the request is executed and the time assertion is made, we can access the response time using the
        // "getTime()" method on the response object.
        System.out.println(response.getTime());
    }
}
