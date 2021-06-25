package io.codegitz.spring.dmz.service;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 张观权
 * @date 2021/2/5 15:54
 **/
public class ConverterStr2Date implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(source);
        } catch (ParseException e) {
            return null;
        }
    }
}