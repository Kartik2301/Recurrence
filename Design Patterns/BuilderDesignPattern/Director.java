package BuilderDesignPattern;

public class Director {
    private StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof EngineeringStudentBuilder) {
            return createEngineeringStudent();
        } else if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        }
        return null;
    }

    private Student createEngineeringStudent() {
        return studentBuilder.setRollNumber(25).setAge(23).setStudentName("Jordann Hermann").createStudent();
    }

    private Student createMBAStudent() {
        return studentBuilder.setRollNumber(40).setAge(30).setStudentName("Gaddaff").setFatherName("Hadaff").setMotherName("meow").setSubjectList().createStudent();
    }
}
