package ru.job4j.design.srp;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.function.Predicate;

public class ReportJson implements Report {
    private Store store;

    public ReportJson(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Employee emp: store.findBy(filter)) {
            JSONObject employee = new JSONObject(emp);
            jsonArray.put(employee);
        }
        jsonObject.put("employees", jsonArray);
        return jsonObject.toString();
    }
}
