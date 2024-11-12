package ProxyDesignPattern;

import ProxyDesignPattern.Employee.EmployeeDAO;
import ProxyDesignPattern.Employee.EmployeeDAOImpl;
import ProxyDesignPattern.Employee.EmployeeDAOProxy;

public class Driver {
    public static void main (String [] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOProxy(new EmployeeDAOImpl());
        try {
            employeeDAO.delete("USER", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
