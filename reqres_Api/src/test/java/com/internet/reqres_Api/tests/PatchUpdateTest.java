package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PatchUpdateTest {
    @Test
    public void patchUpdateTest() {
        final String json = "{\"name\": \"mridul\", \"job\": \"full stack sqa\"}";
        Response patchUpdateTest = given().
                contentType("application/json")
                .body(json)
                .when()
                .patch("https://reqres.in/api/users/2");
        patchUpdateTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("name", equalTo("mridul"))
                .body("job", equalTo("full stack sqa"));



    }
}
