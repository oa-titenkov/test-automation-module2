package learn.errorandexceptions;

import learn.errorandexceptions.entity.Faculty;
import learn.errorandexceptions.entity.Group;
import learn.errorandexceptions.entity.Student;
import learn.errorandexceptions.entity.StudyClass;
import learn.errorandexceptions.exceptions.*;

import java.util.Map;

public class Action {

    public static University university = new University();

    public static void main(String[] args) {
        university.setMarks();

        System.out.println(averageStudentAllClassesMark(1));
        System.out.printf("%.2f %n", averageClassMark(university.getClasses().get(1), 0,0));
        System.out.println(averageUniversityClassMark(university.getClasses().get(1)));
    }

    public static String averageStudentAllClassesMark(int studentId) {
        Student student = university.getStudents().get(studentId);
        Map<StudyClass, Integer> studentMarksMap = student.getClassMarks();
        if (studentMarksMap.size() == 0) {
            throw new NoStudentClassesException(student.getFirstName());
        }

        int sumOfMarks = 0;
        int marksCount = studentMarksMap.values().size();
        for (Integer mark : studentMarksMap.values()) {
            if (mark < 0 || mark > 10) throw new InvalidMarkException(mark);
            sumOfMarks = sumOfMarks + mark;
        }
        String averageMark = String.format("%.2f", (double) sumOfMarks / marksCount);
        return student.getFirstName() + "'s average mark for all classes =  " + averageMark;

    }

    public static double averageClassMark(StudyClass studyClass, int groupId, int facultyId) {
        if(university.getFaculties().size() == 0) {
            throw new NoFacultiesInUniversityException();
        }

        Faculty faculty = university.getFaculties().get(facultyId);
        if(university.getFaculties().get(facultyId).getGroups().size() == 0) {
            throw new NoGroupsInFacultyException(university.getFaculties().get(facultyId).getName());
        }

        Group group = faculty.getGroups().get(groupId);
        if(group.getStudents().size() == 0) {
            throw new NoStudentsInGroupException(group.getName());
        }

        int sumOfMarks = 0;
        int marksCount = 0;
        for (int i = 0; i < group.getStudents().size(); i++) {
            if (group.getStudents().get(i).getClassMarks().size() == 0) {
                throw new NoStudentClassesException(group.getStudents().get(i).getFirstName());
            }
            if(group.getStudents().get(i).getClassMarks().get(studyClass) != null) {
                int mark = group.getStudents().get(i).getClassMarks().get(studyClass);
                if (mark < 0 || mark > 10) {
                    throw new InvalidMarkException(mark);
                }
                sumOfMarks = sumOfMarks + mark;
                marksCount++;
            }
        }
        return (double) sumOfMarks / marksCount;
    }

    public static double averageUniversityClassMark(StudyClass studyClassId) {
        double sumOfMarks = 0;
        int numberOfClasses = 0;
        for(int i= 0; i < university.getFaculties().size(); i++) {
            for(int j = 0; j < university.getFaculties().get(i).getGroups().size(); j++) {
                double averageClassMark = averageClassMark(studyClassId, j, i);
                if(averageClassMark != 0) {
                    sumOfMarks = sumOfMarks + averageClassMark;
                    numberOfClasses++;
                }
            }
        }
        return sumOfMarks / numberOfClasses;
    }
}
