package exceptions;

import exceptions.entity.Faculty;
import exceptions.entity.Group;
import exceptions.entity.Student;
import exceptions.entity.UniversityClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class University {

    List<UniversityClass> lawClasses = Arrays.asList(
            new UniversityClass(0, "Political Science"),
            new UniversityClass(1, "Psychology"),
            new UniversityClass(2, "Criminal Justice"),
            new UniversityClass(3, "Economics")
    );

    List<UniversityClass> financeClasses = Arrays.asList(
            new UniversityClass(4, "Corporate Finance"),
            new UniversityClass(5, "Investment Banking"),
            new UniversityClass(6, "Commercial Banking"),
            new UniversityClass(7, "Real Estate")
    );

    List<UniversityClass> artClasses = Arrays.asList(
            new UniversityClass(8, "English Language and Literature"),
            new UniversityClass(9, "Theatre Arts"),
            new UniversityClass(10, "Graphic Design"),
            new UniversityClass(11, "Music")
    );

    List<UniversityClass> engineeringClasses = Arrays.asList(
            new UniversityClass(12, "Electrical Engineering"),
            new UniversityClass(13, "Mechanical Engineering"),
            new UniversityClass(14, "Civil Engineering"),
            new UniversityClass(15, "Computer Engineering")
    );

    List<Student> students = Arrays.asList(
            new Student(0, "Dolcie", "Sinclair", new HashMap<>()),
            new Student(1, "Landon", "Bolton", new HashMap<>()),
            new Student(2, "Lilia", "Davila", new HashMap<>())
//            new Student(3, "Renesmae", "Soto", new HashMap<>()),
//            new Student(4, "Tayyab", "Hines", new HashMap<>()),
//            new Student(5, "Nazifa", "Cook", new HashMap<>()),
//            new Student(6, "Remi", "Ewing", new HashMap<>()),
//            new Student(7, "Kaiya", "Chester", new HashMap<>()),
//            new Student(8, "Samirah", "Cisneros", new HashMap<>()),
//            new Student(9, "Liam", "Ellwood", new HashMap<>()),
//            new Student(10, "Ellise", "Zhang", new HashMap<>()),
//            new Student(11, "Sonnie", "Southern", new HashMap<>()),
//            new Student(12, "Waqar", "Fraser", new HashMap<>())
    );

    List<Group> groups = Arrays.asList(
            new Group(0, "L11", students),
            new Group(1, "L12", students),
            new Group(2, "L13", students),
            new Group(3, "F11", students),
            new Group(4, "F12", students),
            new Group(5, "F13", students),
            new Group(6, "A11", students),
            new Group(7, "A12", students),
            new Group(8, "A13", students),
            new Group(9, "E11", students),
            new Group(10, "E12", students),
            new Group(11, "E13", students)
    );

    List<Faculty> faculties = Arrays.asList(
            new Faculty(0, "Law", groups.subList(0,3)),
            new Faculty(1, "Finance", groups.subList(3,6)),
            new Faculty(2, "Art", groups.subList(6,9)),
            new Faculty(3, "Engineering", groups.subList(9,12))
    );

    public void setClassMark(int universityClassId, int mark, int studentId) {

        this.getStudents().get(studentId).getClassMarks().put(this.lawClasses.get(universityClassId), mark);
    }

    public List<UniversityClass> getLawClasses() {
        return lawClasses;
    }

    public void setLawClasses(List<UniversityClass> lawClasses) {
        this.lawClasses = lawClasses;
    }

    public List<UniversityClass> getFinanceClasses() {
        return financeClasses;
    }

    public void setFinanceClasses(List<UniversityClass> financeClasses) {
        this.financeClasses = financeClasses;
    }

    public List<UniversityClass> getArtClasses() {
        return artClasses;
    }

    public void setArtClasses(List<UniversityClass> artClasses) {
        this.artClasses = artClasses;
    }

    public List<UniversityClass> getEngineeringClasses() {
        return engineeringClasses;
    }

    public void setEngineeringClasses(List<UniversityClass> engineeringClasses) {
        this.engineeringClasses = engineeringClasses;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
