package LLDQuestions.InventoryManagementSystem.Orders;

import java.sql.Timestamp;

public class Invoice {
    private int coreAmount;
    private int amountPayable;
    private Timestamp createdAt;
    private int invoiceID;
    private static int invoiceCounter = 0;

    public Invoice(int coreAmount) {
        this.coreAmount = coreAmount;
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.invoiceID = invoiceCounter;
        this.amountPayable = 15 + coreAmount;
    }

    public int getCoreAmount() {
        return coreAmount;
    }
    public void setCoreAmount(int coreAmount) {
        this.coreAmount = coreAmount;
    }
    public int getAmountPayable() {
        return amountPayable;
    }
    public void setAmountPayable(int amountPayable) {
        this.amountPayable = amountPayable;
    }
    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
    public int getInvoiceID() {
        return invoiceID;
    }

}
