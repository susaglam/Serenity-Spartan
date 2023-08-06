package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spartanTest.POJO.ByPostCode;

import static io.restassured.RestAssured.given;

public class ZipCodeTest {

    // Test to retrieve information about a specific ZIP code using the Zippopotam API
    @Test
    public void byZipCode() {
        // Send a GET request to "https://api.zippopotam.us/us/99950" and get the response
        Response response = given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/99950");

        // Print the response in a pretty-printed format
        response.prettyPrint();

        // Deserialize the response into a ByPostCode object using the ByPostCode class
        ByPostCode byPostCode = response.as(ByPostCode.class);

        // Assert that the "postCode" attribute in the deserialized ByPostCode object is equal to "99950"
        Assertions.assertEquals("99950", byPostCode.getPostCode());

        // Print the deserialized ByPostCode object to the console
        System.out.println(byPostCode);
    }
}
