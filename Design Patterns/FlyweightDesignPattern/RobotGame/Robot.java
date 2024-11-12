package FlyweightDesignPattern.RobotGame;

public class Robot {
    private String robotType;
    private Sprites sprites;
    private int coordX;
    private int coordY;

    public Robot(String robotType, Sprites sprites) {
        this.robotType = robotType;
        this.sprites = sprites;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getRobotType() {
        return robotType;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public int getCoordX() {
        return coordX;
    }

    public int getCoordY() {
        return coordY;
    }

}
