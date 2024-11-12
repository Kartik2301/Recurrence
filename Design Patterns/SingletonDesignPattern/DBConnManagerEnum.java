package SingletonDesignPattern;

public enum DBConnManagerEnum {
    INSTANCE;

    public void getConnectionDetails() {
        System.out.println("DB Connection Manager - 3 active connections");
    }
}
