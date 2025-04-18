package org.example.tests.integration;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.http.ContentType;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.modules.Payloadmanager;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.example.pojos.TokenResponse;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class TestIntegrationFlow extends BaseTest {

    @Test(groups = "qa", priority = 1)
    @Owner("Samarth")
    @Description("TC1 Verify that booking can be created")
    public void create_booking(ITestContext iTestContext) {

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING_URL);
        requestSpecification.body(payloadmanager.payload()).when().post();

        response = requestSpecification.log().all().post();
        validatableResponse = response.then().statusCode(200);
        validatableResponse.statusCode(200);


        BookingResponse bookingResponse = payloadmanager.desirilization(response.asString());

        System.out.println("===================================");
        System.out.println(bookingResponse.getBookingid());
        System.out.println("===================================");

        iTestContext.setAttribute("bookingid",bookingResponse.getBookingid());


    }



    @Test(groups = "qa",priority = 2)
    @Owner("Samarth")
    @Description("TC2 Verify that booking by booking id")
    public void verify_booking_id(ITestContext iTestContext){
        System.out.println("]]]]]]]]]");
       System.out.println(iTestContext.getAttribute("bookingid"));

       Integer bid= (Integer) iTestContext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING_URL+"/"+bid);

        response=requestSpecification.when().log().all().get();
        validatableResponse = response.then().statusCode(200);
        validatableResponse.statusCode(200);

        Booking booking = payloadmanager.desirilization1(response.asString());
        System.out.println("{{{{{{}}}}}}}}}{{{{{{{}}}}}}}");
        System.out.println( booking.getFirstname());
        System.out.println( booking.getLastname());
        System.out.println( booking.getTotalprice());
        System.out.println( booking.getDepositpaid());
        System.out.println( booking.getBookingdates().getCheckin());
        System.out.println( booking.getBookingdates().getCheckout());
        System.out.println( booking.getAdditionalneeds());

    }

    @Test(groups = "qa",priority = 3)
    @Owner("samarth")
    @Description("TC3 Verify that we can update the booking")
    public void update_booking(ITestContext iTestContext){
        Assert.assertTrue(true);

        requestSpecification.basePath(APIConstants.AUTH_URL);
        requestSpecification.body(payloadmanager.token_creation()).when().post();

        response = requestSpecification.log().all().post();
        validatableResponse = response.then().statusCode(200);
        validatableResponse.statusCode(200);

        TokenResponse tokenResponse = payloadmanager.desirilization2_token(response.asString());
       String ttoken= tokenResponse.getToken();
        System.out.println(ttoken);

        //UPDATING USER DETAILS//
        Integer bid= (Integer) iTestContext.getAttribute("bookingid");
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING_URL+"/"+bid);
        requestSpecification.cookie("token",ttoken);
        iTestContext.setAttribute("token",ttoken);

        requestSpecification.body(payloadmanager.Update_Payload()).when().put();

        response = requestSpecification.log().all().put();
        validatableResponse = response.then().statusCode(200);
        validatableResponse.statusCode(200);

        Booking booking = payloadmanager.desirilization1(response.asString());
        System.out.println("{{{{{{}}}} UPDATED RESULTS }{{{{{{{}}}}}}}");
        System.out.println( booking.getFirstname());
        System.out.println( booking.getLastname());
        System.out.println( booking.getTotalprice());
        System.out.println( booking.getDepositpaid());
        System.out.println( booking.getBookingdates().getCheckin());
        System.out.println( booking.getBookingdates().getCheckout());
        System.out.println( booking.getAdditionalneeds());

    }



    @Test(groups = "qa",priority = 4)
    @Owner("samarth")
    @Description("TC3 Verify that we can delete the booking")
    public void delete_booking(ITestContext iTestContext){
        Assert.assertTrue(true);
        System.out.println("%%%%%%%%%%%%%%%%%%DELETE BOOKING%%%%%%%%%%%%%%%%%%%%%%");
        Integer did= (Integer) iTestContext.getAttribute("bookingid");
        String ttoken= (String) iTestContext.getAttribute("token");
        System.out.println(did);

        requestSpecification.basePath(APIConstants.UPDATE_BOOKING_URL+"/"+did);

        requestSpecification.cookie("token",ttoken);

        response=requestSpecification.delete();
        validatableResponse=response.then().log().all();
        validatableResponse.statusCode(201);




    }




}
