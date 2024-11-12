package SingletonDesignPattern;

public class Client {
    public static void main(String[] args) {
        DBConnectionManager dbConnectionManager = DBConnectionManager.getInstance();
        dbConnectionManager.getConnectionDetails();

        // Using Enum
        DBConnManagerEnum dbConn = DBConnManagerEnum.INSTANCE;
        dbConn.getConnectionDetails();
    }
}
