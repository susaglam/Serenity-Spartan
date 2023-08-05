package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PatchMethod extends TestBase {

    @Test
    public void test1(){
        Map<String, Object> patchBody = new HashMap<>();
        patchBody.put("name","Harold");

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id",300)
                .and().body(patchBody)
                .when().patch("/api/spartans/{id}");

        Assertions.assertEquals(204,response.statusCode());
    }
}
