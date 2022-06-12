package openclosed;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GoodPractice {
    static class EmployeeManagementSystem {

        // Polymoprhism'den faydalanarak her Employee tipi için gerekli işlemler
        // ayrı sınıflarda farklı farklı tanımlanmış.
        // EmployeeManagementSystem, Employee sınıfının metotlarını çağırırken
        // onun tipini bilmeye ihtiyaç duymuyor.

        // Yeni çalışan tipleri eklendiğinde bu kod genişletmeye açık olacak fakat
        // sistem sınıfında değişiklik yapılmasına gerek kalmayacak.

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
            emp.setInitialDirectories();
        }
    }

    public static abstract class Employee {
        private String fullName;
        private List<String> initialDirectories;

        private List<String> directoriesWithPermission;
        private float salary;


        Employee(String fullName) {
            this.fullName = fullName;
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

        public String getFullName() {
            return fullName;
        }

        public abstract void setInitialDirectories();
    }

    static class Manager extends Employee {

        private static List<String> initialDirectories = List.of("./man_directory1", "./man_directory2",
                "./dev_directory1", "./ba_directory1");

        public void setInitialDirectories() {
            for (String dir:initialDirectories) {
                addPermissionToDirectory(dir);
            }
        }

        Manager(String fullName) {
            super(fullName);
        }
    }

    static class Developer extends Employee {

        private static List<String> initialDirectories = List.of("./dev_directory1", "./dev_directory2");

        public void setInitialDirectories() {
            for (String dir:initialDirectories) {
                addPermissionToDirectory(dir);
            }
        }

        Developer(String fullName) {
            super(fullName);
        }
    }

    static class BusinessAnalyst extends Employee {

        private static List<String> initialDirectories = List.of("./ba_directory1", "./ba_directory2");

        public void setInitialDirectories() {
            for (String dir:initialDirectories) {
                addPermissionToDirectory(dir);
            }
        }

        BusinessAnalyst(String fullName) {
            super(fullName);
        }
    }

    public static void main(String[] args) {
        Employee m1 = new Manager("Carole S. Stewart");
        Employee d1 = new Developer("Dustin E. Hood");
        Employee ba1 = new BusinessAnalyst("Lindsey R. Corey");

        EmployeeManagementSystem acc = new EmployeeManagementSystem();
        acc.addEmployee(d1);
        acc.addEmployee(m1);
        acc.addEmployee(ba1);

        acc.printPermittedDirectoriesForAll();

    }

}
