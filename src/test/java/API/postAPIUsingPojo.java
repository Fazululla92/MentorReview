package API;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class postAPIUsingPojo {
    static void main() {
        EmployeePOJO resp = new EmployeePOJO("Fazul","software Enginneer",
                new String[]{"restAssure,java"},"epam","fazul@gmail.com");
        Response PostResp = given().auth().none().header("Content-Type","application.JSON")
                .when().body(resp).post("https://reqres.in/api/users").then().statusCode(200).extract().response();

    }
}
