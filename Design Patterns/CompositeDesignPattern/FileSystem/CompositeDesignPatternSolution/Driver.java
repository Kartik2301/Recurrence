package CompositeDesignPattern.FileSystem.CompositeDesignPatternSolution;

public class Driver {
    public static void main(String[] args) {
        Directory directory = new Directory("Movies");
        directory.add(new File("Inception"));
        directory.add(new File("Monkey dance"));

        Directory directory2 = new Directory("Horror Shows");
        directory2.add(new File("GOT-S8"));
        directory.add(directory2);

        directory.ls();
    }
}
