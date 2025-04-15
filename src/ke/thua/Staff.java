package ke.thua;

public class Staff extends Officers {
    protected String nameOfWork;

    public Staff(String name, String gender, int age, String address, String nameOfWork) {
        super(name, gender, age, address, OfficerType.ENGINEER);
        this.nameOfWork = nameOfWork;
    }
}
