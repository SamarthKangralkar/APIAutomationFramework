package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

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



    public String token_creation(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");

        String json_token=gson.toJson(auth);
        System.out.println(json_token);

        return json_token;
    }






    public String Update_Payload(){

        Booking booking = new Booking();

        booking.setFirstname("varsha");
        booking.setLastname("Kangralakr");
        booking.setTotalprice(981);
        booking.setDepositpaid(false);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-07-9");
        bookingdates.setCheckout("2009-09-09");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Dinner");

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

    public Booking desirilization1(String bookverify){

        Booking booking = gson.fromJson(bookverify,Booking.class);
        return booking;
    }

    public TokenResponse desirilization2_token(String token){
        TokenResponse tokenResponse=gson.fromJson(token,TokenResponse.class);
        return tokenResponse;
    }



}
