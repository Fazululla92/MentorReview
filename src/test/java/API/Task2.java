package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Task2 {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        String[] resources = {
                "/posts",
                "/comments",
                "/albums",
                "/photos",
                "/todos",
                "/users"
        };

        System.out.println("=== 1. RESOURCE COUNT CHECK ===");

        for (String res : resources) {
            Response response = given()
                    .when()
                    .get(res);

            System.out.println(res + " -> Status: " + response.getStatusCode()
                    + " | Size: " + response.jsonPath().getList("$").size());
        }

        System.out.println("\n=== 2. GET SPECIFIC RESOURCE ===");

        Response getResponse = given()
                .when()
                .get("/posts/1");

        System.out.println("GET Status: " + getResponse.getStatusCode());
        System.out.println("GET Body: " + getResponse.asPrettyString());

        System.out.println("\n=== 3. CREATE RESOURCE (POST) ===");

        Response postResponse = given()
                .header("Content-type", "application/json")
                .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
                .when()
                .post("/posts");

        System.out.println("POST Status: " + postResponse.getStatusCode());
        System.out.println("POST Body: " + postResponse.asPrettyString());

        System.out.println("\n=== 4. MODIFY RESOURCE (PUT) ===");

        Response putResponse = given()
                .header("Content-type", "application/json")
                .body("{ \"id\": 1, \"title\": \"updated\", \"body\": \"updated body\", \"userId\": 1 }")
                .when()
                .put("/posts/1");

        System.out.println("PUT Status: " + putResponse.getStatusCode());
        System.out.println("PUT Body: " + putResponse.asPrettyString());

        System.out.println("\n=== 5. DELETE RESOURCE ===");

        Response deleteResponse = given()
                .when()
                .delete("/posts/1");

        System.out.println("DELETE Status: " + deleteResponse.getStatusCode());
        System.out.println("DELETE Body: " + deleteResponse.asPrettyString());

    }
}
