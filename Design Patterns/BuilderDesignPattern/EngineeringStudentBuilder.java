package BuilderDesignPattern;

import java.util.Arrays;
import java.util.List;

public class EngineeringStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjectList() {
        List<String> subjects = Arrays.asList("DSA", "DBMS", "OOM", "CN");
        this.subjects = subjects;
        return this;
    }
    
}
