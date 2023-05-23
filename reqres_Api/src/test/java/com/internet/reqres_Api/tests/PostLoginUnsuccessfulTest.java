package com.internet.reqres_Api.tests;

import com.internet.reqres_Api.tests.Protocol_Design.PostUtils;
import com.internet.reqres_Api.tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostLoginUnsuccessfulTest {

    String parameter = "/login";
    String POST_login_Unsuccessful_EndPoint = Resources.Service_End_Point + Resources.Resource_End_Point + parameter;

    @Test
    public void postLoginUnsuccessfulTest() {
        System.out.println("POSTloginUnsuccessful_EndPoint: " + POST_login_Unsuccessful_EndPoint);



        Response postLoginUnsuccessfulTest = given().
                contentType("application/json")
                .body(PostUtils.getJson_POST_Login_Unsuccessful)
                .when()
                .post(POST_login_Unsuccessful_EndPoint);
        postLoginUnsuccessfulTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Clint_Error_Bad_Request)
                .body("error", equalTo("Missing password"));



    }

}
