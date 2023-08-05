package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.specification.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class SpartanSpecBase {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.216.30.92:8000";
    }

    public RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON);

    public ResponseSpecification resSpec = reqSpec.expect().statusCode(200);



}
