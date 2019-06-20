package com.jalor.JavaTest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LN_20190401 {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Timestamp tt = new Timestamp(System.currentTimeMillis());
        String toDay = sdf.format(tt);
        Date date1 = null;
        try {
            date1 = sdf.parse(toDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
Integer ii = calLastedTime(date1);
        System.out.println(ii);
    }

    public static int calLastedTime(Date startDate) {
        long a = new Timestamp(System.currentTimeMillis()).getTime();
        long b = startDate.getTime();
        int c = (int)((a - b) / 1000);
        return c;
    }

}
