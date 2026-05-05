package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SimpleBooksAPITest {
    static String token;
    public static void main(String[] args) {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";
        System.out.println("TASK 1: STATUS CHECK");

        given()
                .when()
                .get("/status")
                .then()
                .statusCode(200)
                .body("status", equalTo("OK"));

        System.out.println("\nTASK 2: GET BOOKS");

        Response booksResponse =
                given()
                        .when()
                        .get("/books");

        booksResponse.then().statusCode(200);

        int size = booksResponse.jsonPath().getList("$").size();
        System.out.println("Total books: " + size);

        booksResponse.jsonPath().getList("$").forEach(book -> {
            System.out.println(book.toString());
        });

        System.out.println("\nTASK 3: FICTION BOOKS");

        Response fictionResponse =
                given()
                        .when()
                        .get("/books?type=fiction");

        fictionResponse.then().statusCode(200);

        fictionResponse.jsonPath().getList("type").forEach(type -> {
            if (!type.equals("fiction")) {
                throw new AssertionError("Non-fiction book found!");
            }
        });

        System.out.println("All books are fiction");
        System.out.println("\nTASK 4: BOOK BY ID");

        Response book1 =
                given()
                        .when()
                        .get("/books/1");

        book1.then().statusCode(200);

        int id = book1.jsonPath().getInt("id");
        String title = book1.jsonPath().getString("name");
        String type = book1.jsonPath().getString("type");
        boolean available = book1.jsonPath().getBoolean("available");

        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Type: " + type);
        System.out.println("Available: " + available);
        System.out.println("\nTASK 5: TOKEN GENERATION");

        Response tokenResponse =
                given()
                        .header("Content-Type", "application/json")
                        .body("{ \"clientName\": \"TestUser\", \"clientEmail\": \"testuser@example.com\" }")
                        .when()
                        .post("/api-clients/");

        tokenResponse.then().statusCode(201);

        token = tokenResponse.jsonPath().getString("accessToken");

        System.out.println("Token: " + token);
        System.out.println("\nTASK 6: PLACE ORDER");

        Response orderResponse =
                given()
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + token)
                        .body("{ \"bookId\": 1, \"customerName\": \"John Doe\" }")
                        .when()
                        .post("/orders");

        orderResponse.then().statusCode(201);

        String orderId = orderResponse.jsonPath().getString("orderId");

        System.out.println("Order placed successfully. Order ID: " + orderId);
    }
}