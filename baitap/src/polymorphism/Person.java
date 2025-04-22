package polymorphism;

interface personExample{
    public void input();
    public void display();
}

public class Person implements personExample {
    protected String id;
    protected String name;
    protected int age;

    public Person(String id, String name, int age){
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void input() {

    }

    @Override
    public void display() {

    }
}


