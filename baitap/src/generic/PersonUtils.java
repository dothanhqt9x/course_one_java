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

    public static String inputName(Scanner scanner, int index) {
        System.out.print("Nhập họ tên thứ " + index + ": ");
        Scanner scanner1 = new Scanner(System.in);
//        scanner.nextLine();
        return scanner1.nextLine();
    }
}
