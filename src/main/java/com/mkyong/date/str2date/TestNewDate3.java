package com.mkyong.date.str2date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestNewDate3 {

    public static void main(String[] argv) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = "16/08/2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(formatter.format(localDate));

    }

}
