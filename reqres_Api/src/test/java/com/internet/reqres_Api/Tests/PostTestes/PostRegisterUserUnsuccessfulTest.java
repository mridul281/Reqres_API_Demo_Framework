package com.internet.reqres_Api.Tests.PostTestes;

import com.internet.reqres_Api.Tests.Protocol_Design.PostUtils;
import com.internet.reqres_Api.Tests.Utilities.GlobalData;
import com.internet.reqres_Api.Tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class PostRegisterUserUnsuccessfulTest {

    String parameter = "/register";
    String POST_Register_UserUnsuccessful_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;

    @Test
    public void postRegisterUserUnsuccessfulTest() {

        System.out.println("POSTRegisterUserUnsuccessful_EndPoint: " + POST_Register_UserUnsuccessful_EndPoint);


        Response postRegisterUserUnsuccessfulTest = given().
                contentType("application/json")
                .body(PostUtils.json_POST_RegisterUserUnsuccessful)
                .when()
                .post(POST_Register_UserUnsuccessful_EndPoint);
        postRegisterUserUnsuccessfulTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Clint_Error_Bad_Request).log().all()
                .body("error", equalTo("Missing password"));


    }
}
