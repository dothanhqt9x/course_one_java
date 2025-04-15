package ke.thua;

public class OfficersManagement extends Officers {

    public OfficersManagement(String name, String gender, int age, String address, OfficerType officerType) {
        super(name, gender, age, address, officerType);
    }

    public void createStaff(String name, String gender, int age, String address, String nameOfWork) {
        Staff staff = new Staff(name, gender, age, address, nameOfWork);
        System.out.println("Staff created: \nname:" + staff.name + "\ngender:" + staff.gender + "\nage:" + staff.age + "\naddress:" + staff.address + "\nname of work:" + staff.nameOfWork);
    }

    public void createWorker(String name, String gender, int age, String address, int level) {
        Worker worker = new Worker(name, gender, age, address, level);
        System.out.println("Worker created: \nname:" + worker.name + "\ngender:" + worker.gender + "\nage:" + worker.age + "\naddress:" + worker.address + "\nlevel:" + worker.level);
    }

    public void createEngineer(String name, String gender, int age, String address, String trainingIndustry) {
        Engineer engineer = new Engineer(name, gender, age, address, trainingIndustry);
        System.out.println("Engineer created: \nname:" + engineer.name + "\ngender:" + engineer.gender + "\nage:" + engineer.age + "\naddress:" + engineer.address + "\ntraining industry:" + engineer.trainingIndustry);
    }
}
