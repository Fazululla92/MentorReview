package API.API;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetDetails extends BaseAPI{
        @Test
        public void getPost() {
//            given().when().get("/posts/1").then().statusCode(200).body("id",equalsTo(1));
    }
}

class BaseAPI{
    @BeforeClass
    public void setUp(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

    }
}
