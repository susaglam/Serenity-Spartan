package spartanTest;

import io.restassured.response.*;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

public class SSLTest {

    @Test
    public void test1(){
        given().relaxedHTTPSValidation()
                .when()
                .get("https://untrusted-root.badssl.com/").prettyPrint();
    }

    @Test
    public void test2(){
        given()
                .keyStore("pathtofile","password")
                .when().get("apiurl");
    }
}
