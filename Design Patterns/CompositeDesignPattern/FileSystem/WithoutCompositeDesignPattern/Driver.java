package CompositeDesignPattern.FileSystem.WithoutCompositeDesignPattern;

public class Driver {
    public static void main(String[] args) {
        Directory directory = new Directory("Root");
        directory.add(new File("tom.cat"));
        directory.add(new File("nation.html"));
        Directory directory2 = new Directory("DataDog");
        directory2.add(new File("err.xml"));
        directory.add(directory2);

        directory.ls();
    }
}
