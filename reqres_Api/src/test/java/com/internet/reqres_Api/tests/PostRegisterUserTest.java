package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Configuration.BaseURL;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostRegisterUserTest extends BaseURL {

    @Test
    public void postRegisterUserTest() {

        final String json ="{\"email\": \"eve.holt@reqres.in\", \"password\": \"pistol\"}";
        Response postRegisterUserTest = given().
                contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register");
        postRegisterUserTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("token", equalTo("QpwL5tke4Pnpja7X4"));


    }

}
