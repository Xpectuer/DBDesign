package com.zjut.azhen.DBDesign.utils;

public class DateUtil {
    /**
     * 在数字中填入横线使得 20200322 -> 2020-03-22
     * @param string string to be modified
     * @param insertStr char or string to insert in the  target string
     * @author alex
     */

    public static String parseDateFormat(String string,String insertStr){
        StringBuilder sb=new StringBuilder(string);
                sb.insert(4,insertStr);
        sb.insert(7,insertStr);
        return sb.toString();
    }
}
