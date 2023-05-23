package com.internet.reqres_Api.Tests.PostTestes;

import com.internet.reqres_Api.Tests.Protocol_Design.PostUtils;
import com.internet.reqres_Api.Tests.Utilities.GlobalData;
import com.internet.reqres_Api.Tests.Utilities.Resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;


public class PostCreateTest{
    String parameter = "/users";

    String POST_Creat_Users_EndPoint = GlobalData.Service_End_Point + GlobalData.Resource_End_Point + parameter;


    @Test
    public void postCreateTest() {
        System.out.println("POSTCreatUsers_EndPoint: " + POST_Creat_Users_EndPoint);


        Response postCreatTest = given().
                contentType("application/json")
                .body(PostUtils.Json_Post_Create_User)
                //.body(PostUtils.createUser(PostUtils.randomGivenUserName))
                .when()
                .post(POST_Creat_Users_EndPoint);

        postCreatTest.then()
                .assertThat()
                .time(lessThan(5000L))
                .statusCode(Resources.Successfully_Account_Created).log().all()
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
