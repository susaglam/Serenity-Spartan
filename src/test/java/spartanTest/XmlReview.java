package spartanTest;

import com.fasterxml.jackson.annotation.*;
import io.restassured.http.*;
import io.restassured.path.json.*;
import io.restassured.path.xml.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.*;

import static io.restassured.RestAssured.given;

public class XmlReview extends TestBase {



    // getting xml response
    @Test
    public void test1(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");

        response.prettyPrint();
        Assertions.assertEquals(200,response.statusCode());
        System.out.println(response.header("Content-Type"));
    }

    @Test
    public void test2(){
        Response response = given().accept(ContentType.XML)
                .when().get("/api/spartans");


        XmlPath xmlPath = response.xmlPath();

        System.out.println(xmlPath.get("List.item[0].id").toString());
        Assertions.assertEquals("Paige",xmlPath.getString("List.item[0].name"));
    }


    // travler xml test

    @Test
    public void test3(){

        Response response = given().accept(ContentType.XML)
                .when().get("http://restapi.adequateshop.com/api/Traveler");

//        response.prettyPrint();

        XmlPath xmlPath = response.xmlPath();
        String email = xmlPath.getString("TravelerinformationResponse.travelers.Travelerinformation[1].email");

        Assertions.assertEquals("USA",xmlPath.getString("TravelerinformationResponse.travelers.Travelerinformation[1].adderes"));
        System.out.println(email);
    }
}
