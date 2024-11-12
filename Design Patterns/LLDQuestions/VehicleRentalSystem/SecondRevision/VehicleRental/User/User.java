package LLDQuestions.VehicleRentalSystem.SecondRevision.VehicleRental.User;

public class User {
    private int id;
    private String userName;
    private int contactNumer;
    private String drivingLicenseNumber;

    public User(String userName, int contactNumer, String drivingLicenseNumber) {
        this.userName = userName;
        this.contactNumer = contactNumer;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getContactNumer() {
        return contactNumer;
    }

    public void setContactNumer(int contactNumer) {
        this.contactNumer = contactNumer;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }
    
}
