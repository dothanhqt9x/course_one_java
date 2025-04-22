package inheritance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuanLyCanBo {
    private List<CanBo> danhSachCanBo = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    public void themMoiCanBo() {

        System.out.print("Họ tên: ");
        String hoTen = scanner.nextLine();
        System.out.print("Tuổi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Giới tính: ");
        String gioiTinh = scanner.nextLine();
        System.out.print("Địa chỉ: ");
        String diaChi = scanner.nextLine();
                danhSachCanBo.add(new CanBo(hoTen, tuoi, gioiTinh, diaChi));
    }

    public void timKiemTheoTen() {
        System.out.print("Nhập họ tên cần tìm: ");
        String tenCanTim = scanner.nextLine();

        boolean found = false;
        for (CanBo cb : danhSachCanBo) {
            if (cb.hoTen.equalsIgnoreCase(tenCanTim)) {
                cb.hienThiThongTin();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy cán bộ với tên: " + tenCanTim);
        }
    }

    public void hienThiDanhSachCanBo() {
        if (danhSachCanBo.isEmpty()) {
            System.out.println("Danh sách cán bộ trống.");
        } else {
            for (CanBo cb : danhSachCanBo) {
                cb.hienThiThongTin();
                System.out.println("----------------------");
            }
        }
    }
}
