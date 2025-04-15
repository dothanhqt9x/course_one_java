package ke.thua;

public class Engineer extends Officers {
    protected String trainingIndustry;

    public Engineer(String name, String gender, int age, String address, String trainingIndustry) {
        super(name, gender, age, address, OfficerType.ENGINEER);
        this.trainingIndustry = trainingIndustry;
    }
}
