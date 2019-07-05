package com.cskaoyan14th.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by little Stone
 * Date 2019/6/24 Time 17:47
 */
public class DateConverter implements Converter<String,Date> {
	@Override
	public Date convert(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			Date parse = simpleDateFormat.parse(s);
			return parse;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
