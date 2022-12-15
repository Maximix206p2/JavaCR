package com.company;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.*;

//https://jsonformatter.curiousconcept.com/#
public class WriteLog {
    private final static Logger logger = Logger.getLogger(WriteLog.class.getClass().getName());

    public static void main(String[] args) throws FileNotFoundException {
        //Получить праздничные дни из файла
        FileReader file = new FileReader("src/com/company/data/holidays.json");
        JSONTokener tokener = new JSONTokener(file);
        JSONArray holidays = new JSONArray(tokener);
        //System.out.println(holidays.get(0).toString());

        LogManager.getLogManager().reset(); //Не выводить в консоль

        FileHandler fh;
        try {
            // This block configure the logger with handler and formatter
            fh = new FileHandler("src/com/company/data/logFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.setLevel(Level.INFO); //разные уровни ошибок info/severe/fine/finer/finest...
                                     //https://habr.com/ru/post/247647/
        //Вывод в лог
        for (Object holiday:holidays){
            String s = ((JSONObject)holiday).getString("name").toString();
            String sDate = ((JSONObject)holiday).getString("date").toString();
            logger.info(s+" "+sDate);
            //logger.fine(s);
        }
    }
}
