package BaiTap.Buoi7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void createStudent(List<Student> students, Student studentParam) {
        for (Student student : students) {
            if(student.equals(studentParam)) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student student1 = new Student(1, "A");
        Student student2 = new Student(2, "B");
        Student student3 = new Student(3, "C");
        Student student4 = new Student(4, "D");
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Map<Integer, Student> studentMap = new HashMap<>();

        studentMap.put(1, new Student(1, "Sơn"));
        studentMap.put(2, new Student(2, "Việt"));
        studentMap.put(3, new Student(3, "Chương"));
        studentMap.put(4, new Student(1, "Thành"));

        System.out.println(studentMap.size());
        var result = studentMap.get(new Student(1, "Thành"));
        System.out.println(result);
    }
}
