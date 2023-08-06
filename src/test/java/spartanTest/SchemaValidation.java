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

    // Schema validation for a single Spartan
    @Test
    public void test1() throws IOException, ProcessingException {
        // Send a GET request to fetch a single Spartan
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans/4")
                .then().extract().response();

        // Create a JsonSchemaFactory and load the JSON schema from a resource file
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(Objects.requireNonNull(getClass().getResourceAsStream("/singleSpartanSchema.json")).toString());

        // Validate the response against the JSON schema
        schema.validate((JsonNode) response.getBody());
    }

    // Schema validation for all Spartans
    @Test
    public void test2() throws IOException, ProcessingException {
        // Send a GET request to fetch all Spartans
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get("/api/spartans")
                .then().extract().response();

        // Create a JsonSchemaFactory and load the JSON schema from a file
        JsonSchemaFactory schemaFactory = JsonSchemaFactory.byDefault();
        JsonSchema schema = schemaFactory.getJsonSchema(String.valueOf(new File("E:\\GitHub\\Serenity-Spartan-Review\\src\\test\\java\\spartanTest\\allSpartansSchema.json")));

        // Validate the response against the JSON schema
        schema.validate((JsonNode) response.getBody());
    }
}
