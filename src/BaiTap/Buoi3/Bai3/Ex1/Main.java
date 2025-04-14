package BaiTap.Buoi3.Bai3.Ex1;

public class Main {
    public static void main(String[] args) {
        double luongConLai = 30000 - 5000;
        double luongTienBanHang = 0;

        if (luongConLai < 5000 * 0.08) {
            luongTienBanHang = luongConLai / 0.08;
        } else if (luongConLai < 10000 * 0.1) {
            luongConLai = luongConLai - 5000 * 0.08;
            luongTienBanHang = luongConLai / 0.1 + 5000;
        }  else {
            luongConLai = luongConLai - 5000 * 0.08 - 10000 * 0.1;
            luongTienBanHang = luongConLai / 0.12 + 5000 + 10000;
        }

        System.out.println(luongTienBanHang);
    }
}
