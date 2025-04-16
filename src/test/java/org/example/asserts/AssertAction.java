package org.example.asserts;

import io.restassured.response.Response;
import org.testng.Assert;

import static org.assertj.core.api.Assertions.assertThat;


public class AssertAction {
    public void Verify_Response_body(String Actual,String Expected,String Description){
        Assert.assertEquals(Actual,Expected,Description);
    }

    public void Verify_Response_body(String Actual,int Expected,String Description){
        Assert.assertEquals(Actual,Expected,Description);
    }

    public void Verify_Status_Code(Response response, int Expected){
        Assert.assertEquals(response.getStatusCode(),Expected);
    }

    public void Verify_Stringkey(String KeyExpect,String KeyActual) {

        assertThat(KeyExpect).isNotNull();
        assertThat(KeyExpect).isNotNull().isNotBlank();
        assertThat(KeyExpect).isEqualTo(KeyActual);


    }


}

