package BaiTap.Buoi3.Bai4.Ex2;

public class Main {
    public static void main(String[] args) {
        String s = "12344321";

        if (s instanceof String) {
            int length = s.length() / 2;
            boolean doiXung = true;

            for (int i = 0; i < length; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    doiXung = false;
                    break;
                }
            }
            System.out.println(doiXung ? "Chỗi đối xứng" : "Chuỗi không đối xứng");
        }


    }
}
