package thuchanhb10;

import java.util.ArrayList;

class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "This is stundent " + id + " and name is " + name;
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "This is employee " + id + " and name is " + name;
    }
}

public class Exercise3<T> {

    public ArrayList<T> li = new ArrayList<T>();
    public void addObject(T object){
        li.add(object);
    }
    public void display(){
        for (T e:li){
            System.out.println(e);
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
//        Tạo đối tượng personModel<student>
//        o Gọi phương thức addObject để nhập vào 2 sinh viên (student)
//        o Gọi phương thức display để hiển thị 2 sinh viên vừa nhập

        Exercise3<Student> stds = new Exercise3<>();
        stds.addObject(new Student(1, "Tona", 22));
        stds.addObject(new Student(2, "Tano", 25));

        stds.display();

//        o Tạo đối tượng personModel<employee>
//        o Gọi phương thức addObject để nhập vào 2 nhân viên (employee)
//        o Gọi phương thức display để hiển thị 2 nhân viên vừa nhập.

        Exercise3<Employee> emps = new Exercise3<>();
        emps.addObject(new Employee(1, "Tona", 22.00));
        emps.addObject(new Employee(2, "Tano", 25.00));

        emps.display();

//        o Tạo đối tượng personModel<String>
//        o Gọi phương thức addObject để nhập vào họ tên của 2 người
//        o Gọi phương thức display để hiển thị 2 họ tên vừa nhập

        Exercise3<String> strings = new Exercise3<>();
        strings.addObject(new String("Ruby-chan, nani ga suki!"));
        strings.addObject(new String("Choco minto yori mo no anata!"));

        strings.display();

    }
}
