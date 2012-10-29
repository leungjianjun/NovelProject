package com.woshuwu.util;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * Author: ljj
 * Date: 12-10-29
 * Time: 下午11:50
 */
public class DateTool {

    public static String format(Calendar calendar){
        return calendar.get(Calendar.YEAR)+"-"+calendar.get(Calendar.MONTH)+
                "-"+calendar.get(Calendar.DATE)+" "+calendar.get(Calendar.HOUR_OF_DAY)+":"+
                calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND);
    }
}
