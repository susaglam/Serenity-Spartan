package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class deleteMethod extends TestBase {


    @Test
    public void test1() {

        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 300)
                .when().delete("/api/spartans/{id}");


        Assertions.assertEquals(204, response.statusCode());

    }
}
