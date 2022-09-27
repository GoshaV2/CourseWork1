package model;

public class Employee {
    private static int countEmployees = 0;
    private int id;
    private String fullName;
    private float salary;
    private String department;

    public Employee(String fullName, float salary, String department) {
        countEmployees += 1;
        id = countEmployees;
        this.fullName = fullName;
        this.salary = salary;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("{id: " + id + ", ");
        result.append("ФИО: " + fullName + ", ");
        result.append("Зарплата: " + salary + ", ");
        result.append("Отдел: " + department + "}");
        return result.toString();
    }
}
