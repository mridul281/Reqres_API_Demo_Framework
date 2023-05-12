package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostRegisterUserUnsuccessfulTest {

    @Test
    public void postRegisterUserUnsuccessfulTest() {
        final String json ="{\"email\": \"mridul@biswas\"}";
        Response postRegisterUserUnsuccessfulTest = given().
                contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/register");
        postRegisterUserUnsuccessfulTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(400)
                .body("error", equalTo("Missing password"));


    }
}
