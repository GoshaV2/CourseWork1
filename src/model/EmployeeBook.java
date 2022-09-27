package model;

public class EmployeeBook {
    private Employee[] employees;
    private int countEmployee; //количество рабочих
    private int size; //размер книги

    public EmployeeBook(int size) {
        employees = new Employee[5];
        countEmployee = 0;
        this.size = size;
        if (size == 0) {
            this.size += 1;
        }
    }

    public int getCountEmployee() {
        return countEmployee;
    }

    public int getSize() {
        return size;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void updateEmployee(String fullName, float newSalary, String newDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getFullName() == fullName) {
                employees[i].setDepartment(newDepartment);
                employees[i].setSalary((newSalary));
            }
        }
    }

    public void updateEmployee(String fullName, float newSalary) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getFullName() == fullName) {
                employees[i].setSalary((newSalary));
            }
        }
    }

    public void updateEmployee(String fullName, String newDepartment) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getFullName() == fullName) {
                employees[i].setDepartment(newDepartment);
            }
        }
    }

    public void indexAllSalary(int percent) {
        for (Employee employee :
                employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() * ((float) percent / 100 + 1));
            }
        }
    }

    public void addNewEmployee(String fullName, float salary, String department) {
        Employee employee = new Employee(fullName, salary, department);
        if (countEmployee == size) {
            resize(2);
        }
        for (int i = 0; i < size; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                countEmployee++;
                return;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                employees[i] = null;
                countEmployee--;
                return;
            }
        }
    }

    public Employee findEmployeeById(int id) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return employees[i];
            }
        }
        return null;
    }

    public Employee findEmployeeByFullName(String fullName) {
        for (int i = 0; i < size; i++) {
            if (employees[i] != null && employees[i].getFullName() == fullName) {
                return employees[i];
            }
        }
        return null;
    }

    public Employee[] findEmployeesInDepartment(String department) {
        Employee[] employees = new Employee[countEmployee];
        int k = 0; //счётчик работников в отделе
        for (int i = 0; i < size; i++) {
            if (this.employees != null && this.employees[i].getDepartment().equals(department)) {
                employees[k] = this.employees[i];
                k++;
            }
        }
        return employees;
    }

    public Employee findEmployeeWithMinSalary() {
        float salary = Float.MAX_VALUE;
        Employee findingEmployee = null;
        for (Employee employee :
                employees) {
            if (employee != null) {
                if (employee.getSalary() <= salary) {
                    salary = employee.getSalary();
                    findingEmployee = employee;
                }
            }
        }
        return findingEmployee;
    }

    public Employee findEmployeeWithMaxSalary() {
        float salary = Float.MIN_VALUE;
        Employee findingEmployee = null;
        for (Employee employee :
                employees) {
            if (employee != null) {
                if (employee.getSalary() >= salary) {
                    salary = employee.getSalary();
                    findingEmployee = employee;
                }
            }
        }
        return findingEmployee;
    }

    public float getSumSalary() {
        int sum = 0;
        for (Employee employee :
                employees) {
            if (employee != null) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float getAverageSalary() {
        return getSumSalary() / countEmployee;
    }

    public String[] getFullNameOfAllEmployees() {
        String[] fullName = new String[countEmployee];
        int k = 0; //счётчик
        for (Employee employee :
                employees) {
            if (employee != null) {
                fullName[k] = employee.getFullName();
                k++;
            }
        }
        return fullName;
    }

    public Employee findEmployeeWithMinSalaryInDepartment(String department) {
        float salary = Float.MAX_VALUE;
        Employee findingEmployee = null;
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() <= salary) {
                    salary = employee.getSalary();
                    findingEmployee = employee;
                }
            }
        }
        return findingEmployee;
    }

    public Employee findEmployeeWithMaxSalaryInDepartment(String department) {
        float salary = Float.MIN_VALUE;
        Employee findingEmployee = null;
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                if (employee.getSalary() >= salary) {
                    salary = employee.getSalary();
                    findingEmployee = employee;
                }
            }
        }
        return findingEmployee;
    }

    public int getCountEmployeeInDepartment(String department) {
        int countEmployees = 0;
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                countEmployees++;
            }
        }
        return countEmployees;
    }

    public float getSumSalaryInDepartment(String department) {
        int sum = 0;
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public float getAverageSalaryInDepartment(String department) {
        return getSumSalaryInDepartment(department) / getCountEmployeeInDepartment(department);
    }

    public String[] getFullNameOfAllEmployeesInDepartment(String department) {
        String[] fullName = new String[getCountEmployeeInDepartment(department)];
        int k = 0; //счётчик
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                fullName[k] = employee.getFullName();
                k++;
            }
        }
        return fullName;
    }

    public void indexAllSalaryInDepartment(int percent, String department) {
        for (Employee employee :
                employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() * ((float) percent / 100 + 1));
            }
        }
    }

    private void resize(int n) {
        Employee[] tempArray = new Employee[size];
        for (int i = 0; i < size; i++) {
            tempArray[i] = employees[i];
        }
        employees = new Employee[size * 2];
        for (int i = 0; i < size; i++) {
            employees[i] = tempArray[i];
        }
        size *= n;
    }
}
