package com.mkyong.date.format;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDate2 {
    public static void main(String[] args) {

        String now = "2016-11-09 10:30";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime formatDateTime = LocalDateTime.parse(now, formatter);

        System.out.println("Before : " + now);

        System.out.println("After : " + formatDateTime);

        System.out.println("After : " + formatDateTime.format(formatter));

    }
}
