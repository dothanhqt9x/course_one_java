package BaiTap.Buoi6.Bai1;

import java.util.*;

public class Main {
    public static void displayList(Set<String> hashSet) {
        Iterator<String> iterator = hashSet.iterator();
        System.out.print("Danh sách các khoa: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> hashSet = new HashSet<>();
        int menu = 0;
        do {
            System.out.println("-----MENU------");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Thoát");
            System.out.println("Xin mời bạn chọn chức năng: ");
            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu == 1) {
                System.out.print("Nhập tên khoa: ");
                String name = scanner.nextLine();
                if (hashSet.contains(name)) {
                    System.out.println("Thêm mới không thành công!");
                    continue;
                }
                hashSet.add(name);
                displayList(hashSet);
            } else if (menu == 2) {
                System.out.print("Nhập tên khoa: ");
                String name = scanner.nextLine();
                if (hashSet.contains(name)) {
                    hashSet.remove(name);
                    System.out.println("Xóa thành công!");
                    continue;
                }
                System.out.println("Xóa không thành công!");
            } else if (menu == 3) {
                displayList(hashSet);
            }

        } while (menu != 4);
    }
}
