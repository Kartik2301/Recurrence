package LLDQuestions.HashMapImplementation;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Kelloggs", 24);
        map.put("Markist", 56);
        map.put("Stepht", 333);
        map.put("Jeiloios", 1);

        System.out.println(map.get("Stepht"));
        System.out.println(map.get("Markist"));
    }
}
