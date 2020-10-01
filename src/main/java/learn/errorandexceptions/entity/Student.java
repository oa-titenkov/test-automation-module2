package learn.errorandexceptions.entity;

import java.util.Map;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private Map<StudyClass, Integer> classMarks;
    private Group group;

    public Student(int id, String firstName, String lastName, Map<StudyClass, Integer> classMarks) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.classMarks = classMarks;
    }

    public Student(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<StudyClass, Integer> getClassMarks() {
        return classMarks;
    }

    public void setClassMarks(Map<StudyClass, Integer> classMarks) {
        this.classMarks = classMarks;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
