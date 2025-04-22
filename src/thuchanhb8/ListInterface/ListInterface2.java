package thuchanhb8.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListInterface2 {
    public static void main(String[] args) {

//        Khai báo 2 mảng colors và colors2 và thêm các phần tử cho 2 mảng đó.
        String[] color = {"red", "blue", "yellow", "pink", "vanilla", "orange"};
        String[] color2 = {"green", "crimson", "purple"};

//        Tạo mới 2 List list và list2 có các phần tử là phần tử của 2 mảng
//        vừa khai báo.
        List<String> list = new ArrayList<>(Arrays.asList(color));
        List<String> list2 = new ArrayList<>(Arrays.asList(color2));

//        Thêm các phần tử có trong list2 vào trong list, sau đó đưa list2 trở về
//        1 danh sách rỗng (không có phần tử nào) và hiển thị list.
        list.addAll(list2);
        list2.clear();

//        Xóa các phần tử trong list từ phần tử thứ 4 đến phần tử thứ 6. Hiển
//        thị lại list sau khi xóa.
        list.subList(3, 6).clear();
        System.out.println(list);

//        Chuyển các phần tử có trong list thành ký tự in hoa và hiển thị lại
//        list đó.
        list.replaceAll(String::toUpperCase);
        System.out.println(list);

//        Đảo ngược list và hiển thị lại list sau khi đảo ngược.
        list.reversed();
        System.out.println(list.reversed());
    }

}
