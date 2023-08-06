package spartanTest;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class TestBase {

    // This method is executed once before any test in the class is run.
    // It sets the base URI for all the API requests in the test class.
    @BeforeAll
    public static void init() {
        baseURI = "http://3.216.30.92:8000";
    }
}

//    init(): This method is annotated with @BeforeAll, which means it will be executed once before any test method in the class is run.
//    The purpose of this method is to set the base URI for all the API requests made within the test class.
//
//     baseURI = "http://3.216.30.92:8000";: The baseURI variable from RestAssured is set to "http://3.216.30.92:8000".
//     This means that all the API requests made using RestAssured in this test class will have this base URL,
//      and you only need to provide the endpoint path relative to this base URI in the individual test methods.