package DecoratorDesignPattern.Starbuzz.Coffee;

public abstract class Beverage {
    protected String description;
    protected ServeSize serveSize = ServeSize.TALL;

    public String getDescription() {
        return description;
    }

    public ServeSize getSize() {
        return serveSize;
    }

    public void setSize(ServeSize serveSize) {
        this.serveSize = serveSize;
    }

    public abstract int getCost();
}
