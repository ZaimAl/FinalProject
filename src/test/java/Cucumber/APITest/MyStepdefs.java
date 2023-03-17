package Cucumber.APITest;

import Cucumber.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

public class MyStepdefs extends BaseTest {
    @Given("user have an API to access {string}")
    public void userHaveAnAPIToAccess(String api) {
        apiServer=api;
    }

    @And("user choose page \\({int}) and limit \\({int})")
    public void userChoosePageAndLimit(int one, int two) {
        page=one;
        limit=two;
    }

    @When("user send GET API respond")
    public void userSendGETAPIRespond() {
        response =  RestAssured.given().when()
                .header("app-id", appToken)
                .get(baseURL+"user?page="+page+"&limit="+limit)
                .then().log().all();
    }

    @Then("respond code should be \\({int})")
    public void respondCodeShouldBe(int statusCode) {
        Assert.assertEquals(response.statusCode(statusCode), response);
    }

    @And("respond should be page \\({int}) and limit \\({int})")
    public void respondShouldBePageAndLimit(int arg0, int arg1) {
        Assert.assertEquals(response.body("page", Matchers.equalTo(page)),response);
        Assert.assertEquals(response.body("limit", Matchers.equalTo(limit)),response);

    }

    @And("user change the information")
    public void userChangeTheInformation() {
        title = "miss";
        firstName = "Nadya";
        lastName = "Hanson";
        gender ="female";
    }

    @When("user send POST API respond")
    public void userSendPOSTAPIRespond() {
        String id="60d0fe4f5311236168a109fa";
        JSONObject bodyObj = new JSONObject();
        bodyObj.put("firstName", firstName);
        bodyObj.put("lastName", lastName);
        bodyObj.put("title", title);
        response= RestAssured.given().when()
                .header("app-id", appToken)
                .header("Content-type", "application/json")
                .header("Accept", "application/json")
                .body(bodyObj.toString())
                .when().put(baseURL+"user/"+id)
                .then().log().all();
    }

    @And("respond should be the information was change")
    public void respondShouldBeTheInformationWasChange() {
        Assert.assertEquals(response.body("firstName", Matchers.equalTo(firstName)),response);
    }

    @And("user input tag with {string}")
    public void userInputTagWith(String tag) {
        tags=tag;
    }

    @And("user input limit \\({int})")
    public void userInputLimit(int tes) {
        limit=tes;
    }

    @When("user send GET tag API respond")
    public void userSendGETTagAPIRespond() {
        response =  RestAssured.given().when()
                .header("app-id", appToken)
                .get(apiServer+tags+"/post?limit="+limit)
                .then().log().all();
    }
}
