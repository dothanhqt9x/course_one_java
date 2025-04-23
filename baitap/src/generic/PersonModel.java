package generic;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel <T> {
    public ArrayList<T> li = new ArrayList<T>();

    public void addObject(T object){
        li.add(object);
    }

    public void display(){
        for (T e:li){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        PersonModel<String> nameModel = new PersonModel<>();
        int nameQuantity;
        System.out.print("Nhập số lượng họ tên: ");
        nameQuantity = scanner.nextInt();
        for (int i= 1; i <= nameQuantity; i++){
            String name = PersonUtils.inputName(i);
            nameModel.addObject(name);
        }
        System.out.println("Danh sách họ tên vừa nhập:");
        nameModel.display();

        scanner.close();
    }
}

