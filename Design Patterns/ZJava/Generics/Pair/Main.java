package ZJava.Generics.Pair;

public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<String,Integer>();
        pair.put("Jordax", 500);
        System.out.println(pair.getKey() + " - " + pair.getValue());
    }
}
