package Generic;

import java.util.ArrayList;

public class Exercise2<T> {

    public ArrayList<Integer> arrayList = new ArrayList<>();

    public void loop() {
        for(int i = 1; i <= 10 ; i ++) {
            arrayList.add(i);
        }
    }

    public void log() {
        for (Integer i : arrayList) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Exercise2<Integer> myArray = new Exercise2<Integer>();
        // Sử dụng vòng lặp để nhập các số từ 1 đến 10 vào mảng myarrr
        myArray.loop();
        // Sử dụng vòng lặp để hiển thị các số từ 1 đến 10 từ mảng myarrr.
        myArray.log();
    }
}
