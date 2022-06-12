package openclosed;
import java.util.ArrayList;
import java.util.List;

public class BadPractice {
    static class EmployeeManagementSystem {

        // EmployeeManagementSystem sınıfındaki addEmployee metodu,
        // Employee tipi nesneyi alıyor ve oradaki tip bilgisine göre spesifik işlemler yapıyor.
        // Fakat bu durumda her yeni çalışan tipi için sistemdeki kodu da düzenlememiz gerekiyor.

        private List<Employee> employeeList;

        EmployeeManagementSystem() {
            employeeList = new ArrayList<>();
        }

        public void printPermittedDirectoriesForAll() {
            for (Employee emp:employeeList) {
                System.out.println(emp.getFullName());
                emp.printPermittedDirectories();
                System.out.println("--------------------");
            }
        }

        public void addEmployee(Employee emp) {
            employeeList.add(emp);
            if (emp.getType() == "manager") {
                emp.addPermissionToDirectory("./man_directory1");
                emp.addPermissionToDirectory("./man_directory2");
                emp.addPermissionToDirectory("./dev_directory1");
                emp.addPermissionToDirectory("./ba_directory1");
            } else if (emp.getType() == "developer") {
                emp.addPermissionToDirectory("./dev_directory1");
                emp.addPermissionToDirectory("./dev_directory2");
            } else if (emp.getType() == "business_analyst") {
                emp.addPermissionToDirectory("./ba_directory1");
                emp.addPermissionToDirectory("./ba_directory2");
            }
        }
    }

    static class Employee {
        private String fullName;
        private String type;
        private List<String> directoriesWithPermission;
        private float salary;

        Employee(String fullName, String type) {
            this.fullName = fullName;
            this.type = type;
            directoriesWithPermission = new ArrayList<>();
        }

        public void addPermissionToDirectory(String dir) {
            directoriesWithPermission.add(dir);
        }

        public void removePermissionToDirectory(String dir) {
            directoriesWithPermission.remove(dir);
        }

        public boolean hasPermissionToDirectory(String dir) {
            return directoriesWithPermission.contains(dir);
        }

        public void printPermittedDirectories() {
            for (String dir:directoriesWithPermission) {
                System.out.println(dir);
            }
        }

        public String getType() {
            return type;
        }

        public String getFullName() {
            return fullName;
        }
    }

    public static void main(String[] args) {
        Employee m1 = new Employee("Carole S. Stewart", "manager");
        Employee d1 = new Employee("Dustin E. Hood", "developer");
        Employee ba1 = new Employee("Lindsey R. Corey", "business_analyst");

        EmployeeManagementSystem acc = new EmployeeManagementSystem();
        acc.addEmployee(d1);
        acc.addEmployee(m1);
        acc.addEmployee(ba1);

        acc.printPermittedDirectoriesForAll();

    }

}
