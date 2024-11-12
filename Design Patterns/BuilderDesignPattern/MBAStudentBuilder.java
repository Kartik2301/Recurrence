package BuilderDesignPattern;

import java.util.Arrays;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {

    @Override
    public StudentBuilder setSubjectList() {
        List<String> subjects = Arrays.asList("Marketing", "Accountancy", "Economics", "Forecasting");
        this.subjects = subjects;
        return this;
    }
    
}
