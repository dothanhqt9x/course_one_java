package generic;

import java.util.Scanner;

public class PersonUtils {

    public static Student inputStudent(Scanner scanner, int index) {
        System.out.println("Nhập thông tin sinh viên thứ " + index + ":");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        System.out.print("Tên: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Tuổi: ");
        int age = scanner.nextInt();
        return new Student(id, name, age);
    }

    public static Employee inputEmployee(Scanner scanner, int index) {
        System.out.println("Nhập thông tin nhân viên thứ " + index + ":");
        System.out.print("Id: ");
        int id = scanner.nextInt();
        System.out.print("Tên: ");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.print("Lương: ");
        double salary = scanner.nextDouble();
        return new Employee(id, name, salary);
    }

    public static String inputName(int index) {
        System.out.print("Nhập họ tên thứ " + index + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
