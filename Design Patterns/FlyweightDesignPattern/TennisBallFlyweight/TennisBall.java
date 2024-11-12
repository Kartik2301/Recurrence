package FlyweightDesignPattern.TennisBallFlyweight;

public class TennisBall {
    private String color;
    private String url;
    private int coordX;
    private int coordY;

    public TennisBall(String color, String url) {
        this.url = url;
        this.color = color;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public void render() {
        // Render the ball to screen
    }
}
