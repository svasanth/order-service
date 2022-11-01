package com.epam.test;

import java.util.*;
import java.util.stream.Collectors;

public class Task {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();

        Map<String , Long> stringListMap = new HashMap<>();

        stringListMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
    }

    class Employee {
        private String name;
        private String department;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }
    }
}
