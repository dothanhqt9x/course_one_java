package BaiTap.Buoi3.Bai3.Ex2;

public class Main {
    public static void main(String[] args) {
        int arr[] = new int[100];
        int i = 0;
        int index = 0;
        while (index < 100) {
            if (i == 0 || i == 1) {
                i++;
                continue;
            } else if (i == 2 || i == 3 || i == 5 || i == 7) {
                arr[index++] = i;
            } else if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 6 == 0 || i % 8 == 0 || i % 9 == 0) {
                i++;
                continue;
            } else {
                arr[index++] = i;
            }

            ++i;
        }

        for (int j = 0; j < arr.length; j++) {
            System.out.println(arr[j]);

        }
    }
}
