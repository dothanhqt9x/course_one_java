package BaitapJavb2;//Viết chương trình cho phép nhập vào một số nguyên dạng số, sau khi chạy thì chương
//trình sẽ ghi số đó ra dưới dạng chữ.
//        VD: 1 -> Một, 2 -> Hai, ...



import java.util.Scanner;

public class Bai2 {
    private static final String[] ones = {
            "", "Một", "Hai", "Ba", "Bốn", "Năm", "Sáu", "Bảy", "Tám", "Chín"
    };

    private static final String[] teens = {
            "Mười", "Mười Một", "Mười Hai", "Mười Ba", "Mười Bốn",
            "Mười Lăm", "Mười Sáu", "Mười Bảy", "Mười Tám", "Mười Chín"
    };

    private static final String[] tens = {
            "", "", "Hai Mươi", "Ba Mươi", "Bốn Mươi", "Năm Mươi",
            "Sáu Mươi", "Bảy Mươi", "Tám Mươi", "Chín Mươi"
    };

    private static final String[] hundreds = {
            "", "Một Trăm", "Hai Trăm", "Ba Trăm", "Bốn Trăm", "Năm Trăm",
            "Sáu Trăm", "Bảy Trăm", "Tám Trăm", "Chín Trăm"
    };

    public static String convertToWords(int num) {
        if (num == 0) return "Không";

        StringBuilder result = new StringBuilder();

        if (num < 0) {
            result.append("Âm ");
            num = -num;
        }

        if (num < 10) {
            result.append(ones[num]);
        } else if (num < 20) {
            result.append(teens[num - 10]);
        } else if (num < 100) {
            result.append(tens[num / 10]);
            if (num % 10 != 0) {
                result.append(" " + ones[num % 10]);
            }
        }else {
            result.append("Số quá lớn, vui lòng nhập số nhỏ hơn 100");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int num = scanner.nextInt();
        scanner.close();

        String words = convertToWords(num);
        System.out.println("Dạng chữ: " + words);
    }
}
