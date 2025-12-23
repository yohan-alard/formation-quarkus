package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpHeaders.ACCEPT;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {

    @Test
    void getAllBooks() {
        given()
                .header(ACCEPT, MediaType.APPLICATION_JSON)
                .when().get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(2));
    }

    @Test
    void countAllBooks() {
        given()
                .header(ACCEPT, MediaType.TEXT_PLAIN)
                .when().get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("2"));
    }

    @Test
    void getBook() {
        given()
                .header(ACCEPT, MediaType.APPLICATION_JSON)
                .pathParam("id", 1)
                .when().get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("title", is("george"))
                .body("author", is("georghe"))
                .body("yearOfPublication", is(2004))
                .body("genre", is("fantasy"));
    }
}