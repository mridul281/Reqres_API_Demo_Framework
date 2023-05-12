package com.internet.reqres_Api.tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class GetApiSingleOnlyUnknownNotFound {

    @Test
    public void getApiSingleOnlyUnknownNotFound() {

        Response getApiSingleOnlyUnknownNotFound = given().
                when().
                get("https://reqres.in/api/unknown/23");
        getApiSingleOnlyUnknownNotFound.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(404);
    }
}
