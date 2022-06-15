package com.disaster.util;

public class StringUtil {
    public static String suffixOfFileName(String fileName){
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
