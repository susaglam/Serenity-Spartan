package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import spartanTest.POJO.*;

import java.util.*;

import static io.restassured.RestAssured.given;

public class JsonToJavaObject extends TestBase {

    // json to java -- deserilization
    // java to json -- serilazation


    // deserilization   json to list
    @Test
    public void test1() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        response.prettyPrint();

        List<Map<String, Object>> spartans = response.as(List.class);
        System.out.println(spartans);

    }

    // deserilization   json to list
    @Test
    public void test2() {
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/5");
        response.prettyPrint();

        Map<String, Object> sparan5 = response.as(Map.class);
        System.out.println(sparan5);

        Assertions.assertEquals("Blythe", sparan5.get("name"));
    }

    @Test
    public void test3() {
        Response response = given().accept(ContentType.JSON)
                .when().get("https://demoqa.com/BookStore/v1/Books");
//        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<Map<String, Object>> books = jsonPath.getList("books");

        System.out.println(books.size());
        System.out.println(books);

        Map<String, Object> book1 = jsonPath.getMap("books[0]");
        System.out.println(book1);
    }


    // convert response to custom class object
    // single spartan example
    @Test
    public void test4() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/30");

        response.prettyPrint();

        Spartan spartan30 = response.as(Spartan.class);
        System.out.println(spartan30);
    }


    // search spartan response
    @Test
    public void test5() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "Da")
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        response.prettyPrint();

        SpartanSearch spartanNameDa = response.as(SpartanSearch.class);

        System.out.println(spartanNameDa);
    }

    @Test
    public void test6() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("http://3.216.30.92:1000/ords/hr/regions");

        response.prettyPrint();

        Region region = response.as(Region.class);
        System.out.println(region);

        Assertions.assertEquals(4, region.getCount());
        Assertions.assertEquals("Americas", region.getItems().get(1).getRegion_name());
        Assertions.assertEquals("Americas", response.path("items[1].region_name"));

    }

    @Test
    public void test7() {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("http://3.216.30.92:1000/ords/hr/jobs");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        Items items = response.as(Items.class);
        Jobs job5 = items.getJobs().get(4);

        System.out.println(items);

        Jobs job1 = jsonPath.getObject("items[1]", Jobs.class);
        System.out.println(job1);

        Jobs job2 = jsonPath.getObject("items[2]", Jobs.class);

        Jobs job3 = jsonPath.getObject("items[3]", Jobs.class);
    }


}
