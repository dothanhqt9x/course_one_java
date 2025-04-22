package BaitapJavb2;//Viết chương trình cho phép nhập vào một số nguyên dương n, tính tổng tất cả số chẵn
//        trong khoảng từ 0 - n.
import java.util.Scanner;

public class Bai5 {
    public static void count(int n){
        int c = 0;
        for (int i = 1; i <= n ; i++) {
            if( i %2== 0){
                c+=i;
            }
        }
        System.out.println("Day em nhe: "+ c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so di em : ");
        int n = sc.nextInt();
        count(n);
    }
}