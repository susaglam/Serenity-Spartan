package spartanTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class SSLTest {

    // This test case demonstrates how to perform an HTTPS request with relaxed SSL validation.

    @Test
    public void test1(){
        // To perform an HTTPS request with relaxed SSL validation, use the "relaxedHTTPSValidation()" method.
        // This method allows you to bypass SSL certificate validation, which can be useful for testing against
        // self-signed or untrusted SSL certificates.
        // In this example, we are sending a GET request to the "https://untrusted-root.badssl.com/" endpoint
        // with relaxed SSL validation.
        // The "prettyPrint()" method is used to print the response body in a formatted manner.
        given().relaxedHTTPSValidation()
                .when()
                .get("https://untrusted-root.badssl.com/").prettyPrint();
    }

    @Test
    public void test2(){
        // This test case demonstrates how to use a specific keystore for SSL validation.

        // To use a specific keystore for SSL validation, use the "keyStore()" method.
        // This method allows you to specify the path to the keystore file and its password.
        // The keystore is used for client-side SSL certificate authentication when the server requires it.
        // In this example, we are sending a GET request to the "apiurl" endpoint using the specified keystore.
        // Replace "pathtofile" and "password" with the actual path to your keystore file and its password.
        given()
                .keyStore("pathtofile","password")
                .when().get("apiurl");
    }
}
