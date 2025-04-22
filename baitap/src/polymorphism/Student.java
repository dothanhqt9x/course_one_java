package polymorphism;

public class Student extends Person{
    private int mark;
    private String grade;

    public Student(String id, String name, int age, int mark) {
        super(id, name, age);
        this.mark = mark;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void callGrade() {
        if (mark >=8)
            setGrade("distinction");
        else if (mark >= 7) {
            setGrade("credit");
        }
        else if (mark >=5) {
            setGrade("pass");
        }
        else{
            setGrade("fail");
        }
    }

    public static void main(String[] args) {
        Student student = new Student("1", "Yasuo", 20, 7);
        System.out.println("id: "+student.id);
        System.out.println("name: "+student.name);
        System.out.println("age: "+student.age);
        student.callGrade();
        System.out.println("grade: "+student.grade);
    }
}
