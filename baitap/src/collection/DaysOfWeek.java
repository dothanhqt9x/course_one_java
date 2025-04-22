package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

public class DaysOfWeek {
    public static void main(String[] args) {
        ArrayList<String> daysList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập các ngày trong tuần (nhập 'done' để kết thúc):");
        while (true) {
            String day = scanner.nextLine();
            if (day.equalsIgnoreCase("done")) {
                break;
            }
            daysList.add(day);
        }

        System.out.println("\nDanh sách các ngày sử dụng Iterator:");
        Iterator<String> iterator = daysList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println("\nDanh sách các ngày sử dụng ListIterator:");
        ListIterator<String> listIterator = daysList.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        if (!daysList.isEmpty()) {
            System.out.println("\nNhập ngày mới để thay thế ngày đầu tiên:");
            String newDay = scanner.nextLine();
            daysList.set(0, newDay);

            System.out.println("\nDanh sách sau khi thay đổi:");
            for (String day : daysList) {
                System.out.println(day);
            }

            daysList.remove(0);

            System.out.println("\nDanh sách sau khi xóa phần tử vừa thay đổi:");
            for (String day : daysList) {
                System.out.println(day);
            }
        } else {
            System.out.println("\nList rỗng, không thể thay đổi hoặc xóa phần tử.");
        }

        System.out.println("\nDanh sách từ phần tử cuối về phần tử đầu tiên:");
        ListIterator<String> reverseIterator = daysList.listIterator(daysList.size());
        while (reverseIterator.hasPrevious()) {
            System.out.println(reverseIterator.previous());
        }

        scanner.close();
    }
}
