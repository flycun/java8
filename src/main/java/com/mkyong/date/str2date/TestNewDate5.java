package com.mkyong.date.str2date;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestNewDate5 {

    public static void main(String[] argv) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");

        String date = "Tuesday, Aug 16, 2016 12:10:56 PM";

        LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

        System.out.println(localDateTime);

        System.out.println(formatter.format(localDateTime));

    }

}
