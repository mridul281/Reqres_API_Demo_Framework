package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;



public class PostCreateTest {

    @Test
    public void postCreateTest() {

        final String json = "{\"name\": \"mridul\", \"job\": \"qa engineer\"}";
        Response postCreatTest = given().
                contentType("application/json")
                .body(json)
                .when()
                .post("https://reqres.in/api/user");

        postCreatTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(201)
                .body("name", equalTo("mridul"))
                .body("job", equalTo("qa engineer"));


                /*
                .contentType("application/json")
                .body(json)
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .contentType("application/json")
                 */


    }


}
