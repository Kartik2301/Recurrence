package FlyweightDesignPattern.TennisBallFlyweight;

import java.util.HashMap;
import java.util.Map;

public class TennisBallFactory {
    Map<String, TennisBall> map;

    public TennisBallFactory() {
        map = new HashMap<>();
    }

    public TennisBall getTennisBall(String color, String url) {
        String key = new StringBuilder(color).append("_").append(url).toString();
        TennisBall tennisBall = map.get(key);

        if(tennisBall == null) {
            System.out.println("Request Served by creating new object");
            tennisBall = new TennisBall(color, url);
            map.put(key, tennisBall);
        }

        return tennisBall;
    }
}
