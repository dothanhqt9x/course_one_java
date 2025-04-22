package generic.type;

import java.util.ArrayList;

public class PersonModel<T> {
    public ArrayList<T> li = new ArrayList<T>();

    public void addObject(T object) {
        li.add(object);
    }

    public void display() {
        for (T e : li) {
            System.out.println(e);
        }
    }
}
