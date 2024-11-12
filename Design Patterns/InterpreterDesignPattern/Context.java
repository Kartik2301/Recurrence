package InterpreterDesignPattern;

import java.util.HashMap;
import java.util.Map;

public class Context {
    private Map<String, Integer> map;

    public Context() {
        map = new HashMap<>();
    }

    public void addValue(String key, int value) {
        map.put(key, value);
    }

    public int getValue(String key) {
        return map.get(key);
    }
}
