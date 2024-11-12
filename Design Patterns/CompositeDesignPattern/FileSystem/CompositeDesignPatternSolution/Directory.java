package CompositeDesignPattern.FileSystem.CompositeDesignPatternSolution;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    private String directoryName;
    private List<FileSystem> fileSystemList;

    public Directory(String directoryName) {
        fileSystemList = new ArrayList<>();
        this.directoryName = directoryName;
    }

    public void add(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Directory name is: " + directoryName);

        for(FileSystem fileSystem: fileSystemList) {
            fileSystem.ls();
        }
    }
    
}
