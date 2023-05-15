package com.internet.reqres_Api.tests.Configuration;
import org.junit.Before;

import static io.restassured.RestAssured.baseURI;


public class BaseURL {

    @Before
    public void before() {
        baseURI = "https://reqres.in/";
    }

}
