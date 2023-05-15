package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Configuration.BaseURL;
import io.restassured.response.*;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class GetSingleUser extends BaseURL {

    @Test
    public void getSingleUser() {
        Response getSingleuser = given().
                when().
                get("https://reqres.in/api/users/2");
        getSingleuser.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));




    }

}
