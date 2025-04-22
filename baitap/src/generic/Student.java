package generic;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId(){
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

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString(){
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }

    public static void main(String[] args) {
        Student student = new Student(1, "Tinh", 22);
        System.out.println(student);
    }
}
