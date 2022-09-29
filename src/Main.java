import model.Employee;
import model.EmployeeBook;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook(5);
        employeeBook.addNewEmployee("Т т т", 123f, "1");
        employeeBook.addNewEmployee("a a a", 1233232f, "2");
        employeeBook.addNewEmployee("b b b", 323123f, "3");
        employeeBook.addNewEmployee("g g g", 341412f, "4");
        employeeBook.addNewEmployee("u u u", 6757575f, "4");
        employeeBook.addNewEmployee("e e e", 123f, "4");

        Employee[] employees = employeeBook.getEmployees();
        float sumSalaryEmployees = employeeBook.getSumSalary();
        System.out.println("Сумма зарплат всех сотрудников: " + sumSalaryEmployees);
        employeeBook.updateEmployee("b b b", 1000f);
        Employee employee = employeeBook.findEmployeeById(3);
        System.out.println(employee.toString());
        employeeBook.removeEmployee(3);

        employeeBook.addNewEmployee("Иванов Иван Иванович", 5000f, "4");

        System.out.println("ФИО всех сотрудников в отеделе 1: " + Arrays.toString(employeeBook.getFullNameOfAllEmployeesInDepartment("1")));
        System.out.println("ФИО всех сотрудников в отеделе 2: " + Arrays.toString(employeeBook.getFullNameOfAllEmployeesInDepartment("2")));
        System.out.println("ФИО всех сотрудников в отеделе 3: " + Arrays.toString(employeeBook.getFullNameOfAllEmployeesInDepartment("3")));
        System.out.println("ФИО всех сотрудников в отеделе 4: " + Arrays.toString(employeeBook.getFullNameOfAllEmployeesInDepartment("4")));

        System.out.println("Сумма зарплат сотдруников в отделе 4: " + employeeBook.getSumSalaryInDepartment("4"));
        employeeBook.indexAllSalaryInDepartment(5, "4");
        System.out.println("Сумма зарплат сотдруников в отделе 4 после индексирования зарплат: " + employeeBook.getSumSalaryInDepartment("4"));

        System.out.println("Сотрудник с минимальной зарплатой: " + employeeBook.findEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной зарплатой: " + employeeBook.findEmployeeWithMaxSalary());

        System.out.println("Количество сотрудников: " + employeeBook.getCountEmployee());
        System.out.println("Количество сотрудников в 4 отделе: " + employeeBook.getCountEmployeeInDepartment("4"));
    }
}