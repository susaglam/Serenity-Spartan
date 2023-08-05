package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class JsonPathReview {

    @Test
    public void test1(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/1");

        response.prettyPrint();

        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.get("id").toString());
        System.out.println(jsonPath.getString("name"));
        System.out.println(jsonPath.getInt("id"));
        System.out.println(jsonPath.getLong("phone"));

    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        List<String> names = jsonPath.getList("name");
        System.out.println(names);

        List<Integer> ids = jsonPath.getList("id");


    }

    
    // zipcode get by post code
    @Test
    public void test3(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/90210");

        JsonPath jsonPath = response.jsonPath();
        response.prettyPrint();

        String state = jsonPath.getString("places[0].state");
        System.out.println(state);

        String countryAbb = jsonPath.getString("country");
        System.out.println(countryAbb);
    }
    
    //    // zipcode get by city name
    @Test
    public void test4(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/ma/belmont");

        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();
        String state = jsonPath.getString("state");
        System.out.println(state);

        String longitude = jsonPath.getString("places[0].longitude");
        System.out.println(longitude);

        String latitude = jsonPath.getString("places[1].latitude");
        System.out.println(latitude);
    }

    // book store api
    @Test
    public void test5(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://demoqa.com/BookStore/v1/Books");

//        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();
        int pageNum = jsonPath.getInt("books[0].pages");

        String isbn = jsonPath.getString("books[2].isbn");

        String link = jsonPath.getString("books[-1].website");
        System.out.println(link);

        List<Object> books = jsonPath.getList("books");
        System.out.println(books.size());

        int booksCount = jsonPath.getList("books.isbn").size();
        System.out.println(booksCount);

    }
}
