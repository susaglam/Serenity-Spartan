package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PutMethod extends TestBase {

    @Test
    public void test1(){
        Map<String, Object> bodyUpdateMap = new HashMap();
        bodyUpdateMap.put("gender","Male");
        bodyUpdateMap.put("name","Mike");
        bodyUpdateMap.put("phone",5286394175L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id",300)
                .and().body(bodyUpdateMap)
                .when().put("/api/spartans/{id}");

        assertThat(response.statusCode(),is(204));



    }


}
