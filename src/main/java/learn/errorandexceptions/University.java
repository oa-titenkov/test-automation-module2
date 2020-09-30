package learn.errorandexceptions;

import learn.errorandexceptions.entity.Faculty;
import learn.errorandexceptions.entity.Group;
import learn.errorandexceptions.entity.Student;
import learn.errorandexceptions.entity.StudyClass;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class University {

    List<StudyClass> classes = Arrays.asList(
            new StudyClass(0, "Political Science"),
            new StudyClass(1, "Psychology"),
            new StudyClass(2, "Criminal Justice"),
            new StudyClass(3, "Economics"),
            new StudyClass(4, "Corporate Finance"),
            new StudyClass(5, "Investment Banking"),
            new StudyClass(6, "Commercial Banking"),
            new StudyClass(7, "Real Estate"),
            new StudyClass(8, "English Language and Literature"),
            new StudyClass(9, "Theatre Arts"),
            new StudyClass(10, "Graphic Design"),
            new StudyClass(11, "Music"),
            new StudyClass(12, "Electrical Engineering"),
            new StudyClass(13, "Mechanical Engineering"),
            new StudyClass(14, "Civil Engineering"),
            new StudyClass(15, "Computer Engineering")
    );

    List<Student> students = Arrays.asList(
            new Student(0, "Dolcie", "Sinclair", new HashMap<>()),
            new Student(1, "Landon", "Bolton", new HashMap<>()),
            new Student(2, "Lilia", "Davila", new HashMap<>()),
            new Student(3, "Renesmae", "Soto", new HashMap<>()),
            new Student(4, "Tayyab", "Hines", new HashMap<>()),
            new Student(5, "Nazifa", "Cook", new HashMap<>()),
            new Student(6, "Remi", "Ewing", new HashMap<>()),
            new Student(7, "Kaiya", "Chester", new HashMap<>()),
            new Student(8, "Samirah", "Cisneros", new HashMap<>()),
            new Student(9, "Liam", "Ellwood", new HashMap<>()),
            new Student(10, "Ellise", "Zhang", new HashMap<>()),
            new Student(11, "Sonnie", "Southern", new HashMap<>()),
            new Student(12, "Waqar", "Fraser", new HashMap<>())
    );

    List<Group> groups = Arrays.asList(
            new Group(0, "L11", students.subList(0, 3)),
            new Group(1, "L12", students.subList(3, 6)),
            new Group(2, "E11", students.subList(6, 9)),
            new Group(3, "E12", students.subList(9, 12))
    );

    List<Faculty> faculties = Arrays.asList(
            new Faculty(0, "Law", groups.subList(0,2)),
            new Faculty(1, "Engineering", groups.subList(2,4))
    );

    public void setMarks() {
        this.setClassMark(0, 1, 1);
        this.setClassMark(1, 1, 2);
        this.setClassMark(2, 1, 3);
        this.setClassMark(3, 1, 4);
        this.setClassMark(4, 1, 5);
        this.setClassMark(5, 1, 6);
        this.setClassMark(6, 1, 7);
        this.setClassMark(7, 1, 8);
        this.setClassMark(8, 1, 9);
        this.setClassMark(9, 1, 10);
        this.setClassMark(10, 1, 8);
        this.setClassMark(11, 1, 9);
        this.setClassMark(12, 1, 5);

    }

    public void setClassMark(int studentId, int studyClassId, int mark) {
        this.getStudents().get(studentId).getClassMarks().put(this.classes.get(studyClassId), mark);
    }

    public List<StudyClass> getClasses() {
        return classes;
    }


    public List<Faculty> getFaculties() {
        return faculties;
    }

    public List<Student> getStudents() {
        return students;
    }



}
