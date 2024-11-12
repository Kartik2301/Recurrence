package ProxyDesignPattern.Employee;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void create(String client, Employee employee) throws Exception {
        System.out.println("Implementation of Create Method");
    }

    @Override
    public void delete(String client, int employeeID) throws Exception {
        System.out.println("Implementation of Delete Method");
    }

    @Override
    public Employee get(String client, int employeeID) throws Exception {
        System.out.println("Implementation of Get Method");
        return new Employee(1, "hermann jordan", "i am hemrann jordan");
    }
    
}
