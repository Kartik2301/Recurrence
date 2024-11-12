package DecoratorDesignPattern.CustomPizzaDesigner.Pizza;

public abstract class Pizza {
    public StringBuilder description;

    public Pizza() {
        if(description == null) {
            description = new StringBuilder();
        }
    }

    public abstract int cost();

    public String getDescription() {
        return description.toString();
    }

    public void addDescription(String desc) {
        this.description.append(desc);
    }
}
