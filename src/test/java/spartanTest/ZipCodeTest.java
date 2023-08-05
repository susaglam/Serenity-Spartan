package spartanTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import spartanTest.POJO.ByPostCode;

import static io.restassured.RestAssured.given;

public class ZipCodeTest {

    @Test
    public void byZipCode(){
        Response response = given().accept(ContentType.JSON)
                .when().get("https://api.zippopotam.us/us/99950");

        response.prettyPrint();

        ByPostCode byPostCode = response.as(ByPostCode.class);

        Assertions.assertEquals("99950",byPostCode.getPostCode());

        System.out.println(byPostCode);
    }
}
