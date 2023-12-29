import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanPostRawText {
    private final static String URL = "https://postman-echo.com";

    @Test
    public void testStatusCodeInPostRawText() {
        RestAssured.baseURI = URL;

        given()
                .baseUri(URL)
                .body("{\n    \"test\": \"value\"\n}")
                .contentType("text/plain")
                .when()
                .post("/post")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBodyInPostRawText() {
        RestAssured.baseURI = URL;

        given()
                .baseUri("https://postman-echo.com")
                .body("{\n    \"test\": \"value\"\n}")
                .contentType("text/plain")
                .when()
                .post("/post")
                .then()
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("23"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

}
