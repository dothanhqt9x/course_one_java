package thuchanhb10;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise2 {

    public static void main(String[] args) {
//Generic ArrayList là kiểu Integer (ArrayList<Integer> myarrr = new ArrayList<Integer>();)
// •Sử dụng vòng lặp để nhập các số từ 1 đến 10 vào mảng myarrr trên
// •Sử dụng vòng lặp để hiển thị các số từ 1 đến 10 từ mảng myarrr

        ArrayList<Integer> myarrr = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.print("Nhap so thu " + (i + 1));
            int so = sc.nextInt();
            myarrr.add(so);
        }

        System.out.println();
        System.out.println();

        for (int i = 0; i < 10; i++) {
            System.out.print("Gia tri so thu " + (i + 1) + ": " + myarrr.get(i));
        }
    }

}
