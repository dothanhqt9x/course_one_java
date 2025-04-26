package GenericPratice;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel<T> {
    public ArrayList<T> li = new ArrayList<T>();
    public static Scanner scanner = new Scanner(System.in);
    public void addObject(T object){
        li.add(object);
    }
    public void display(){
        for (T e:li){
            System.out.println(e);
        }
    }
    public static void main(String args[]){

        // Student
//        PersonModel<Student> personModel = new PersonModel<Student>();
//
//        System.out.print("Nhập id học sinh: ");
//        Integer studenId = scanner.nextLine();
//
//        System.out.print("Nhập tên học sinh: ");
//        String studentName = scanner.nextLine();
//
//        System.out.print("Nhập tuổi học sinh: ");
//        Integer studentAge = scanner.nextLine();
//
//        Student student = new Student(studenId, studentName, studentAge);
//        personModel.addObject(student);

        // Employee
//        PersonModel<Employee> personModel = new PersonModel<Employee>();
//
//        for (int i = 0; i< 2; i++) {
//            System.out.format("Nhập id của nhân viên thứ %d: ", i+1);
//            Integer employeeId = scanner.nextLine();
//
//            System.out.format("Nhập tên của nhân viên thứ %d: ", i+1);
//            String employeeName = scanner.nextLine();
//
//            System.out.format("Nhập lương của nhân viên thứ %d: ", i+1);
//            Integer employeeSalary = scanner.nextLine();
//
//            Employee employee = new Employee(employeeId, employeeName, employeeSalary);
//            personModel.addObject(employee);
//        }
//            personModel.display();


        // String
        PersonModel<String> personModel = new PersonModel<String>();

        for (int i = 0; i< 2; i++) {
            System.out.format("Nhập họ tên của người thứ %d: ", i+1);
            String fullName = scanner.nextLine();

            personModel.addObject(fullName);
        }

        System.out.println("Danh sách họ và tên: ");
        personModel.display();
    }
}

