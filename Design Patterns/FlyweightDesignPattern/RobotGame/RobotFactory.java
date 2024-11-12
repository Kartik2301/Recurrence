package FlyweightDesignPattern.RobotGame;

import java.util.HashMap;
import java.util.Map;

public class RobotFactory {
    private Map<String, Robot> robotMap;

    public RobotFactory() {
        robotMap = new HashMap<>();
    }

    public Robot createRobot(String type) {
        type = type.toLowerCase();
        if(robotMap.containsKey(type)) {
            System.out.println("Request Served from Cache");
            return robotMap.get(type);
        }

        Robot robot = null;

        if(type.equals("humanoid")) {
            robot = new Robot(type, new Sprites(1));
            robotMap.put(type, robot);
        } else if(type.equals("dog")) {
            robot = new Robot(type, new Sprites(2));
            robotMap.put(type, robot);
        }

        System.out.println("Request Served by creating new object");
        return robot;
    }
}
