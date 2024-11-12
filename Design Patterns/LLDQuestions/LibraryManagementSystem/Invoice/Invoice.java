package LLDQuestions.LibraryManagementSystem.Invoice;

public class Invoice {
    private double coreAmount;

    public Invoice(double coreAmount) {
        this.coreAmount = coreAmount;
    }

    public double getCoreAmount() {
        return coreAmount;
    }

    public void setCoreAmount(int coreAmount) {
        this.coreAmount = coreAmount;
    }
}
