package collections;

import java.util.ArrayList;
import java.util.List;

public class test2 {

    private static List<Student> students = new ArrayList<>(List.of(
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

    // Bải 1.1
    public void addNewStudent(int id, String name, int age) {
        students.add(new Student(id, name, age));
    }

    // Bải 1.2
    public void getListStudent() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    // Bải 1.3
    public void sortAlpha() {
        students.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
    }

    // Bải 1.4
    public void sortReverse() {
        students.sort((s1, s2) -> s2.getName().compareTo(s1.getName()));
    }

    // Bải 1.5
    public void listUniqueNames() {
        List<String> uniqueNames = new ArrayList<>();
        for (Student student : students) {
            if (!uniqueNames.contains(student.getName())) {
                uniqueNames.add(student.getName());
            }
        }
        System.out.println("List tên unique trong lớp: " + uniqueNames);
    }

    // Bài 1.6
    public void getNameALot() {
        List<String> names = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

        for (Student student : students) {
            String name = student.getName();
            if (!names.contains(name)) {
                names.add(name);
                counts.add(1);
            } else {
                int index = names.indexOf(name);
                counts.set(index, counts.get(index) + 1);
            }
        }

        int max = 0;
        String frequent = names.getFirst();
        for (int i = 1; i < names.size(); i++) {
            if (counts.get(i) > max) {
                max = counts.get(i);
                frequent = names.get(i);
            }
        }

        System.out.println("Tên sinh viên xuất hiện nhiều nhất: " + frequent + " (" + max + " lần)");
    }


    public static void main(String[] args) {
        var test = new test2();
        test.sortAlpha();
//        test.getListStudent();
        test.getNameALot();
    }


}

