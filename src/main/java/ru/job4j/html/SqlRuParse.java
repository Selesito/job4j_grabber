package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

public class SqlRuParse {
    public static void main(String[] args) throws Exception {
        for (int j = 1; j <= 5; j++) {
            String url = String.format("https://www.sql.ru/forum/job-offers/%d", j);
            Document doc = Jsoup.connect(url).get();
            Elements row = doc.select(".postslisttopic");
            Elements date = doc.select("td[style='text-align:center'].altCol");

            SqlRuDateTimeParser parsers = new SqlRuDateTimeParser();
            for (int i = 0; i < row.size(); i++) {
                Element href = row.get(i).child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                System.out.println(parsers.parse(date.get(i).text()));
            }
        }

    }
}