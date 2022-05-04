package tests;

import org.junit.jupiter.api.Test;

import java.awt.*;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetListResourceTest {

    @Test
    void getResource() {
        int actualPage =
                given()
                .contentType(JSON)
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .extract().path("total_pages");
        int expectedPage = 2;
        assertEquals  (expectedPage, actualPage);
    }
}
