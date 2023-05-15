package mini_projects.EmployeeProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    private static List<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("1- İşçi ekleme");
            System.out.println("2- İşçi listeleme");
            System.out.println("3- İşçi güncelleme");
            System.out.println("4- İşçi silme");
            System.out.println("5- Tüm işçileri listeleme");
            System.out.println("6- Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    listEmployee(scanner);
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    listAllEmployees();
                    break;
                case 6:
                    System.out.println("Program sonlandırılıyor...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }

    private static void listAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("Henüz hiç işçi kaydedilmedi!");
        } else {
            for (Employee w : employees) {
                System.out.println(w);


            }
        }
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Designation: ");
        String designation = scanner.nextLine();

        System.out.print("Department: ");
        String department = scanner.nextLine();

        System.out.print("Salary: ");
        double salary = scanner.nextDouble();

        Employee employee = new Employee(id, name, age, designation, department, salary);
        employees.add(employee);

        System.out.println("İşçi başarıyla eklendi!");
    }

    private static void listEmployee(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        for (Employee w : employees) {
            if (w.getId() == id) {
                System.out.println(w);
                return;
            }
        }

        System.out.println("İşçi bulunamadı!");
    }

    private static void updateEmployee(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.print("Name: ");
                String name = scanner.nextLine();
                scanner.nextLine();
                employee.setName(name);

                System.out.print("Salary: ");
                double salary = scanner.nextDouble();
                employee.setSalary(salary);

                System.out.println("İşçi başarıyla güncellendi!");
                return;
            }
        }

        System.out.println("İşçi bulunamadı!");
    }

    private static void deleteEmployee(Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();

        for (Employee employee : employees) {
            if (employee.getId() == id) {
                employees.remove(employee);
                System.out.println("İşçi başarıyla silindi!");
                return;
            }
        }
    }

}
