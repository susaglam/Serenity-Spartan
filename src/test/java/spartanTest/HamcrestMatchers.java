package spartanTest;

import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.hamcrest.*;
import org.junit.jupiter.api.*;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchers extends TestBase {

    @Test
    public void test1(){

        MatcherAssert.assertThat(5,is(5));

        MatcherAssert.assertThat(5,not(10));

        MatcherAssert.assertThat(5, is(not(9)));

        assertThat(5,equalTo(5));
        assertThat(5,notNullValue());

        assertThat("hello",is("hello"));

        String str1 = "house";
        String str2 = "house";
        assertThat(str1,is(str2));

        String str3 = "ou";
        assertThat(str1,containsString(str3));

        Object obj = "hello";
        assertThat(obj,instanceOf(String.class));

        List<Integer> numbers = Arrays.asList(3,4,5,6);
        assertThat(numbers,everyItem(greaterThan(0)));

    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/15")
                .then().statusCode(200)
                .and().header("Content-Type",is("application/json"))
                .and().body("id",is(15),
                        "name",equalTo("Meade"),
                        "gender",not("Female"));



    }

    @Test
    public void test3(){
        String names = given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().statusCode(200)
                .extract().jsonPath().getString("[10].name");
    }
}
