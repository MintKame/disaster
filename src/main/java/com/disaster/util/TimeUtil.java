package com.disaster.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

    private static final SimpleDateFormat codeFormat = new SimpleDateFormat("yyyyMMddHHmmss");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String gmtCode2Time(String gmtCode) throws ParseException {
        Date date = codeFormat.parse(gmtCode);
        String gmtTime = timeFormat.format(date);
        return gmtTime;
    }
}
