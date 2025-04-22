package BaitapJavb2;

import java.util.Scanner;

public class Baitap {
//    Bài 7. Viết chương trình in ra tổng của 10 số chẵn đầu tiên (sử dụng vòng lặp for hoặc
//            while)
    public void bai7(){
        int count = 0;
        for (int i = 0; i < 11; i++) {
            if( i %2== 0){
                count+=i;
            }
        }
        System.out.println( "Day nhe "+count);
    }


//    Bài 8. Viết chương trình in ra những số lẻ từ 1 đến 99.
    public void bai8(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 100; i++) {
            if( i % 2 == 1){
                sb.append(i+" ");
            }
        }
        System.out.println("Day nhe " + sb);
    }

//    Bài 9. Viết chương trình xuất ra tổng các số là bội số của 7 (từ 1 đến 100)
    public void bai9(){
        int count = 0;
        for (int i = 0; i < 100; i++) {
            if( i % 7 == 0){
                count+=i;
            }
        }
        System.out.println( "Day nhe " + count);
    }

//    Bài 10. Viết chương trình in ra tổng 1+2+3....+n với n được nhập từ tham số command
//            line
    public void bai10(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so di em : ");
        float n = sc.nextFloat();
        int count = 0;
        for (int i = 0; i < n; i++) {
            count+=i;
        }
        System.out.println( "Day nhe " + count);
    }

//    Bài 11. Viết chương trình in ra tổng 1+3+5....+n nếu n là số chẵn, 2+4+6+....n nếu n là
//    số lẻ. Giá trị n được nhập vào từ tham số command line
    public void bai11(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so di em : ");
        float n = sc.nextFloat();
        int count = 0;
        if (n % 2 != 0) {
            for (int i = 2; i < n; i += 2) {
                count += i;
            }
            System.out.println( "Day nhe " + count);
            return ;
        }
        for (int i = 1; i < n; i += 2) {
            count += i;
        }
        System.out.println( "Day nhe " + count);
    }

//    Bài 12. Viết chương trình in ra giá trị lớn nhất và nhỏ nhất trong một dãy các giá trị user
//    đã nhập vào từ tham số command line.

    public void bai12(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử: ");
        int n = scanner.nextInt();

        // Kiểm tra nếu người dùng không nhập số nào
        if (n <= 0) {
            System.out.println("Vui lòng nhập số lượng hợp lệ.");
            return;
        }

        // Nhập số đầu tiên để khởi tạo min và max
        System.out.print("Nhập số thứ 1: ");
        int min = scanner.nextInt();
        int max = min;

        // Lặp để nhập các số còn lại
        for (int i = 2; i <= n; i++) {
            System.out.print("Nhập số thứ " + i + ": ");
            int num = scanner.nextInt();

            if (num < min) min = num;
            if (num > max) max = num;
        }

        // Đóng scanner
        scanner.close();

        // Xuất kết quả
        System.out.println("Giá trị nhỏ nhất: " + min);
        System.out.println("Giá trị lớn nhất: " + max);
    }



    public static void main(String[] args) {

    }

}