package SingletonDesignPattern;

public class DBConnectionManager {
    private volatile static DBConnectionManager dbConnectionManagerInstance;

    private DBConnectionManager() {}

    public static DBConnectionManager getInstance() {
        if(dbConnectionManagerInstance == null) {
            synchronized(DBConnectionManager.class) {
                if(dbConnectionManagerInstance == null) {
                    dbConnectionManagerInstance = new DBConnectionManager();
                }
            }
        }

        return dbConnectionManagerInstance;
    }

    public void getConnectionDetails() {
        System.out.println("DB Connection Manager - 4 active connections");
    }
}
