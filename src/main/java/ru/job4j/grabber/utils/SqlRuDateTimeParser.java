package ru.job4j.grabber.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;

public class SqlRuDateTimeParser implements DateTimeParser {
    @Override
    public LocalDateTime parse(String pars) {
        LocalDateTime date;

        Map<Long, String> monthName = new HashMap<>();
        monthName.put(1L, "янв");
        monthName.put(2L, "фев");
        monthName.put(3L, "мар");
        monthName.put(4L, "апр");
        monthName.put(5L, "май");
        monthName.put(6L, "июн");
        monthName.put(7L, "июл");
        monthName.put(8L, "авг");
        monthName.put(9L, "сен");
        monthName.put(10L, "окт");
        monthName.put(11L, "ноя");
        monthName.put(12L, "дек");

        DateTimeFormatter formatter = new  DateTimeFormatterBuilder()
                .appendPattern("d ")
                .appendText(ChronoField.MONTH_OF_YEAR, monthName)
                .appendPattern(" yy, ")
                .appendPattern("HH:mm")
                .toFormatter();

        int index = pars.indexOf(",");
        if (pars.contains("сегодня")) {
            pars = pars.substring(index + 2);
            String[] rsl = pars.split(":");
            int hours = Integer.parseInt(rsl[0]);
            int minutes = Integer.parseInt(rsl[1]);
            date = LocalDate.now().atTime(hours, minutes);
        } else if (pars.contains("вчера")) {
            pars = pars.substring(index + 2);
            String[] rsl = pars.split(":");
            int minutes = Integer.parseInt(rsl[1]);
            int hours = Integer.parseInt(rsl[0]);
            date = LocalDate.now().atTime(hours, minutes).minusDays(1);
        } else {
            date = LocalDateTime.parse(pars, formatter);
        }
        return date;
    }
}


