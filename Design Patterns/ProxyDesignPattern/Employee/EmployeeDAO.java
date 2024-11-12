package ProxyDesignPattern.Employee;

public interface EmployeeDAO {
    public abstract void create(String client, Employee employee) throws Exception;
    public abstract void delete(String client, int employeeID) throws Exception;
    public abstract Employee get(String client, int employeeID) throws Exception;
}
