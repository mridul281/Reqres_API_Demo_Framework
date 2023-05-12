package com.internet.reqres_Api.tests;

import org.testng.annotations.Test;
import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUserList {

    @Test
    public void getUserList() {
        Response getuserList = given().
                when().
                get("https://reqres.in/api/users?page=2");
        getuserList.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(200)
                .body("page", equalTo(2),
                        "per_page", equalTo(6),
                        "total", equalTo (12),
                        "total_pages", equalTo (2));
    }


}
