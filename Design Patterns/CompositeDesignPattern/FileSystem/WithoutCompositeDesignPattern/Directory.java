package CompositeDesignPattern.FileSystem.WithoutCompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory {
    private String directoryName;
    private List<Object> objects;

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        objects = new ArrayList<>();
    }

    public void ls() {
        System.out.println("Directory Name is: " + directoryName);
        for(Object obj: objects) {
            if(obj instanceof File) {
                ((File) obj).ls();
            } else if(obj instanceof Directory) {
                ((Directory) obj).ls();
            }
        }
    }

    public void add(Object obj) {
        objects.add(obj);
    }
}
