package StateDesignPattern.ATM.User;

public class User {
    private String userName;
    private int userPin;
    private int accountBalance;

    public User(String userName, int userPin, int accountBalance) {
        this.userName = userName;
        this.userPin = userPin;
        this.accountBalance = accountBalance;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserPin() {
        return userPin;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalanceDelta) {
        this.accountBalance -= accountBalanceDelta;
    }

    public void setUserPin(int userPin) {
        this.userPin = userPin;
    }

}
