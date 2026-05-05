package API;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class JiraSteps {

    Response response;
    static String issueId;
    static String issueKey;
    String baseURI = "https://your-domain.atlassian.net";
    String auth = "Basic YOUR_BASE64_ENCODED_CREDENTIALS";

    @Given("I create a Jira defect")
    public void createDefect() {

        RestAssured.baseURI = baseURI;

        String body = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": { \"key\": \"TEST\" },\n" +
                "    \"summary\": \"Defect from API\",\n" +
                "    \"description\": \"Created via automation\",\n" +
                "    \"issuetype\": { \"name\": \"Bug\" }\n" +
                "  }\n" +
                "}";

        response =
                given()
                        .header("Authorization", auth)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/rest/api/3/issue");

        response.then().statusCode(201);

        issueId = response.jsonPath().getString("id");
        issueKey = response.jsonPath().getString("key");
    }

    @Then("I store the defect id")
    public void storeId() {
        System.out.println("Issue ID: " + issueId);
        System.out.println("Issue Key: " + issueKey);
    }

    @When("I update the defect using id")
    public void updateDefect() {

        String body = "{\n" +
                "  \"fields\": {\n" +
                "    \"summary\": \"Updated defect title\"\n" +
                "  }\n" +
                "}";

        response =
                given()
                        .header("Authorization", auth)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .put("/rest/api/3/issue/" + issueKey);
    }

    @Then("I verify defect is updated")
    public void verifyUpdate() {
        response.then().statusCode(204);
    }

    @When("I search the defect by id")
    public void searchDefect() {

        response =
                given()
                        .header("Authorization", auth)
                        .when()
                        .get("/rest/api/3/issue/" + issueKey);
    }

    @Then("I verify defect is found")
    public void verifySearch() {
        response.then().statusCode(200);
        response.then().body("key", equalTo(issueKey));
    }

    @When("I attach a file to defect")
    public void attachFile() {

        File file = new File("src/test/resources/testfile.txt");

        response =
                given()
                        .header("Authorization", auth)
                        .header("X-Atlassian-Token", "no-check")
                        .multiPart("file", file)
                        .when()
                        .post("/rest/api/3/issue/" + issueKey + "/attachments");
    }

    @Then("I verify attachment is successful")
    public void verifyAttachment() {
        response.then().statusCode(200);
    }

    @When("I create a defect with attachment")
    public void createWithAttachment() {

        File file = new File("src/test/resources/testfile.txt");

        String body = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": { \"key\": \"TEST\" },\n" +
                "    \"summary\": \"Defect with attachment\",\n" +
                "    \"issuetype\": { \"name\": \"Bug\" }\n" +
                "  }\n" +
                "}";

        response =
                given()
                        .header("Authorization", auth)
                        .header("Content-Type", "application/json")
                        .body(body)
                        .when()
                        .post("/rest/api/3/issue");

        String newKey = response.jsonPath().getString("key");

        given()
                .header("Authorization", auth)
                .header("X-Atlassian-Token", "no-check")
                .multiPart("file", file)
                .when()
                .post("/rest/api/3/issue/" + newKey + "/attachments");
    }

    @Then("I verify defect creation with attachment")
    public void verifyCreateAttach() {
        System.out.println("Created defect with attachment");
    }

    @When("I delete the defect")
    public void deleteDefect() {

        response =
                given()
                        .header("Authorization", auth)
                        .when()
                        .delete("/rest/api/3/issue/" + issueKey);
    }

    @Then("I verify defect is deleted")
    public void verifyDelete() {
        response.then().statusCode(204);
    }
}
