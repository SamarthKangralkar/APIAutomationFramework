package org.example.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.asserts.AssertAction;
import org.example.endpoints.APIConstants;
import org.example.modules.Payloadmanager;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public ValidatableResponse validatableResponse;
    public Response response;
    public JsonPath jsonPath;
    public AssertAction assertAction;
    public Payloadmanager payloadmanager;

    @BeforeTest
    public void setup(){

        payloadmanager = new Payloadmanager();
        assertAction = new AssertAction();

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri(APIConstants.BASE_URL);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.log().all();




    }


}
