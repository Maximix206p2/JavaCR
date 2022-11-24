package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//где салонку подстелить, сферический конь в вакууме )))
//«i18n» vs «l10n»
public class Zodiac {
    private static int count = 13;
    private static String[] signs = {"Aries", "Taurus", "Gemini", "Cancer", "Leo", "Virgo",
            "Libra", "Scorpio", "Sagittarius", "Capricorn", "Capricorn", "Aquarius", "Pisces"};
    private static String[][] dates = {{"21.03", "20.04"}, {"21.04", "21.05"}, {"22.05", "21.06"},
            {"22.06", "22.07"}, {"23.07", "22.08"}, {"23.08", "23.09"},
            {"24.09", "23.10"}, {"24.10", "22.11"}, {"23.11", "21.12"},
            {"22.12", "31.12"}, {"1.01", "20.01"}, {"21.01", "19.02"}, {"20.02", "20.03"}};

    public static void main(String[] args) throws ParseException {
        /*int language = 0; // Для приложения
        Locale locale = null;
        if (language == 0)
            locale = new Locale("en", "US");
        else if (language == 1)
            locale = new Locale("ru", "RU");*/

        Locale localeRU = new Locale("ru", "RU");
        Locale localeEN = new Locale("en", "US");

        ResourceBundle bundleRU = ResourceBundle.getBundle("com/company/resources/Signs", localeRU);
        ResourceBundle bundleEN = ResourceBundle.getBundle("com/company/resources/Signs", localeEN);

        //String quest = bundleRU.getString("quest");
        //System.out.println(quest);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date of your birth in format dd.MM.yyyy: ");
        String date = scanner.next();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date birthday = simpleDateFormat.parse(date);

        Calendar calendar = new GregorianCalendar(); //Дата рождения
        calendar.setTime(birthday);

        System.out.printf("Month: %s \nDay: %s%n", calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));

        int index = -1;
        Calendar calendarBegin = new GregorianCalendar();
        calendarBegin.setTime(birthday);
        Calendar calendarEnd = new GregorianCalendar();
        calendarEnd.setTime(birthday);
        for (int i = 0; i < count; i++) {
            calendarBegin.set(calendar.get(Calendar.YEAR), getMonth(dates[i][0]), getDay(dates[i][0]));
            calendarEnd.set(calendar.get(Calendar.YEAR), getMonth(dates[i][1]), getDay(dates[i][1]));
            //System.out.println(calendar.getTime());
            //System.out.println(calendarBegin.getTime());
            if (calendar.getTime().compareTo(calendarBegin.getTime()) == 0)
                calendar.add(Calendar.SECOND, 1);

            if (calendar.getTime().after(calendarBegin.getTime())
                    && calendar.getTime().before(calendarEnd.getTime()))
                index = i;
        }
        //System.out.println(signs[index]);
        String signOfZodiacRU = bundleRU.getString(signs[index]);
        String signOfZodiacEN = bundleEN.getString(signs[index]);
        System.out.println("Вы " + signOfZodiacRU);
        System.out.println("You are " + signOfZodiacEN);
    }

    static int getMonth(String sdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM");
        Date date = simpleDateFormat.parse(sdate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH);
    }

    static int getDay(String sdate) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM");
        Date date = simpleDateFormat.parse(sdate);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}