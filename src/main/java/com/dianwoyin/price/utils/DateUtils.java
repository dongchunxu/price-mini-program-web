package com.dianwoyin.price.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author chunxu.dong
 * @date 2021/6/7
 */
public class DateUtils {

    public static Date getStartTimeOfDay(Date date, int beforeDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, -beforeDays);
        c.set(Calendar.HOUR, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getEndTimeOfDay(Date date, int beforeDays) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, -beforeDays);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        return c.getTime();
    }
}
