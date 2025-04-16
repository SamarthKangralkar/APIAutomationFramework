package org.example.tests.curd;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.example.asserts.AssertAction;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.annotations.Test;

public class Create_booking extends BaseTest {
    @Test(groups = "qa")
    @Description("Verify whether the booking is been created")
    @Owner("Samarth")
    @TmsLink("https://samarthkangralkar.atlassian.net/jira")
    @Issue("https://samarthkangralkar.atlassian.net/jira/software")

    public void verify_booking(){
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING_URL);
       response= requestSpecification.body(payloadmanager.payload()).when().post();

       validatableResponse = response.then().log().all();
       validatableResponse.statusCode(200);

        BookingResponse bookingResponse= payloadmanager.desirilization(response.asString());

        assertAction.Verify_Stringkey(bookingResponse.getBooking().getFirstname(),"Samarth");


    }
}
