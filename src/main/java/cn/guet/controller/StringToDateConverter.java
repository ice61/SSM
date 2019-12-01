package cn.guet.controller;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by WIN 10 on 2019/1/16.
 */
public class StringToDateConverter implements Converter<String,Date> {

    @Override
    public Date convert(String source) {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(source);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
            return null;

    }
}
