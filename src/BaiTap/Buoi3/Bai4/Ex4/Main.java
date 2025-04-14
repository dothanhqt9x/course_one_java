package BaiTap.Buoi3.Bai4.Ex4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số nguyên thứ nhất: ");
        int number1 = scanner.nextInt();

        System.out.print("Nhập số nguyên thứ hai: ");
        int number2 = scanner.nextInt();

        System.out.print("Nhập toán tử: ");
        String operator = scanner.next();

        if (operator.equals("+")) {
            System.out.println(number1 + "+" + number2 + " = " + (number1 + number2));
        } else if (operator.equals("-")) {
            System.out.println(number1 + "-" + number2 + " = " + (number1 - number2));

        } else if (operator.equals("*")) {
            System.out.println(number1 + "*" + number2 + " = " + (number1 * number2));

        } else if (operator.equals("/")) {
            if(number2 == 0) {
                return;
            }
            System.out.println(number1 + "/" + number2 + " = " + ((double) number1 / number2));

        }


    }
}
