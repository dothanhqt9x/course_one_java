package thuchanhb6.bai1;

public class Person implements IpersonExample {
    protected String id;
    protected String name;
    protected int age;


    public Person() {}

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
    public void input() {

    }

    @Override
    public void display() {

    }

    public static void main(String[] args) {

        Student toan = new Student("MSV-1", "Tona", 22);
        toan.setMark(9);
        toan.display();
    }
}
