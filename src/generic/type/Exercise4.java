package generic.type;

public class Exercise4 {

    public void Exercise4() {
        Employee employee = new Employee(1, "Nguyen Van A", 2000000);
        var name = employee.getName();
        var salary = employee.getAge();
        var id = employee.getId();
        System.out.println("id:" + id + "name:" + name + "salary:" + salary);
    }
}
