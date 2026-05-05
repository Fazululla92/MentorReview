package API;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiSteps {
    Response response;

    @Test
    @Given("Petstore base URI is set")
    public void petstore_base_uri_is_set() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }

    @When("I create a pet with id {int}")
    public void createPet(int id) {

        String body = "{\n" +
                "\"id\": " + id + ",\n" +
                "\"category\": {\"id\": 1, \"name\": \"dog\"},\n" +
                "\"name\": \"snoopie\",\n" +
                "\"photoUrls\": [\"string\"],\n" +
                "\"tags\": [{\"id\": 0, \"name\": \"string\"}],\n" +
                "\"status\": \"pending\"\n" +
                "}";

        response =
                given()
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/pet");
    }

    @Then("I should get status code {int}")
    public void validateStatus(int code) {
        response.then().statusCode(code);
    }

    @Then("I validate pet name is {string}")
    public void validateName(String name) {
        response.then().body("name", equalTo(name));
    }

    @Then("I validate pet category is {string}")
    public void validateCategory(String category) {
        response.then().body("category.name", equalTo(category));
    }

    @Then("I validate pet status is {string}")
    public void validateStatusValue(String status) {
        response.then().body("status", equalTo(status));
    }

    // ---------------- USERS API ----------------

    @Given("Users API base URI is set")
    public void setUsersURI() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @When("I get all users")
    public void getUsers() {
        response = given().when().get("/users");
    }

    @Then("status code should be {int}")
    public void status(int code) {
        response.then().statusCode(code);
    }

    @Then("users list should contain more than {int} users")
    public void userCount(int count) {
        response.then().body("size()", greaterThan(count));
    }

    @Then("user {string} should exist")
    public void userExists(String name) {
        response.then().body("name", hasItem(name));
    }
}
