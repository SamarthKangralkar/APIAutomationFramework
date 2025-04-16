package org.example.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Testintegrationsample {

    @Test(groups = "qa", priority = 1)
    @Owner("Samarth")
    @Description("TC1 Verify that booking can be created")
    public void create_booking(){
        Assert.assertTrue(true);
    }


    @Test(groups = "qa",priority = 2)
    @Owner("Samarth")
    @Description("TC2 Verify that booking by booking id")
    public void verify_booking_id(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 3)
    @Owner("samarth")
    @Description("TC3 Verify that we can update the booking")
    public void update_booking(){
        Assert.assertTrue(true);
    }

    @Test(groups = "qa",priority = 4)
    @Owner("samarth")
    @Description("TC3 Verify that we can delete the booking")
    public void delete_booking(){
        Assert.assertTrue(true);
    }



}
