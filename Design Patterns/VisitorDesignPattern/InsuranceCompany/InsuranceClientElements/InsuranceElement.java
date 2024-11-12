package VisitorDesignPattern.InsuranceCompany.InsuranceClientElements;

import VisitorDesignPattern.InsuranceCompany.InsuranceVisitors.Visitor;

public interface InsuranceElement {
    public void accept(Visitor visitor);
    public String getClientName();
}
