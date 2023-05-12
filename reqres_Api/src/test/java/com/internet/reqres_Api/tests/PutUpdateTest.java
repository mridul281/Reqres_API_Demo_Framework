package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PutUpdateTest {

    @Test
    public void putUpdateTest() {
        final String json = "{\"name\": \"mridul\", \"job\": \"junior qa\"}";

        Response putUpdateTest = given().
                contentType("application/json")
                .body(json)
                .when()
                .put("https://reqres.in/api/users/2");
        putUpdateTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("name", equalTo("mridul"))
                .body("job", equalTo("junior qa"));



    }
}
