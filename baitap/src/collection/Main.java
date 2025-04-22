package collection;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//        List<String> cars = new ArrayList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        cars.add("Mazda2");
//
//        Collections.sort(cars);
//
//        for (int i =0; i< cars.size();i++){
//            System.out.print(cars.get(i)+",");
//        }
//        System.out.println(cars.get(0));
//        cars.set(0, "Volvo");
//        cars.remove(0);
//        cars.clear();
//        System.out.println(cars);

//        List<String> cars = new LinkedList<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("Mazda");
//        System.out.println(cars);

//        Collections.reverse(cars);
//        System.out.println(cars);

//        Map<String, Integer> people = new HashMap<String, Integer>();
//
//        people.put("John", 32);
//        people.put("Steve", 30);
//        people.put("Angie", 33);

//
//        for (String i: people.keySet()){
//            System.out.println("key: "+ i);
//        }
//
//        for (int i:people.values()){
//            System.out.println("value: "+i);
//        }
//
//        for (String i : people.keySet()) {
//            System.out.println("key: " + i + ", value: " + people.get(i));
//        }

//        Set<String> cars = new HashSet<String>();
//        cars.add("Volvo");
//        cars.add("BMW");
//        cars.add("Ford");
//        cars.add("BMW");
//        cars.add("Mazda");
//
//        System.out.println(cars.contains("Mazda")); // true

//        Iterator<String> iterator = cars.iterator();
        // Print the first item
//        System.out.println(iterator.next());

//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        ListIterator<String> listIterator = cars.listIterator();
//        while (listIterator.hasNext()){
//            System.out.println(listIterator.next());
//        }

        List mylist = new ArrayList();
        mylist.add(10);
        mylist.add("Hello");
        mylist.add(true);
        mylist.add(15.75);

        System.out.println(mylist);
    }
}
