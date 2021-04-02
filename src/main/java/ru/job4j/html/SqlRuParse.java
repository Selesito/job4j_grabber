package ru.job4j.html;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.Parse;
import ru.job4j.grabber.Post;
import ru.job4j.grabber.utils.SqlRuDateTimeParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParse implements Parse {
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

    @Override
    public List<Post> list(String link) throws IOException {
        List<Post> posts = new ArrayList<>();
        Document doc = Jsoup.connect(link).get();
        Elements row = doc.select(".postslisttopic");
        for (int i = 0; i < row.size(); i++) {
            Element href = row.get(i).child(0);
            posts.add(detail((href.attr("href"))));
        }
        return posts;
    }

    @Override
    public Post detail(String link) throws IOException {
        SqlRuDateTimeParser parser = new SqlRuDateTimeParser();
        Document doc = Jsoup.connect(link).get();
        String title = doc.select(".messageHeader").get(0).text();
        String text = doc.select(".msgBody").get(1).text();
        String date = doc.select(".msgFooter").get(0).text();
        String created = date.substring(0, date.indexOf('[') - 1);
        return new Post(idCounter++, title, text, link, parser.parse(created));
    }
}