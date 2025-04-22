package thuchanhb8.SetInterface;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SetInterface {

    public static void main(String[] args) {
//   Khai báo 1 Set có Class triển khai là HashSet, kiểu dữ liệu là String.
//        Sau đó thêm vào phần tử là tên của các khoa của một trường đại học
//        cho Set này (giá trị của các phần tử được nhập từ bàn phím).

        Set<String> major = new HashSet<String>(
                List.of("IT", "English", "Engineer", "Doctor", "Marketing", "Logistic", "Accounting")
        );
        System.out.println(major);

//   Hiển thị các phần tử vừa nhập có trong Set vừa nhập sử dụng Iterator.
//   Thêm vào một khoa mới vào trong Set, nếu tên khoa đó đã tồn tại thì
//        thông báo cho người dùng biết tên khoa đó đã có, còn ngược lại
//        thêm bình thường và thông báo "Thêm thành công!".
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao 1 khoa moi: ");
        String khoa = sc.next();
        if(major.contains(khoa)){
            System.out.println("Khoa da ton tai !");
        }
        else {
            major.add(khoa);
            System.out.println("Them thanh cong !");
        }

        System.out.println(major);

//   Xóa một khoa bất kỳ ra khỏi Set. Kiểm tra nếu khoa cần xóa có tồn tại
//        trong Set thì mới xóa và thông báo "Xóa thành công!", ngược lại
//        thông báo "Xóa không thành công!".

        System.out.print("Nhap vao 1 khoa muon xoa: ");
        String del = sc.next();
        if(major.contains(del)){
            major.remove(del);
            System.out.println("Xoa thanh cong !");
        }
        else {
            System.out.println("Xoa that bai  !");
        }
        System.out.println(major);
    }

}
