package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Dates {
    public static void main(String[] args) {
        long start = System.currentTimeMillis(); //1970
        for (long i=0; i<1000_000_000L; i++){

        }
        long end = System.currentTimeMillis();
        System.out.println();

        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatted = dateTimeFormatter.format(dateTime);
        System.out.println(formatted);

        Calendar calendar = new GregorianCalendar();
        calendar.set(2022,11,15);
        System.out.println(calendar.getTime());

        calendar.add(Calendar.MONTH, -100);
        System.out.println(calendar.getTime());

        TimeZone timeZone = TimeZone.getDefault();
        System.out.println(timeZone.getDisplayName()+" " + timeZone.getID());
    }
}

