package ru.job4j.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

public class AlertRabbit {
    private static Connection connection;

    public static void main(String[] args) throws SQLException {
        try (InputStream in = AlertRabbit.class.getClassLoader()
                .getResourceAsStream("rabbit.properties")) {
            Properties config = new Properties();
            config.load(in);
            int interval = Integer.parseInt(config.getProperty("rabbit.interval"));
            Class.forName(config.getProperty("driver-class-name"));
            String url = config.getProperty("url");
            String login = config.getProperty("username");
            String password = config.getProperty("password");
            connection = DriverManager.getConnection(url, login, password);
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();
            JobDataMap data = new JobDataMap();
            data.put("connection", connection);
            JobDetail job = newJob(Rabbit.class)
                    .usingJobData(data)
                    .build();
            SimpleScheduleBuilder times = simpleSchedule()
                    .withIntervalInSeconds(interval)
                    .repeatForever();
            Trigger trigger = newTrigger()
                    .startNow()
                    .withSchedule(times)
                    .build();
            scheduler.scheduleJob(job, trigger);
            Thread.sleep(10000);
            scheduler.shutdown();
        } catch (SchedulerException | IOException | ClassNotFoundException
                | InterruptedException se) {
            se.printStackTrace();
        }
    }

    public static class Rabbit implements Job {
        @Override
        public void execute(JobExecutionContext context) throws JobExecutionException {
            Connection connection = (Connection) context.getJobDetail()
                    .getJobDataMap().get("connection");
            try (Statement statement = connection.createStatement()) {
                statement.execute("insert into rabbit(created_date)"
                        + " values(current_timestamp)");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
