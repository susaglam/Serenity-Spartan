package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class XmlReview extends TestBase {

    // Test to get XML response from "/api/spartans" endpoint
    @Test
    public void test1() {
        // Send a GET request to "/api/spartans" with the "Accept" header set to "application/xml"
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        // Print the XML response in a pretty-printed format
        response.prettyPrint();

        // Assert that the response status code is 200 (OK)
        Assertions.assertEquals(200, response.statusCode());

        // Print the "Content-Type" header from the response
        System.out.println(response.header("Content-Type"));
    }

    // Test to parse XML response and extract specific values
    @Test
    public void test2() {
        // Send a GET request to "/api/spartans" with the "Accept" header set to "application/xml"
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        // Parse the XML response using XmlPath
        XmlPath xmlPath = response.xmlPath();

        // Extract the "id" attribute from the first "item" element in the XML response
        System.out.println(xmlPath.get("List.item[0].id").toString());

        // Assert that the extracted "name" attribute from the first "item" element is equal to "Paige"
        Assertions.assertEquals("Paige", xmlPath.getString("List.item[0].name"));
    }

    // Test to retrieve specific values from XML response from an external API
    @Test
    public void test3() {
        // Send a GET request to "http://restapi.adequateshop.com/api/Traveler" with the "Accept" header set to "application/xml"
        Response response = given().accept(ContentType.XML)
                .when().get("http://restapi.adequateshop.com/api/Traveler");

        // Parse the XML response using XmlPath
        XmlPath xmlPath = response.xmlPath();

        // Extract the value of the "email" attribute from the second "Travelerinformation" element
        String email = xmlPath.getString("TravelerinformationResponse.travelers.Travelerinformation[1].email");

        // Assert that the "adderes" attribute (address) from the second "Travelerinformation" element is equal to "USA"
        Assertions.assertEquals("USA", xmlPath.getString("TravelerinformationResponse.travelers.Travelerinformation[1].adderes"));

        // Print the value of the "email" attribute
        System.out.println(email);
    }
}
