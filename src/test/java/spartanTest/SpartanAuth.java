package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class SpartanAuth {

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("user","user")
                .when().get("http://3.216.30.92:7000/api/spartans");

        System.out.println(response.statusCode());
    }

    @Test
    public void test2(){
        Map<String, Object> bodyMap = new HashMap();
        bodyMap.put("gender","Male");
        bodyMap.put("name","Harry");
        bodyMap.put("phone",5286398175L);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().auth().basic("admin","admin")
                .and().body(bodyMap)
                .when().post("http://3.216.30.92:7000/api/spartans");

        System.out.println(response.statusCode());

    }
}
