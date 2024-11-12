package VisitorDesignPattern.InsuranceCompany;

import VisitorDesignPattern.InsuranceCompany.InsuranceClientElements.Individual;
import VisitorDesignPattern.InsuranceCompany.InsuranceVisitors.InsuranceVisitor;

public class Driver {
    public static void main(String[] args) {
        InsuranceVisitor visitor = new InsuranceVisitor();

        visitor.callMethod(new Individual());
    }
}
