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

    // deserilization   json to list
    @Test
    public void test1() {
        // Send a GET request to "/api/spartans" with the "Accept" header set to "application/json"
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");
        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a List of Maps using the "as" method
        List<Map<String, Object>> spartans = response.as(List.class);
        System.out.println(spartans);
    }

    // deserilization   json to map
    @Test
    public void test2() {
        // Send a GET request to "/api/spartans/5" with the "Accept" header set to "application/json"
        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans/5");
        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a Map using the "as" method
        Map<String, Object> spartan5 = response.as(Map.class);
        System.out.println(spartan5);

        // Assertions to check the "name" attribute of the Spartan with ID 5
        Assertions.assertEquals("Blythe", spartan5.get("name"));
    }

    // Deserialize JSON response to a List of Maps and extract specific attributes
    @Test
    public void test3() {
        // Send a GET request to "https://demoqa.com/BookStore/v1/Books" with the "Accept" header set to "application/json"
        Response response = given().accept(ContentType.JSON)
                .when().get("https://demoqa.com/BookStore/v1/Books");
        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Create a JSONPath object from the response to extract a list of "books" attributes
        JsonPath jsonPath = response.jsonPath();

        // Extract the list of "books" attributes from the JSON response
        List<Map<String, Object>> books = jsonPath.getList("books");

        // Print the size and contents of the list
        System.out.println(books.size());
        System.out.println(books);

        // Extract and print the first book as a Map
        Map<String, Object> book1 = jsonPath.getMap("books[0]");
        System.out.println(book1);
    }

    // Deserialize JSON response to a custom class object
    @Test
    public void test4() {
        // Send a GET request to "http://3.216.30.92:8000/api/spartans/30" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/30");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a Spartan object using the "as" method
        Spartan spartan30 = response.as(Spartan.class);
        System.out.println(spartan30);
    }

    // Deserialize JSON response to a custom class object for SpartanSearch
    @Test
    public void test5() {
        // Send a GET request to "http://3.216.30.92:8000/api/spartans/search" with query parameter "nameContains=Da" and "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().queryParam("nameContains", "Da")
                .when().get("http://3.216.30.92:8000/api/spartans/search");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a SpartanSearch object using the "as" method
        SpartanSearch spartanNameDa = response.as(SpartanSearch.class);

        System.out.println(spartanNameDa);
    }

    // Deserialize JSON response to a custom class object for Region
    @Test
    public void test6() {
        // Send a GET request to "http://3.216.30.92:1000/ords/hr/regions" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("http://3.216.30.92:1000/ords/hr/regions");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a Region object using the "as" method
        Region region = response.as(Region.class);
        System.out.println(region);

        // Assertions to check the count and "region_name" attribute of the second item in the response
        Assertions.assertEquals(4, region.getCount());
        Assertions.assertEquals("Americas", region.getItems().get(1).getRegion_name());
        Assertions.assertEquals("Americas", response.path("items[1].region_name"));
    }

    // Deserialize JSON response to a custom class object for Jobs using both SerenityRest and JsonPath
    @Test
    public void test7() {
        // Send a GET request to "http://3.216.30.92:1000/ords/hr/jobs" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .get("http://3.216.30.92:1000/ords/hr/jobs");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the JSON response to a Jobs object using SerenityRest's "as" method
        Items items = response.as(Items.class);
        Jobs job5 = items.getJobs().get(4);
        System.out.println(items);

        // Deserialize specific "items[1]" attribute to a Jobs object using JsonPath
        JsonPath jsonPath = response.jsonPath();
        Jobs job1 = jsonPath.getObject("items[1]", Jobs.class);
        System.out.println(job1);

        // Deserialize specific "items[2]" attribute to a Jobs object using JsonPath
        Jobs job2 = jsonPath.getObject("items[2]", Jobs.class);

        // Deserialize specific "items[3]" attribute to a Jobs object using JsonPath
        Jobs job3 = jsonPath.getObject("items[3]", Jobs.class);
    }
}
