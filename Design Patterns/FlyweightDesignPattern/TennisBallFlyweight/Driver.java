package FlyweightDesignPattern.TennisBallFlyweight;

public class Driver {
    public static void main(String[] args) {
        TennisBallFactory tennisBallFactory = new TennisBallFactory();
        
        TennisBall tennisBall1 = tennisBallFactory.getTennisBall("Red", "https://wwww.image.comes/eknj2br");
        tennisBall1.setCoordX(3);
        tennisBall1.setCoordY(12);

        TennisBall tennisBall2 = tennisBallFactory.getTennisBall("Red", "https://wwww.image.comes/eknj2br");
    }
}
