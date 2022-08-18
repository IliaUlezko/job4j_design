package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonPOJO {
    public static void main(String[] args) {
        JSONObject jsonDepartment = new JSONObject(
                "{\"id\": 1234,\" division \" : \"office\"}");

        List<String> data = new ArrayList<>();
        data.add("+7(999)1001111");
        data.add("Lenin avenue, 23");
        JSONArray jsonContacts = new JSONArray(data);

        final Employee employee = new Employee("Victor", 30, false,
                new Department(1234, "office"),
                new String[] {"+7(999)1001111", "Lenin avenue, 23"});

        JSONObject jsonEmployee = new JSONObject();
        jsonEmployee.put("name", employee.getName());
        jsonEmployee.put("age", employee.getAge());
        jsonEmployee.put("distant work", employee.isDistantWork());
        jsonEmployee.put("department", jsonDepartment);
        jsonEmployee.put("contacts", jsonContacts);

        System.out.println(jsonEmployee);

        System.out.println(new JSONObject(employee));
    }
}