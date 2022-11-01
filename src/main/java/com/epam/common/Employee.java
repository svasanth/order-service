package com.epam.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Employee  {

    private int empNo;
    private String name;
    private String deptName;

    private Long salary;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

/*
    @Override
    public int compareTo(Employee o) {
        return o.getName().compareTo(this.getName()) ;
    }
*/

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        //return this.name.equals((Employee)obj.)super.equals(obj);
        Employee employee = (Employee) obj;

        return employee.getName().equals(this.getName())
                && employee.getDeptName().equals(this.getDeptName())
                && employee.getEmpNo() == this.getEmpNo();
    }

    public static class EmployeeBuilder {
        private String name;

        public Employee build() {
            return new Employee();
        }

        public EmployeeBuilder setName(String name){
            this.name = name;
            return this;
        }
    }
}
