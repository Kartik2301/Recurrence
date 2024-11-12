package CompositeDesignPattern.FileSystem.CompositeDesignPatternSolution;

public class File implements FileSystem {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public void ls() {
        System.out.println("The file name is: " + fileName);
    }
}
