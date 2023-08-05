package spartanTest;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SchemaValidation extends TestBase {

    @Test
    public void test1() throws IOException, ProcessingException {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans/4")
                .then().extract().response();

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(Objects.requireNonNull(getClass().getResourceAsStream("/singleSpartanSchema.json")).toString());
        schema.validate((JsonNode) response.getBody());
    }

    @Test
    public void test2() throws IOException, ProcessingException {
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("http://3.216.30.92:8000/api/spartans")
                .then().extract().response();

        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(String.valueOf(new File("E:\\GitHub\\Serenity-Spartan-Review\\src\\test\\java\\spartanTest\\allSpartansSchema.json")));
        schema.validate((JsonNode) response.getBody());
    }
}
