package generic;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel <T> {
    public ArrayList<T> li = new ArrayList<T>();

    public void addObject(T object){
        li.add(object);
    }

    public void display(){
        for (T e:li){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

//        PersonModel<Student> studentModel = new PersonModel<>();
//        int studentQuantity;
//        System.out.print("Nhập số lượng sinh viên: ");
//        studentQuantity = scanner.nextInt();
//        for (int i= 1; i <= studentQuantity; i++){
//            studentModel.addObject(PersonUtils.inputStudent(scanner, i));
//        }
//        System.out.println("Danh sách sinh viên vừa nhập:");
//        studentModel.display();

//        PersonModel<Employee> employeeModel = new PersonModel<>();
//        int employeeQuantity;
//        System.out.print("Nhập số lượng nhân viên: ");
//        employeeQuantity = scanner.nextInt();
//        for (int i= 1; i <= employeeQuantity; i++){
//            employeeModel.addObject(PersonUtils.inputEmployee(scanner, i));
//        }
//        System.out.println("Danh sách nhân viên vừa nhập:");
//        employeeModel.display();

        PersonModel<String> nameModel = new PersonModel<>();
        int nameQuantity;
        System.out.print("Nhập số lượng họ tên: ");
        nameQuantity = scanner.nextInt();
        for (int i= 1; i <= nameQuantity; i++){
            String name = PersonUtils.inputName(scanner, i);
            nameModel.addObject(name);
        }
        System.out.println("Danh sách họ tên vừa nhập:");
        nameModel.display();

        scanner.close();
    }
}

