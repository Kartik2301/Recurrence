package BuilderDesignPattern;

import java.util.List;

public class Student {
    private int rollNumber;
    private String studentName;
    private String fatherName;
    private String motherName;
    private int age;
    private List<String> subjects;
    
    public Student(StudentBuilder studentBuilder) {
        this.rollNumber = studentBuilder.getRollNumber();
        this.studentName = studentBuilder.getStudentName();
        this.fatherName = studentBuilder.getFatherName();
        this.motherName = studentBuilder.getMotherName();
        this.age = studentBuilder.getAge();
        this.subjects = studentBuilder.getList();
    }

    private String getSubjectList() {
        StringBuilder stringBuilder = new StringBuilder();
        if(subjects == null || subjects.size() == 0) {
            return "NA";
        }
        for(String subject: subjects) {
            stringBuilder.append(subject);
            stringBuilder.append(", ");
        }

        String subjectDescription = stringBuilder.toString().trim();
        return subjectDescription.substring(0, subjectDescription.length() - 1);
    }

    public String toString() {
        String description = "Roll Number is: " + rollNumber + " " +
                             "Student Name is: " + studentName + " " +
                             "Father Name is: " + fatherName + " " +
                             "Mother Name is: " + motherName + " " +
                             "Age: " + age + " " +
                             "Subjects: " + getSubjectList();
        
        return description;
    }
}
