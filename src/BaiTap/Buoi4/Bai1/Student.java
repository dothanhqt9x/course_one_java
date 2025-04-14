package BaiTap.Buoi4.Bai1;

import java.util.Scanner;

public class Student extends Person {
    private int mark;
    private String grade;

    public Student() {
    }

    public Student(int mark, String grade) {
        this.mark = mark;
        this.grade = grade;
    }

    public Student(String id, String name, int age, int mark) {
        super(id, name, age);
        this.mark = mark;
        this.calGrade();
    }


    public Student(String id, String name, int age, int mark, String grade) {
        super(id, name, age);
        this.mark = mark;
        this.grade = grade;
    }

    public void calGrade() {
        if (this.mark >= 8) {
            this.grade = "distinction";
        } else if (this.mark >= 7) {
            this.grade = "credit";
        } else if (this.mark >= 5) {
            this.grade = "pass";
        } else {
            this.grade = "fail";
        }
    }

    @Override
    public void display() {
        System.out.println("Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", mark=" + mark +
                ", grade='" + grade + '\'' +
                '}');
    }

    @Override
    public void input() {
        super.input();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập id: ");
        String id = scanner.nextLine();
        System.out.print("Mời bạn nhập name: ");
        String name = scanner.nextLine();
        System.out.print("Mời bạn nhập age: ");
        int age = scanner.nextInt();
        System.out.print("Mời bạn nhập mark: ");
        int mark = scanner.nextInt();

        Student student = new Student(id, name, age, mark);
        student.display();
    }
}
