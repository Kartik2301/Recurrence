package BuilderDesignPattern;

import java.util.List;

public abstract class StudentBuilder {
    
    private int rollNumber;
    private String studentName;
    private String fatherName;
    private String motherName;
    private int age;
    List<String> subjects;

    public int getRollNumber() {
        return rollNumber;
    }

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public String getStudentName() {
        return studentName;
    }
    
    public StudentBuilder setStudentName(String studentName) {
        this.studentName = studentName;
        return this;
    }

    public String getFatherName() {
        return fatherName;
    }

    public StudentBuilder setFatherName(String fatherName) {
        this.fatherName = fatherName;
        return this;
    }

    public String getMotherName() {
        return motherName;
    }

    public StudentBuilder setMotherName(String motherName) {
        this.motherName = motherName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public List<String> getList() {
        return subjects;
    }

    public abstract StudentBuilder setSubjectList();

    public Student createStudent() {
        return new Student(this);
    }
    
}
