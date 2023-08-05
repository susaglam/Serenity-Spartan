package spartanTest;

import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.jupiter.api.*;
import week2.POJO.*;

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
