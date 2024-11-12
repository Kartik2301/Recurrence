package FlyweightDesignPattern.RobotGame;

public class Driver {
    public static void main(String[] args) {
        RobotFactory robotFactory = new RobotFactory();
        Robot humanoidRobot =  robotFactory.createRobot("HUMANOID");
        humanoidRobot.setCoordX(3);
        humanoidRobot.setCoordY(5);

        Robot humanoidRobot2 = robotFactory.createRobot("HUMANOID");
        humanoidRobot2.setCoordX(1);
        humanoidRobot2.setCoordY(6);
    }
}
