package com.mkyong.date;

import java.time.*;

public class InstantExample2 {

    public static void main(String[] argv) {

		// Hard code a date time
        LocalDateTime dateTime = LocalDateTime.of(2016, Month.AUGUST, 18, 6, 17, 10);

        System.out.println("LocalDateTime : " + dateTime);

        // Convert LocalDateTime to Instant, UTC+0
        Instant instant = dateTime.toInstant(ZoneOffset.UTC);

        System.out.println("Instant : " + instant);

    }

}
