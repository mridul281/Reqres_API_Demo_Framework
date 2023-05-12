package com.internet.reqres_Api.tests;

import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;
public class GetSingleUserNotFound {


    @Test
    public void getSingleUserNotFound() {

        Response getSingleUserNotFound = given().
                when().
                get("https://reqres.in/api/users/23");
        getSingleUserNotFound.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(404);
    }
}
