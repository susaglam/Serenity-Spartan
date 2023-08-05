package spartanTest;

import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SpecTest extends SpartanSpecBase {

    @Test
    public void test1(){
        Response response = given().spec(reqSpec).when().get("/api/spartans")
                .then().spec(resSpec).extract().response();

        response.prettyPrint();



    }
}
