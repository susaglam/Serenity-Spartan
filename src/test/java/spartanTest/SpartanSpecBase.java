package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.specification.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class SpartanSpecBase {

    // This method is annotated with @BeforeAll, which means it will run before all the test cases in the class.
    // It sets up the base URI for the REST API.
    @BeforeAll
    public static void init() {
        baseURI = "http://3.216.30.92:8000";
    }

    // Create a RequestSpecification object using RestAssured.given().accept(ContentType.JSON).
    // This object will be used to build the request for each test case.
    public RequestSpecification reqSpec = RestAssured.given().accept(ContentType.JSON);

    // Create a ResponseSpecification object using reqSpec.expect().statusCode(200).
    // This object will be used to validate the response for each test case, ensuring the status code is 200 (OK).
    public ResponseSpecification resSpec = reqSpec.expect().statusCode(200);
}

//In this code, a base class SpartanSpecBase is defined, which contains a setup method annotated with @BeforeAll.
// This method sets the base URI for the REST API to "http://3.216.30.92:8000".
//
// Additionally, two member variables are declared: reqSpec and resSpec.
// reqSpec is a RequestSpecification object that will be used to build the request for each test case.
// It is created using RestAssured.given().accept(ContentType.JSON), which sets the request to accept JSON format.
//
// resSpec is a ResponseSpecification object that will be used to validate the response for each test case.
// It is created using reqSpec.expect().statusCode(200), which sets the expected status code to 200 (OK).
// This means that after sending a request, the response will be automatically checked to ensure it has a status code of 200.
//
// By using these specifications, test cases in the SpartanTest class (or any other class that extends SpartanSpecBase)
// can easily build requests and validate responses without repeating the same code for each test case.
// It promotes code reusability and simplifies the testing process.