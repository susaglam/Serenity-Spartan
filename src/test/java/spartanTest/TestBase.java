package spartanTest;

import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.baseURI;

public class TestBase {

    @BeforeAll
    public static void init(){
        baseURI = "http://3.216.30.92:8000";
    }
}
