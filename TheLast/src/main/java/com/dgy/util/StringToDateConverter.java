package com.dgy.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Date: 2019/7/11
 * Time: 16:49
 * Author: vincent-Dou
 * Description：
 */
@Component
public class StringToDateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        if(s == null){
            return new Date(new java.util.Date().getTime());
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return new Date(dateFormat.parse(s).getTime());
        } catch (ParseException e) {
            throw new RuntimeException();
        }
    }
}
