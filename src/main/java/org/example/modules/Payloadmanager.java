package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.example.pojos.Bookingdates;

public class Payloadmanager {
Gson gson = new Gson();

    public String payload(){

        Booking booking = new Booking();

        booking.setFirstname("Samarth");
        booking.setLastname("Kangralakr");
        booking.setTotalprice(881);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-06-9");
        bookingdates.setCheckout("2019-09-09");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        String jsonStringPayload=gson.toJson(booking);
        System.out.println(jsonStringPayload);


        return jsonStringPayload;
    }


    public BookingResponse desirilization(String responseString){

        BookingResponse bookingResponse = gson.fromJson(responseString,BookingResponse.class);
//        bookingResponse.getBookingid();
//        bookingResponse.getBooking().getFirstname();
//        bookingResponse.getBooking().getLastname();
        return bookingResponse;
    }



}
