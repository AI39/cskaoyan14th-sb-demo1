package com.cskaoyan14th.vo;

import com.cskaoyan14th.converter.DateConverter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCurrentTime {
    public static Date dateCurrentTime(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        DateConverter dateConverter = new DateConverter();
        Date convert = dateConverter.convert(format);
        return convert;
    }
}
