package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class TimeTest extends TestBase {

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .when().get("api/spartans")
                .then().time(both(greaterThan(1000L)).and(lessThan(2000L)))
                .extract().response();

        System.out.println(response.getTime());

    }
}
