package ke.thua;

public class Officers {
    protected String name;
    protected int age;
    protected String gender;
    protected String address;

    protected enum OfficerType {
        ENGINEER,
        STAFF,
        WORKER
    }

    protected OfficerType officerType;

    public Officers(String name, String gender, int age, String address, OfficerType officerType) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.officerType = officerType;
    }
}
