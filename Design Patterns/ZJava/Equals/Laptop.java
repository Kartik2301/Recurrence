package ZJava.Equals;

import java.sql.Timestamp;

public class Laptop {
    private String modelName;
    private int chipVersion;
    private Timestamp purchasedDate;
    
    public Laptop(String modelName, int chipVersion, Timestamp purchasedDate) {
        this.modelName = modelName;
        this.chipVersion = chipVersion;
        this.purchasedDate = purchasedDate;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getChipVersion() {
        return chipVersion;
    }

    public void setChipVersion(int chipVersion) {
        this.chipVersion = chipVersion;
    }

    public Timestamp getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(Timestamp purchasedDate) {
        this.purchasedDate = purchasedDate;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Laptop) {
            Laptop compareLaptop = (Laptop) object;
            return this.modelName.equals(compareLaptop.getModelName())
                && this.chipVersion == compareLaptop.chipVersion
                && this.purchasedDate.equals(compareLaptop.getPurchasedDate());
        }
        return false;
    }
}
