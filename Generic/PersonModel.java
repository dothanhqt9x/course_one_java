package Generic;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel<T> {
    public ArrayList<T> li = new ArrayList<T>();

    public void addObject(T object){
        li.add(object);
    }
    public void display(){
        for (T e:li){
            System.out.println(e);
        }
    }

    //Tạo sinh vien
    public static void createStudent()  {
        PersonModel<Student> studentPersonModel = new PersonModel<>();
        // Thêm sinh viên
        studentPersonModel.addObject(new Student(1,"Hoang Văn A", 20));
        studentPersonModel.addObject(new Student(2,"Nguyen Thị B", 22));
        // Hiển thi sinh viên
        System.out.println("Danh sách sinh viên:");
        studentPersonModel.display();
    }

    //Tạo nhân viên
    public static void createEmployee()  {
        PersonModel<Employee> employeePersonModel = new PersonModel<>();
        // Thêm nhân viên
        System.out.println("Thêm nhân viên");
        employeePersonModel.addObject(new Employee(1,"Hoang Văn A", 20));
        employeePersonModel.addObject(new Employee(2,"Nguyen Thị B", 22));
        // Hiển thi nhân viên
        System.out.println("Danh sách nhân viên:");
        employeePersonModel.display();
    }

    public static void createString() {
        PersonModel<String> stringPersonModel = new PersonModel<>();
        // Thêm string
        System.out.println("Thêm nhân viên");
        stringPersonModel.addObject("Hoang Văn A");
        stringPersonModel.addObject("Nguyen Thị B");
        // Hiển thi string
        System.out.println("Danh sách nhân viên:");
        stringPersonModel.display();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int check;
        do {
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm nhân viên");
            System.out.println("3. Thêm String");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            check = scanner.nextInt();
            switch (check) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    createEmployee();
                    break;
                case 3:
                    createString();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (check != 0);

    }
}

