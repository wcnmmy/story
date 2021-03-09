package xyz.tpvillage.common;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: 朱兴平
 * @date: 2020/11/10
 */
@Component
public class DateConverter implements Converter<String,Date> {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private final String EMPTY_DATE_STRING = "0000-00-00 00:00:00";
    @Override
    public Date convert(String s) {
        Date date = null;
        if(EMPTY_DATE_STRING.equals(s)){
            return null;
        }
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}