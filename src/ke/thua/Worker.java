package ke.thua;

public class Worker extends Officers {
    protected int level;

    public Worker(String name, String gender, int age, String address, int level) {
        super(name, gender, age, address, OfficerType.ENGINEER);
        this.level = level;
    }
}
