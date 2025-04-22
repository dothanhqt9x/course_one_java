package thuchanhb8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    public int id;
    public String name;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
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

    public boolean equals(Student std) {
        if (this == std) return true;

        return this.id == std.id && this.name.equals(std.name);
    }

    @Override
    public String toString(){
        return "Student id: "+ this.id + " and name: "+ this.name;
    }
}

public class File {

    public static boolean checkIsDuplicate(List<Student> students){
        for (Student i : students){
            for (Student j : students){
                if(i.equals(j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();

        students.add(new Student(1,"Toan"));
        students.add(new Student(1,"Toan"));
        students.add(new Student(1,"Toan"));
        students.add(new Student(1,"Toan"));

        System.out.println(checkIsDuplicate(students));
    }
}
