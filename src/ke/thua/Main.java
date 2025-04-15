package ke.thua;

import java.util.Scanner;

public class Main {

    public static void bai1() {
        Circle circle = new Circle(5, 10, 15);
        circle.Circuit();
        circle.Area();
    }

    public static void bai2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập loại nhân viên (staff/engineer/worker): ");
        String inputType = scanner.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giới tính nhân viên: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập tuổi nhân viên: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nhập địa chỉ nhân viên: ");
        String address = scanner.nextLine();

        OfficersManagement management = new OfficersManagement(name, gender, age, address, Officers.OfficerType.valueOf(inputType.toUpperCase()));

        switch (management.officerType) {
            case STAFF:
                System.out.print("Nhập công việc: ");
                String nameOfWork = scanner.nextLine();
                management.createStaff(name, gender, age, address, nameOfWork);
                break;
            case WORKER:
                System.out.print("Nhập bậc 1-10: ");
                int level = scanner.nextInt();
                if (level > 10 || level < 1) {
                    System.out.print("Bậc lương không hợp lệ!!");
                    break;
                }
                management.createWorker(name, gender, age, address, level);
                break;
            case ENGINEER:
                System.out.print("Nhập ngành đào tạo: ");
                String trainingIndustry = scanner.nextLine();
                management.createEngineer(name, gender, age, address, trainingIndustry);
                break;
        }

        scanner.close();
    }


    public static void main(String[] args) {
//        bai1();
        bai2();
    }
}
