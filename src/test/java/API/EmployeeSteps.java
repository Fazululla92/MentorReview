package API;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class EmployeeSteps {

    Response response;
    static String empId;
    static int initialCount;

    String baseURI = "https://dummy.restapiexample.com/api/v1";

    @Given("I fetch all employees")
    public void getAllEmployees() {

        RestAssured.baseURI = baseURI;

        response = given()
                .when()
                .get("/employees");

        initialCount = response.jsonPath().getList("data").size();

        validateCommon(response);
    }

    @Then("I verify employee count")
    public void verifyCount() {
        response.then().statusCode(200);
        System.out.println("Employee count: " + initialCount);
    }

    @When("I create a new employee")
    public void createEmployee() {

        String body = "{ \"name\": \"John\", \"salary\": \"50000\", \"age\": \"30\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post("/create");

        empId = response.jsonPath().getString("data.id");

        validateCommon(response);
    }

    @Then("I verify employee is created")
    public void verifyCreate() {
        response.then().statusCode(200);
        response.then().body("status", equalTo("success"));
    }

    @Then("I verify employee count increased by 1")
    public void verifyCountIncrease() {

        Response res = given().get("/employees");

        int newCount = res.jsonPath().getList("data").size();

        assert newCount == initialCount + 1;
    }

    @When("I get employee details")
    public void getEmployee() {

        response = given()
                .when()
                .get("/employee/" + empId);

        validateCommon(response);
    }

    @Then("I verify employee details")
    public void verifyDetails() {
        response.then().statusCode(200);
    }

    @When("I update employee details")
    public void updateEmployee() {

        String body = "{ \"name\": \"John Updated\", \"salary\": \"70000\", \"age\": \"35\" }";

        response = given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put("/update/" + empId);

        validateCommon(response);
    }

    @Then("I verify update is successful")
    public void verifyUpdate() {
        response.then().statusCode(200);
        response.then().body("status", equalTo("success"));
    }

    @When("I get employee details again")
    public void getEmployeeDetailsAgain() {

        response = given()
                .when()
                .get("/employee/" + empId);

        response.then().statusCode(200);
    }

    @Then("I verify updated details")
    public void verifyUpdatedDetails() {
        response.then().body("data.name", equalTo("John Updated"));
    }

    @When("I delete employee")
    public void deleteEmployee() {

        response = given()
                .when()
                .delete("/delete/" + empId);

        validateCommon(response);
    }

    @Then("I verify delete is successful")
    public void verifyDelete() {
        response.then().statusCode(200);
    }

    @Then("I verify employee count decreased by 1")
    public void verifyCountDecrease() {

        Response res = given().get("/employees");

        int newCount = res.jsonPath().getList("data").size();

        assert newCount == initialCount;
    }

    public void validateCommon(Response response) {

        response.then()
                .header("content-type", containsString("application/json"));
    }
}
