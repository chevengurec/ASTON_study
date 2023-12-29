import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanPatchRequest {
    private final static String URL = "https://postman-echo.com";

    @Test
    public void testStatusCode() {
        RestAssured.baseURI = URL;
        given()
                .baseUri(URL)
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBody() {
        RestAssured.baseURI = URL;
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain")
                .body("This is expected to be sent back as part of response body.")
                .when()
                .patch("/patch")
                .then()
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.content-type", equalTo("text/plain; charset=ISO-8859-1"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
}
