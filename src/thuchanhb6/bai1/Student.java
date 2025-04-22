package thuchanhb6.bai1;

public class Student extends Person {
    private int mark;
    private String grade;

    public Student(String id, String name, int age) {
        super(id, name, age);
    }

    public int getMark() {
        return mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public void calGrade(){
        if (mark < 5) {
            this.grade = "fail";
        }
        else if (mark <= 7) {
            this.grade = "pass";
        }
        else if (mark < 9) {
            this.grade = "credit";
        }
        else {
            this.grade = "distinction";
        }


        System.out.println("Grade : " + this.grade);
    }
    @Override
    public void input(){
        System.out.println("Nhap gi do ............");
    }

    @Override
    public void display(){
        System.out.println("id: " + this.id);
        System.out.println("name: " + this.name);
        System.out.println("age: " + this.age);
        System.out.println("mark: " + this.mark);
        calGrade();
    }
}

