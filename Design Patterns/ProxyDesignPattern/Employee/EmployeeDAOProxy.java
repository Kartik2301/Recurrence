package ProxyDesignPattern.Employee;

public class EmployeeDAOProxy implements EmployeeDAO {

    EmployeeDAOImpl employeeDAOImpl;

    public EmployeeDAOProxy(EmployeeDAOImpl employeeDAOImpl) {
        this.employeeDAOImpl = employeeDAOImpl;
    }

    @Override
    public void create(String client, Employee employee) throws Exception {
        if(client.toLowerCase().equals("admin")) {
            employeeDAOImpl.create(client, employee);
        } else {
            throw new Exception("You dumb user, you cannot create a user you weasel");
        }
    }

    @Override
    public void delete(String client, int employeeID) throws Exception {
        if(client.toLowerCase().equals("admin")) {
            employeeDAOImpl.delete(client, employeeID);
        } else {
            throw new Exception("You dumb user, you cannot delete a user you dumb weasel");
        }
    }

    @Override
    public Employee get(String client, int employeeID) throws Exception {
        return employeeDAOImpl.get(client, employeeID);
    }
    
}
