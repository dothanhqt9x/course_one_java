package BaiTap.Buoi8.BaiTap.Bai5;

import BaiTap.Buoi8.BaiTap.Bai3.Student;
import BaiTap.Buoi8.BaiTap.Bai4.Employee;

import java.util.ArrayList;
import java.util.Comparator;

public class PersonModel<T> {
    public ArrayList<T> li = new ArrayList<>();

    public void addObject(T object) {
        li.add(object);
    }

    public void display() {
        for (T item : li) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        PersonModel<Student> personModel = new PersonModel<>();
        personModel.addObject(new Student(1, "Việt 1", 18));
        personModel.addObject(new Student(1, "Việt 2", 18));
        personModel.display();

        PersonModel<Employee> personModel2 = new PersonModel<>();
        personModel2.addObject(new Employee(1 , "Việt 3" , 100));
        personModel2.addObject(new Employee(2 , "Việt 4" , 100));
        personModel2.display();

        PersonModel<String> personModel3 = new PersonModel<>();
        personModel3.addObject("Việt 5");
        personModel3.addObject("Việt 6");

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        Comparable comparable = new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        personModel3.display();
    }
}
