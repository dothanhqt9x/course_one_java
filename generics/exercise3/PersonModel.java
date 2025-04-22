package generics.exercise3;

import java.util.ArrayList;

public class PersonModel <T> {
    public ArrayList<T> list = new ArrayList<>();

    public void addObject(T object){
        list.add(object);
    }
    public void display(){
        for (T e:list){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        PersonModel<Student> studentList = new PersonModel<>();
        studentList.addObject(new Student(1, "Nguyen Van A", 20));
        studentList.addObject(new Student(2, "Tran Thi B", 21));
        System.out.println("Danh sách sinh viên:");
        studentList.display();

        PersonModel<Employee> employeeList = new PersonModel<>();
        employeeList.addObject(new Employee(101, "Le Van C", 5000.0));
        employeeList.addObject(new Employee(102, "Pham Thi D", 6000.0));
        System.out.println("Danh sách nhân viên:");
        employeeList.display();

        PersonModel<String> nameList = new PersonModel<>();
        nameList.addObject("Nguyen Van E");
        nameList.addObject("Tran Thi F");
        System.out.println("Danh sách họ tên:");
        nameList.display();
    }
}
