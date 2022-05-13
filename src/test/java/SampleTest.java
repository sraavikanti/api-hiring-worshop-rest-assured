import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void getUserTest()
    {
       Response response= RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2/")
                .header("accept","application/json")
                .param("username","sampleusername1")
                .param("password","samplepassword")
                .when()
                .get("user/login").then().assertThat().statusCode(200)
               .extract().response();

       JsonPath path=response.body().jsonPath();
       String message=path.get("message");
       Assert.assertEquals(message.split(":")[0],"logged in user session");
       Assert.assertTrue(Long.parseLong(message.split(":")[1])>1);

    }

    @Test
    public void createUserTest()
    {

        RestAssured.given()
                .baseUri("https://petstore.swagger.io/v2/")
                .header("Content-Type","application/json")
                .header("accept","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"sampleusername1\",\n" +
                        "  \"firstName\": \"samplefirstname\",\n" +
                        "  \"lastName\": \"samplelastname\",\n" +
                        "  \"email\": \"sampleemail\",\n" +
                        "  \"password\": \"samplepassword\",\n" +
                        "  \"phone\": \"samplephone\",\n" +
                        "  \"userStatus\": 3\n" +
                        "}").when().
                post("user")
                .then().assertThat().statusCode(200).
                body("message",Matchers.equalTo("1"));

    }
}
