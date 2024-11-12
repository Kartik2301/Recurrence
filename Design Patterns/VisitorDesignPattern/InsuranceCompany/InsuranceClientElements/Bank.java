package VisitorDesignPattern.InsuranceCompany.InsuranceClientElements;

import VisitorDesignPattern.InsuranceCompany.InsuranceVisitors.Visitor;

public class Bank implements InsuranceElement {
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getClientName() {
        return "Bank";
    }
    
}
