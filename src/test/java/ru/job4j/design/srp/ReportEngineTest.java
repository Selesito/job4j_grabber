package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;

public class ReportEngineTest {
    @Ignore
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        WriteReport write = new WriteReport("./db/report.html");
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store, write);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true, "./db/report.html"), is(expect.toString()));
    }

    @Test
    public void whenOldGeneratedHR() {
        MemStore store = new MemStore();
        WriteReport write = new WriteReport("./db/report.html");
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Petr", now, now, 180);
        Employee worker2 = new Employee("Vasya", now, now, 130);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report engine = new ReportEngine(store, write);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true, "./db/report.html"), is(expect.toString()));
    }
}