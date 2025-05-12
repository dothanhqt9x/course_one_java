package GenericPratice;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Integer> myarrr = new ArrayList<Integer>();
        System.out.print("Nhập số phần tử của mảng: ");
        int n = scanner.nextInt();

        System.out.print("Nhập các phần tử của mảng: \n");
        for(int i = 0; i < n; i++) {
            System.out.printf("myarrr[%d] = ", i);
            myarrr.add(scanner.nextInt());
        }

        System.out.print("Danh sách các phần tử của mảng: ");
        for(int i = 0; i < myarrr.size(); i++) {
            System.out.print(myarrr.get(i));
        }

    }
}
