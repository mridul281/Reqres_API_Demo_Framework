package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DeleteTest {

    @Test
    public void deleteTest() {
        Response deleteTest = given().
                when().
                delete("https://reqres.in/api/users/2");
        deleteTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(204);
    }
}
