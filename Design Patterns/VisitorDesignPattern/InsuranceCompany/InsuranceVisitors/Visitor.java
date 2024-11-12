package VisitorDesignPattern.InsuranceCompany.InsuranceVisitors;

import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Bank;
import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Company;
import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Individual;

public interface Visitor {
    public void visit(Bank bank);
    public void visit(Company company);
    public void visit(Individual individual);
}
