package CompositeDesignPattern.FileSystem.WithoutCompositeDesignPattern;

public class File {
    private String fileName;

    public File(String fileName) {
        this.fileName = fileName;
    }

    public void ls() {
        System.out.println("File Name is: " + fileName);
    }
}
