package spartanTest;

import com.github.fge.jsonschema.main.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.module.jsv.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.*;

import java.io.*;

public class SchemaValidation extends TestBase {

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/4")
                .then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("singleSpartanSchema.json"))
                .extract().response();
    }

    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans")
                .then().body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Zulpikar\\IdeaProjects\\EU10_API_Testing_Review\\src\\test\\java\\week4\\allSpartansSchema.json")))
                .extract().response();
    }
}
