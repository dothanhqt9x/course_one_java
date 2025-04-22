package BaitapJavb2;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so di em : ");
        int bien = sc.nextInt();
        if(bien >=  0){
            System.out.println("Duong em nhe");
        }
        else{
            System.out.println("Am em nhe");
        }
    }
}