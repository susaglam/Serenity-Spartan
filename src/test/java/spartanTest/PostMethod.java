package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.*;
import week2.POJO.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostMethod extends TestBase {


    int id;
    // add a new spartan  -- provide body as String
    @Test
    public void test1(){
        String body = "{\n" +
                "  \"gender\": \"Male\",\n" +
                "  \"name\": \"Micheal\",\n" +
                "  \"phone\": 5286394175\n" +
                "}";

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(body)
                .when().post("/api/spartans");

        id = response.path("data.id");

        response.prettyPrint();
        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("A Spartan is Born!",response.path("success"));
    }

    // provide body as a map
    @Test
    public void test2(){
        Map<String, Object> bodyMap = new HashMap();
        bodyMap.put("gender","Male");
        bodyMap.put("name","Mike");
        bodyMap.put("phone",5286394175L);


        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(bodyMap)
                .when().post("/api/spartans");

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("A Spartan is Born!",response.path("success"));

    }

    // providing body as POJO object
    @Test
    public void test3(){
        Spartan spartanBody = new Spartan();
        spartanBody.setGender("Male");
        spartanBody.setName("Harry");
        spartanBody.setPhone(5286394175L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().body(spartanBody)
                .when().post("/api/spartans");

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("A Spartan is Born!",response.path("success"));
    }
}
