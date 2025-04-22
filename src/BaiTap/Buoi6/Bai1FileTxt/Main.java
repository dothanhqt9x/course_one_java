package BaiTap.Buoi6.Bai1FileTxt;

import java.util.*;

public class Main {
    public static void displayListStudent(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        System.out.println("Danh sách sinh viên: ");
        while (iterator.hasNext()) {
            System.out.println("  + " + iterator.next() + ", ");
        }
        System.out.println();
    }

    public static Student findStudentById(List<Student> students, int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public static void createStudent(List<Student> students, Scanner scanner) {
        System.out.print("Nhập id: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        Student student = findStudentById(students, id);
        if (student != null) {
            System.out.println("Sinh viên đã tồn tại! , Thêm mới không thành công!");
            return;
        }
        Student studentNew = new Student(id, name, age);
        students.add(studentNew);
        System.out.println("Thêm mới thành công!");
    }

    public static void deleteStudentById(List<Student> students, Scanner scanner) {
        System.out.print("Nhập id sinh viên cần xóa: ");
        int id = scanner.nextInt();
        Student student = findStudentById(students, id);
        if (student != null) {
            students.remove(student);
            System.out.println("Xóa thành công!");
            return;
        }
        System.out.println("Sinh viên không tồn tại! , Xóa không thành công!");
    }

    public static void sortStudentWithParam(List<Student> students, String param, String sort) {
        Comparator<Student> comparator;
        switch (param) {
            case "id":
                comparator = Comparator.comparing(Student::getId);
                break;
            case "name":
                comparator = Comparator.comparing(Student::getName);
                break;
            case "age":
                comparator = Comparator.comparing(Student::getAge);
                break;
            default:
                System.out.println("Tham số sắp xếp không hợp lệ!");
                return;
        }
        if ("DESC".equalsIgnoreCase(sort)) {
            comparator = comparator.reversed();
        }
        students.sort(comparator);
    }

    public static void findMaxStudentByName(List<Student> students) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (Student student : students) {
            Integer quantity = hashMap.get(student.getName());
            if (quantity == null) {
                quantity = 1;
                hashMap.put(student.getName(), quantity);
                continue;
            }
            hashMap.put(student.getName(), quantity + 1);
        }

        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> item : hashMap.entrySet()) {
            if (maxEntry == null || item.getValue() > maxEntry.getValue()) {
                maxEntry = item;
            }
        }
        assert maxEntry != null;
        System.out.println(" - Tên sinh viên xuất hiện nhiều nhất: " + maxEntry.getKey());
        System.out.println(" - Số lần xuất hiện: " + maxEntry.getValue());


    }

    public static String paramSort(Scanner scanner) {
        int menuSort;
        String paramSort;
        System.out.println(" - 1. Sắp xếp theo id");
        System.out.println(" - 2. Sắp xếp theo name");
        System.out.println(" - 3. Sắp xếp theo age");
        menuSort = scanner.nextInt();
        scanner.nextLine();
        if (menuSort == 1) {
            paramSort = "id";
        } else if (menuSort == 2) {
            paramSort = "name";
        } else {
            paramSort = "age";
        }
        return paramSort;
    }

    public static List<Student> generateStudents() {
        return new ArrayList<>(List.of(
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
    }

    public static void main(String[] args) {
        List<Student> students = generateStudents();
        Scanner scanner = new Scanner(System.in);

        int menu;
        do {
            System.out.println("-----MENU------");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xem danh sách");
            System.out.println("3. Sắp xếp danh sách tăng dần");
            System.out.println("4. Sắp xếp danh sách giảm dần");
            System.out.println("5. Xóa");
            System.out.println("6. Tìm ra tên có nhiều sinh viên nhất");
            System.out.println("7. Thoát");
            System.out.print("Xin mời bạn chọn chức năng: ");
            menu = scanner.nextInt();
            scanner.nextLine();
            if (menu == 1) {
                createStudent(students, scanner);

            } else if (menu == 2) {
                displayListStudent(students);

            } else if (menu == 3) {
                sortStudentWithParam(students, paramSort(scanner), "ASC");
                displayListStudent(students);

            } else if (menu == 4) {
                sortStudentWithParam(students, paramSort(scanner), "ASC");
                displayListStudent(students);

            } else if (menu == 5) {
                deleteStudentById(students, scanner);

            } else if (menu == 6) {
                findMaxStudentByName(students);

            }

        } while (menu != 7);
    }
}
