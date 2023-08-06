package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;

import java.util.*;

public class JsonPathReview {

    // Test to extract specific attributes from a JSON response
    @Test
    public void test1() {
        // Send a GET request to "http://3.216.30.92:8000/api/spartans/1" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/1");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Create a JSONPath object from the response to extract specific attributes
        JsonPath jsonPath = response.jsonPath();

        // Extract and print the "id" attribute from the JSON response
        System.out.println(jsonPath.get("id").toString());

        // Extract and print the "name" attribute from the JSON response
        System.out.println(jsonPath.getString("name"));

        // Extract and print the "id" attribute as an integer from the JSON response
        System.out.println(jsonPath.getInt("id"));

        // Extract and print the "phone" attribute as a long from the JSON response
        System.out.println(jsonPath.getLong("phone"));
    }

    // Test to extract a list of attributes from a JSON response
    @Test
    public void test2() {
        // Send a GET request to "http://3.216.30.92:8000/api/spartans" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Create a JSONPath object from the response to extract a list of "name" attributes
        JsonPath jsonPath = response.jsonPath();

        // Extract and print the list of "name" attributes from the JSON response
        List<String> names = jsonPath.getList("name");
        System.out.println(names);

        // Extract and print the list of "id" attributes from the JSON response
        List<Integer> ids = jsonPath.getList("id");
    }

    // Test to extract specific attributes from a JSON response of a zip code API
    @Test
    public void test3() {
        // Send a GET request to "https://api.zippopotam.us/us/90210" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/90210");

        // Create a JSONPath object from the response to extract specific attributes
        JsonPath jsonPath = response.jsonPath();

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Extract and print the "state" attribute from the JSON response
        String state = jsonPath.getString("places[0].state");
        System.out.println(state);

        // Extract and print the "country" attribute from the JSON response
        String countryAbb = jsonPath.getString("country");
        System.out.println(countryAbb);
    }

    // Test to extract specific attributes from a JSON response of a zip code API using city name
    @Test
    public void test4() {
        // Send a GET request to "https://api.zippopotam.us/us/ma/belmont" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/ma/belmont");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Create a JSONPath object from the response to extract specific attributes
        JsonPath jsonPath = response.jsonPath();

        // Extract and print the "state" attribute from the JSON response
        String state = jsonPath.getString("state");
        System.out.println(state);

        // Extract and print the "longitude" attribute from the JSON response for the first place
        String longitude = jsonPath.getString("places[0].longitude");
        System.out.println(longitude);

        // Extract and print the "latitude" attribute from the JSON response for the second place
        String latitude = jsonPath.getString("places[1].latitude");
        System.out.println(latitude);
    }

    // Test to extract specific attributes from a JSON response of a book store API
    @Test
    public void test5() {
        // Send a GET request to "https://demoqa.com/BookStore/v1/Books" with the "Accept" header set to "application/json"
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("https://demoqa.com/BookStore/v1/Books");

//        response.prettyPrint();

        // Create a JSONPath object from the response to extract specific attributes
        JsonPath jsonPath = response.jsonPath();

        // Extract and print the number of pages ("pages" attribute) of the first book from the JSON response
        int pageNum = jsonPath.getInt("books[0].pages");

        // Extract and print the ISBN ("isbn" attribute) of the third book from the JSON response
        String isbn = jsonPath.getString("books[2].isbn");

        // Extract and print the website ("website" attribute) of the last book from the JSON response
        String link = jsonPath.getString("books[-1].website");
        System.out.println(link);

        // Extract the list of all books and print the size of the list
        List<Object> books = jsonPath.getList("books");
        System.out.println(books.size());

        // Extract the list of all book ISBNs and print the size of the list
        int booksCount = jsonPath.getList("books.isbn").size();
        System.out.println(booksCount);
    }
}
