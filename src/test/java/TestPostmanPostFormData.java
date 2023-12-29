import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanPostFormData {
    private final static String URL = "https://postman-echo.com";

    @Test
    public void testStatusCode() {
        RestAssured.baseURI = URL;

        given()
                .baseUri(URL)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .post("/post")
                .then()
                .statusCode(200);
    }

    @Test
    public void testBody() {
        RestAssured.baseURI = URL;

        given()
                .baseUri(URL)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .when()
                .post("/post")
                .then()
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-length", equalTo("19"))
                .body("headers.accept", equalTo("*/*"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }
}
