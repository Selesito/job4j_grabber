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

    private static final Map<Long, String> MONTHS = new HashMap<>();

    static {
        MONTHS.put(1L, "янв");
        MONTHS.put(2L, "фев");
        MONTHS.put(3L, "мар");
        MONTHS.put(4L, "апр");
        MONTHS.put(5L, "май");
        MONTHS.put(6L, "июн");
        MONTHS.put(7L, "июл");
        MONTHS.put(8L, "авг");
        MONTHS.put(9L, "сен");
        MONTHS.put(10L, "окт");
        MONTHS.put(11L, "ноя");
        MONTHS.put(12L, "дек");
    }

    private static final DateTimeFormatter FORMATTER = new  DateTimeFormatterBuilder()
            .appendPattern("d ")
            .appendText(ChronoField.MONTH_OF_YEAR, MONTHS)
            .appendPattern(" yy, ")
            .appendPattern("HH:mm")
            .toFormatter();

    @Override
    public LocalDateTime parse(String pars) {
        LocalDateTime date;
        int index = pars.indexOf(",");
        if (pars.contains("сегодня")) {
            int[] time = parseTime(pars, index);
            date = LocalDate.now().atTime(time[0], time[1]);
        } else if (pars.contains("вчера")) {
            int[] time = parseTime(pars, index);
            date = LocalDate.now().atTime(time[0], time[1]).minusDays(1);
        } else {
            date = LocalDateTime.parse(pars, FORMATTER);
        }
        return date;
    }

    private int[] parseTime(String pars, int index) {
        pars = pars.substring(index + 2);
        String[] rsl = pars.split(":");
        int hours = Integer.parseInt(rsl[0]);
        int minutes = Integer.parseInt(rsl[1]);
        return new int[] {hours, minutes};
    }
}


