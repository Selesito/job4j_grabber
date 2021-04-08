package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ReportEngine implements Report {
    private Store store;
    private WriteReport writeReport;

    public ReportEngine(Store store, WriteReport writeReport) {
        this.store = store;
        this.writeReport = writeReport;
    }

    @Override
    public String generate(Predicate<Employee> filter, String file) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        writeReport.write(text.toString(), writeReport.getFile());
        return text.toString();
    }
}
