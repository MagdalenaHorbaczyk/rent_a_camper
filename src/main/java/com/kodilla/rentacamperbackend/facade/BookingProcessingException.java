package com.kodilla.rentacamperbackend.facade;

public class BookingProcessingException extends Exception {
    public static String ERR_NOT_AUTHORISED = "User is not authorised";
//    public static String ERR_NOT_CALCULATED = "Total cost can not be calculated";


    public BookingProcessingException(String message) {
        super(message);
    }
}
