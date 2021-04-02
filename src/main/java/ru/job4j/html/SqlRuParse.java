package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class SqlRuParse {
    private static long idCounter = 0;

    public static void main(String[] args) throws Exception {
        SqlRuDateTimeParser parsers = new SqlRuDateTimeParser();
        for (int j = 1; j <= 5; j++) {
            String url = String.format("https://www.sql.ru/forum/job-offers/%d", j);
            Document doc = Jsoup.connect(url).get();
            Elements row = doc.select(".postslisttopic");
            Elements date = doc.select("td[style='text-align:center'].altCol");
            for (int i = 0; i < row.size(); i++) {
                Element href = row.get(i).child(0);
                System.out.println(href.attr("href"));
                System.out.println(href.text());
                System.out.println(parsers.parse(date.get(i).text()));
            }
        }
    }

    public static Post parserPost(String url) throws IOException {
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        Document doc = Jsoup.connect(url).get();
        String title = doc.select(".messageHeader").get(0).text();
        String text = doc.select(".msgBody").get(1).text();
        Element date = doc.select(".msgFooter").get(0);
        String created = date.text().substring(0, 16);
        return new Post(idCounter++, title, text, url, parser.parse(created));
    }
}