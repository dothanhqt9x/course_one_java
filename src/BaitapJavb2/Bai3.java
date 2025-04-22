package BaitapJavb2;

import java.util.Scanner;

public class Bai3 {
    public static void checTriangle(float a, float b, float c){
        if (a+b>c && a+c>b && b+c>a){
            System.out.println("Tam giac em nhe");
            return;
        }
        System.out.println("Khong phai tam giac em nhe :)");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap canh 1 di em : ");
        float a = sc.nextFloat();
        System.out.print("Nhap canh 2 di em : ");
        float b = sc.nextFloat();
        System.out.print("Nhap canh 3 di em : ");
        float c = sc.nextFloat();

        checTriangle(a,b,c);
    }
}