package thuchanhb8.ListInterface;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListInterface1 {

    public static List<String> DayinWeek = new ArrayList<String>(
            List.of("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    );

    public static void cau1() {
        Iterator<String> iterator = null;
        ListIterator<String> listIterator = null;

        iterator = DayinWeek.iterator();
        listIterator = DayinWeek.listIterator();

        System.out.print("Iterator: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }

        System.out.println("");

        System.out.print("List Iterator: ");
        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }

    }

    public static void cau2and3() {
        DayinWeek.set(0, "Thu Hai");
        System.out.println(DayinWeek);
        DayinWeek.remove("Thu Hai");
        System.out.println(DayinWeek);
    }

    public static void cau4() {
        ListIterator<String> listIterator = DayinWeek.listIterator(7 );
        System.out.println("Duyệt ngược bằng ListIterator:");
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
    }

    public static void main(String[] args) {
//        cau1();
//        cau2and3();
//        cau4();
//        System.out.println(DayinWeek);
    }
}
