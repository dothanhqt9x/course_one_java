package collections;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Person {
    String name;
    int id;

    Person(int id, String name) {
        this.name = name;
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}


public class test3 {

    public void checkDublicable() {
        Set<Person> people = new HashSet<>();

        Person p1 = new Person(1, "Alice");
        Person p2 = new Person(1, "Alice");

        people.add(p1);

        System.out.println("Contains p2? " + people.contains(p2));
    }

    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();

        Person p1 = new Person(1, "Alice");
        Person p2 = new Person(1, "Alice");

        people.add(p1);

        System.out.println("Contains p2? " + people.contains(p2));
    }
}
