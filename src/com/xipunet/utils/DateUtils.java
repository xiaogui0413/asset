package com.xipunet.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class DateUtils {
  public static String PATTERN_1 = "yyyy-MM-dd";
  public static String PATTERN_1_1 = "yyyy年MM月dd日";
  public static String PATTERN_2 = "yyyy-MM-dd HH:mm:ss";
  public static String PATTERN_3 = "yyyyMMddHHmmss";
  public static String PATTERN_4 = "yyyy-MM-dd HH:mm";
  public static String PATTERN_TIMESTAMP = "yyyyMMddHHmmss";

  public static String format(Date date) {
    return format(date,PATTERN_1);
  }
  public static String format(Long time, String pattern) {
    Date date = parserByLong(time);
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  public static String format(Date date, String pattern) {
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  public static String format1(Long time) {
    return format(time, PATTERN_1);
  }

  public static String format11(Long time) {
    return format(time, PATTERN_1_1);
  }

  public static String format1(Date time) {
    return format(time, PATTERN_1);
  }

  public static String format2(Long time) {
    return format(time, PATTERN_2);
  }

  public static String format3(Long time) {
    return format(time, PATTERN_3);
  }

  public static String format4(Long time) {
    return format(time, PATTERN_4);
  }

  public static String format4(Date time) {
    return format(time, PATTERN_4);
  }

  public static Date parserByLong(Long time) {
    if (time == null)
      return null;
    Date date = new Date();
    date.setTime(time);
    return date;
  }

  public static String timestamp() {
    return format(new Date(), PATTERN_TIMESTAMP);
  }
}
