package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

public class PathParams {


    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id",30)
                .when().get("http://3.216.30.92:8000/api/spartans/{id}");

        Assertions.assertEquals(200,response.statusCode());
    }

}
