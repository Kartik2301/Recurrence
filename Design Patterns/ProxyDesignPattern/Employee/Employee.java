package ProxyDesignPattern.Employee;

public class Employee {
    private int id;
    private String userName;
    private String bio;

    public Employee(int id, String userName, String bio) {
        this.id = id;
        this.userName = userName;
        this.bio = bio;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
