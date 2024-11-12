package VisitorDesignPattern.InsuranceCompany.InsuranceVisitors;

import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Bank;
import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Company;
import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Individual;
import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.InsuranceElement;

public class InsuranceVisitor implements Visitor {

    @Override
    public void visit(Bank bank) {
        System.out.println("Notification Received by: " + bank.getClientName());
    }

    @Override
    public void visit(Company company) {
        System.out.println("Notification Received by: " + company.getClientName());
    }

    @Override
    public void visit(Individual individual) {
        System.out.println("Notification Received by: " + individual.getClientName());
    }


    public void callMethod(InsuranceElement element) {
        element.accept(this);
    }
}
