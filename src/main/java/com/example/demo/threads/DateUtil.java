package com.example.demo.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static ThreadLocal<SimpleDateFormat> format1 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static String formatDate(Date date) {
        return format1.get().format(date);
    }


    public static void main(String[] args){
        Date date = new Date();
       String formatStr=formatDate(date);
       System.out.println(formatStr);

    }
}