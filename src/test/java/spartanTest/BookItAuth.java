package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class BookItAuth {

    @Test
    public void test1(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTUxNiIsImF1ZCI6InRlYWNoZXIifQ.saFcTsRyMJQj1e8jhya1zpxngBggh5fC3lGsGyBCrQs";

        Response response = given().accept(ContentType.JSON)
                .and().header("Authorization",token)
                .when().get("http://api.qa.bookit.cydeo.com/api/batches");

        response.prettyPrint();
    }
}
