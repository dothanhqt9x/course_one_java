package thuchanhb8.BaitapaThanh;

import java.time.temporal.ValueRange;
import java.util.*;

class Student {
    public int id;
    public String name;
    public int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Sinh vien co ma %d ten la %s va %d tuoi.", id, name, age);
    }
}

public class BaitapaThanh {
    //    Viết chương trình nhập danh sách sinh viên gồm: id, name, age gồm các chức năng sau
//            1. Thêm sinh viên vào danh sách.
//            2. Hiển thị danh sách sinh viên.
//            3. Sắp xếp danh sách theo tên (A-Z).
//            4. Sắp xếp danh sách theo tên (Z-A).
//            5. Liệt kê danh sách các Tên của danh sách lớp
//            6. Lấy ra tên có nhiều sinh viên nhất và số sinh viên là bao nhiêu
//    Note: có danh sách sinh viên mặc định để có thể sắp xếp được luôn

    public static List<Student> students = new ArrayList<>(List.of(
            new Student(1, "An", 20),
            new Student(2, "Bình", 21),
            new Student(3, "An", 22),
            new Student(4, "Cường", 19),
            new Student(5, "Duy", 20),
            new Student(6, "Hà", 21),
            new Student(7, "Lan", 20),
            new Student(8, "Mai", 22),
            new Student(9, "An", 23),
            new Student(10, "Bình", 20),
            new Student(11, "Trang", 22),
            new Student(12, "Vy", 21),
            new Student(13, "Yến", 20),
            new Student(14, "Trang", 23),
            new Student(15, "Hà", 19),
            new Student(16, "Cường", 21),
            new Student(17, "Khoa", 22),
            new Student(18, "Lâm", 20),
            new Student(19, "Phúc", 21),
            new Student(20, "Nam", 23),
            new Student(21, "Vy", 22),
            new Student(22, "Trung", 20),
            new Student(23, "Minh", 21),
            new Student(24, "Thảo", 20),
            new Student(25, "Trang", 21),
            new Student(26, "Linh", 22),
            new Student(27, "Tuấn", 23),
            new Student(28, "An", 21),
            new Student(29, "Duy", 22),
            new Student(30, "Huy", 20)
    ));

    public static void ThemSinhVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap id");
        int id = sc.nextInt();
        System.out.println("Nhap ten");
        String name = sc.next();
        System.out.println("Nhap tuoi");
        int age = sc.nextInt();

        Student std = new Student(id, name, age);
        students.add(std);
    }

    public static void HienThi() {
        System.out.println("Danh sach sinh vien: ");
        for (Student std : students) {
            System.out.println(std.toString());
        }
    }

    public static void SapXepA_Z() {
        students.sort(Comparator.comparing(Student::getName));

        // In danh sách đã sắp xếp
        students.forEach(System.out::println);
    }


    public static void SapXepZ_A() {
        students.sort(Comparator.comparing(Student::getName));

        // In danh sách đã sắp xếp
        students.reversed().forEach(System.out::println);
    }

    public static void DanhSachCacTen() {
        Set<String> names = new HashSet<>();
        for (Student s : students) {
            names.add(s.getName());
        }
        System.out.println("Danh sach cac ten : " + names);
    }

    public static void TenXuatHienNhieuNhat() {
        Map<String, Integer> map = new HashMap<>();
        for (Student s : students) {
            String name = s.getName();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }
        String tenNhieuNhat = null;
        int max = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                tenNhieuNhat = entry.getKey();
            }
        }

        // In kết quả
        System.out.println("Tên xuất hiện nhiều nhất: " + tenNhieuNhat + " (" + max + " lần)");
    }

    public static void main(String[] args) {
//        SapXepA_Z();
//        SapXepZ_A();
//        DanhSachCacTen();
        TenXuatHienNhieuNhat();
    }


}
