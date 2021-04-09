package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

public class ReportEngineTest {

    private MemStore store = new MemStore();
    private WriteReport write = new WriteReport("./db/report.html");
    private Calendar now = Calendar.getInstance();
    private Employee worker = new Employee("Ivan", now, now, 100);
    private Employee worker1 = new Employee("Petr", now, now, 180);
    private Employee worker2 = new Employee("Vasya", now, now, 130);

    @Test
    public void whenOldGenerated() throws JAXBException {
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedHR() throws JAXBException {
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report hr = new ReportHR(store);
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
        assertThat(hr.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedProgrammer() throws JAXBException {
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report programmer = new ReportProgrammer(store, write);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getHired()).append(";")
                .append(worker1.getFired()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getHired()).append(";")
                .append(worker2.getFired()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(programmer.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenGeneratedJson() throws JAXBException {
        store.add(worker);
        Report json = new ReportJson(store);
        String expected = "{\"employees\":[{\"name\":\"Ivan\",\"salary\":100}]}";
        assertThat(json.generate(em -> true), is(expected));
    }

    @Test
    public void whenGeneratedXML() throws JAXBException {
        store.add(worker);
        Report report = new ReportXml(store);
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<employee name=\"Ivan\" salary=\"100.0\"/>\n";
        assertThat(report.generate(em -> true), is(expected));

    }
}