package com.cloudwalker.clone;

public class CloneDemo {

    public static void main(String[] args) throws CloneNotSupportedException {

        Department dept = new Department(1, "Human Resource");

        Employee originalEmp = new Employee(1, "Admin", dept);
        Employee clonedEmp = (Employee) originalEmp.clone();

        clonedEmp.getDepartment().setDepartmentName("Manufactoring");

        System.out.println(originalEmp.getDepartment().getDepartmentName());
        System.out.println(clonedEmp.getDepartment().getDepartmentName());
    }
}
