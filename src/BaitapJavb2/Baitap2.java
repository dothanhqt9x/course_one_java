package BaitapJavb2;

import java.util.Scanner;

public class Baitap2 {
//    Bài 13. Viết chương trình giải phương trình bậc 1 với hệ số a, b được nhập vào bởi user
//    từ tham số command line.
    public void bacnhat(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so a : ");
        float a = sc.nextFloat();
        System.out.println("Nhap so b : ");
        float b = sc.nextFloat();
        System.out.println("Ket qua la : " + -b/a);
    }

//    Bài 14. Viết chương trình đọc một giá trị nguyên từ bàn phím và in ra số đó là số chẵn, lẻ
//    hoặc zero
    public void bai14(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap so a : ");
        float a = sc.nextFloat();
        if(a>0){
            System.out.println("Duong");
        } else if (a<0) {
            System.out.println("Am");
        }
        else {
            System.out.println("0");
        }
    }

//    Bài 15. Viết chương trình in ra bội số của 3 từ 300 đến 3.
    public void bai15() {
        for (int i = 100; i > 0; i--) {
            System.out.println(i*3);
        }
    }

//    Bài 16. Viết chương trình in ra số lần kí tự „a‟ xuất hiện trong một chuỗi
    public void bai16() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap chuoi ddi  : ");
        String input = sc.next();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'A') {
                count++;
            }
        }

        System.out.println("Số lần ký tự 'a' xuất hiện trong chuỗi là: " + count);
    }

//    Bài 17. Viết hàm để đếm số lượng ký tự là số có trong chuỗi s. Chuỗi s được nhập từ bàn
//    phím. Dùng mã ASCII để kiểm tra hoặc dùng class Character: Character.isDigit(ký tự) để
//    kiểm ký tự có phải là số hay không .

//    Bài 18. Viết hàm tách chuỗi gốc thành chuỗi khác (dùng StringTokenizer).
//    VD: chuỗi gốc S = “Bai Tap Mon Lap Trinh Java”, chuỗi sau khi tách là
//      “Bai
//      Tap
//      Mon
//      Lap
//      Trinh
//      Java”

//    Bài 19. Viết chương trình kiểm tra số nhập vào có phải là số nguyên tố hay không


//    Bài 20. Viết chương trình tìm USCLN của 2 số nhập vào.
    public void bai20(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("day nhe : "+a);
    }
    public static void main(String[] args) {

    }

}