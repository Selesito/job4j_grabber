package ru.job4j.grabber;

import ru.job4j.html.SqlRuParse;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PsqlStore implements Store, AutoCloseable {

    private Connection cnn;

    public PsqlStore(Properties cfg) {
        try {
            Class.forName(cfg.getProperty("jdbc.driver"));
            cnn = DriverManager.getConnection(
                    cfg.getProperty("url"),
                    cfg.getProperty("username"),
                    cfg.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void save(Post post) {
        try (PreparedStatement statement = cnn
                .prepareStatement("insert into post(name, text, link, created) values (?, ?, ?,?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, post.getName());
            statement.setString(2, post.getText());
            statement.setString(3, post.getLink());
            statement.setTimestamp(4, Timestamp.valueOf(post.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    post.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try (PreparedStatement statement = cnn.prepareStatement("select * from post")) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    posts.add(new Post(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return posts;
    }

    @Override
    public Post findById(String id) {
        try (PreparedStatement statement =
                     cnn.prepareStatement("select * from post where id = ?")) {
            statement.setInt(1, Integer.parseInt(id));
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    return new Post(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("text"),
                            resultSet.getString("link"),
                            resultSet.getTimestamp("created").toLocalDateTime()
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        if (cnn != null) {
            cnn.close();
        }
    }

    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream in = PsqlStore.class
                .getClassLoader()
                .getResourceAsStream("grabber.properties")) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SqlRuParse sqlRuParse = new SqlRuParse();

        try {
            String linkOne = "https://www.sql.ru/forum/1325406/veb-razrabotchik";
            Post postOne = sqlRuParse.detail(linkOne);
            PsqlStore psqlStore = new PsqlStore(properties);
            psqlStore.save(postOne);
            String linkTwo = "https://www.sql.ru/forum/1325348/vakansiya-web-programmist";
            Post postTwo = sqlRuParse.detail(linkTwo);
            psqlStore.save(postTwo);

            Post postFindId  = psqlStore.findById(String.valueOf(postTwo.getId()));
            System.out.println(postFindId.getId());

            List<Post> rslPost = new ArrayList<>();
            rslPost = psqlStore.getAll();
            for (Post rsl : rslPost) {
                System.out.println(rsl.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}