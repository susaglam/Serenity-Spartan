package spartanTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class FirstTest extends TestBase {

    //public class FirstTest { //get properties with serenity.properties
    // test status code and headers
    @Test
    public void test1() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans");
              //.when().get( properties.getProperty(baseURI) + "/api/spartans"); //get with properties data

        System.out.println(response.statusCode());
        Assertions.assertEquals(200, response.statusCode(), "Test status code");
        Assertions.assertEquals("application/json", response.header("Content-Type"));
//        response.prettyPrint();
        Assertions.assertEquals("application/json", response.contentType());


    }

    // get single spartan and assert body values
    @Test
    public void test2() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/30");

        System.out.println(response.statusCode());
        response.prettyPrint();

        System.out.println(response.path("id").toString());
        System.out.println(response.path("name").toString());
        System.out.println(response.path("gender").toString());
        System.out.println(response.path("phone").toString());

        Assertions.assertEquals("30", response.path("id").toString());
        Assertions.assertEquals("Melania", response.path("name").toString());
    }

    // search by name
    @Test
    public void test3() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "Da")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // search by gender
    @Test
    public void test4() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // search by name and gender together
    @Test
    public void test5() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("gender", "Male")
                .and().queryParam("nameContains", "e")
                .when().get("/api/spartans/search");

        System.out.println(response.statusCode());
        response.prettyPrint();
    }

    // provide query parameters in a map object
    @Test
    public void test6() {
        Map<String, Object> query = new HashMap<>();
        query.put("gender", "Male");
        query.put("nameContains", "e");

        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParams(query)
                .when().get("/api/spartans/search");

        response.prettyPrint();

    }
}