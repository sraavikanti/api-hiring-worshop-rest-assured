import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

public class SampleTest {

    @Test
    public void shouldReturnUserDetailsWhenRequestMadeToGetSingleUser()
    {
       Response response= RestAssured.given()
                .baseUri("https://reqres.in/api/")
                .header("accept","application/json")
                .when()
                .get("users/2").then().assertThat().statusCode(200)
               .extract().response();

       JsonPath path=response.body().jsonPath();
       Assert.assertEquals(path.getInt("data.id"),2);
       Assert.assertEquals(path.getString("data.email"),"janet.weaver@reqres.in");

    }

    @Test
    public void shouldRegisterNewUserWhenRequestMadeToRegister()
    {

        RestAssured.given()
                .baseUri("https://reqres.in/api")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "\"email\": \"eve.holt@reqres.in\",\n" +
                        "\"password\": \"pistol\"\n" +
                        "}")
                 .when()
                 .post("/register")
                 .then().log().all()
                 .assertThat().statusCode(200)
                 .body("id",Matchers.equalTo(4));

    }
}
