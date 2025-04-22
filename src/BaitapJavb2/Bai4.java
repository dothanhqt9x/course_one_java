package BaitapJavb2;//Viết chương trình cho phép nhập vào 3 số
//Chương trình sẽ kiểm tra 3 số này có phải là 3 cạnh của một tam giác vuông hay không.

import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    public static void checTrianglevuong(float a, float b, float c){
        float[] sides = {a, b, c};
        Arrays.sort(sides);
        if ( a*a + b*b == c*c){
            System.out.println("Vuong em nhe");
            return ;
        }
        System.out.println("Khong vuong em nhe");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap canh 1 di em : ");
        float a = sc.nextFloat();
        System.out.print("Nhap canh 2 di em : ");
        float b = sc.nextFloat();
        System.out.print("Nhap canh 3 di em : ");
        float c = sc.nextFloat();

        checTrianglevuong(a,b,c);
    }
}


