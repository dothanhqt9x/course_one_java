package collection;

import java.util.*;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public static boolean isDuplicate(List<Student> students, Student student) {
        return students.contains(student);
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tinh"));
        students.add(new Student(2, "Quynh"));
        students.add(new Student(3, "Toan"));


        Student student1 = new Student(2, "Quynh");
        Student student2 = new Student(4, "Luan");


        System.out.println("Check student1: " +
                (isDuplicate(students, student1) ? "Duplicate" : "Not Duplicate"));
        System.out.println("Check student2 : " +
                (isDuplicate(students, student2) ? "Duplicate" : "Not Duplicate"));
    }
}



