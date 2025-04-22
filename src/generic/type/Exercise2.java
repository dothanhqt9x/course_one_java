package generic.type;

import java.util.ArrayList;

public class Exercise2 {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 10;

    public void Exercise2() {
        runExercise();
    }

    public void runExercise() {
        ArrayList<Integer> numbers = new ArrayList<>();

        try (var scanner = new java.util.Scanner(System.in)) {
            System.out.print("Nhập số phần tử: ");
            int n = scanner.nextInt();
            System.out.println("Phần tử nhập vào phải lớn hơn " + MIN_VALUE + " và nhỏ hơn " + MAX_VALUE + "!!!");
            for (int i = 0; i < n; i++) {
                System.out.print("Nhập đê ");
                int input = scanner.nextInt();
                if (input >= MAX_VALUE) {
                    i--;
                    System.out.println("Đã bảo chỉ nhập từ " + MIN_VALUE + " tới: " + MAX_VALUE + " thôi mà.Nhập lại đi");
                    continue;
                }
                numbers.add(input);
            }

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        }

        System.out.println("Bạn đã nhập:");
        for (var number : numbers) {
            System.out.println(number);
        }
    }
}
