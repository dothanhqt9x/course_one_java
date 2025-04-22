package generic.type;

import collections.Student;

public class Exercise3 {

    public void Exercise3() {
        Student student = new Student(1, "Nguyen Van A", 20);
        var name = student.getName();
        var age = student.getAge();
        var id = student.getId();
        System.out.println("id:" + id + "name:" + name + "age:" + age);
    }

}

