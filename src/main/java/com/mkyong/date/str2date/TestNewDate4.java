package com.mkyong.date.str2date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestNewDate4 {

    public static void main(String[] argv) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, MMM d yyyy");

        String date = "Tue, Aug 16 2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));

    }

}
