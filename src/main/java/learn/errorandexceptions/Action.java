package learn.errorandexceptions;

import learn.errorandexceptions.entity.Group;
import learn.errorandexceptions.entity.UniversityClass;
import learn.errorandexceptions.exceptions.*;

import java.util.Map;

public class Action {



    public static void main(String[] args) throws InvalidMarkException, NoStudentClassesException, NoStudentsInGroupException, NoGroupsInFacultyException, NoFacultiesInUniversityException {
        University university = new University();
        university.setClassMark(0, 10, 0);
        university.setClassMark(1, 6, 0);
        university.setClassMark(1, 6, 2);
        university.setClassMark(0, 11, 1);
        university.setClassMark(1, 4, 1);
//        System.out.println(averageStudentAllClassesMark(university, 1));
        System.out.println(averageClassMark(university, university.getLawClasses().get(1), 0,0));
        System.out.println(averageUniversityClassMark(university, university.getLawClasses().get(1)));
    }

    public static double averageStudentAllClassesMark(University university, int student) throws InvalidMarkException, NoStudentClassesException {
        int sumOfMarks = 0;
        Map<UniversityClass, Integer> studentsMarksMap = university.getStudents().get(student).getClassMarks();
        if (studentsMarksMap.size() == 0) throw new NoStudentClassesException(university.getStudents().get(student).getFirstName());
        int marksCount = studentsMarksMap.values().size();
        for (Integer mark : studentsMarksMap.values()) {
            if (mark < 0 || mark > 10) throw new InvalidMarkException(mark);
            sumOfMarks = sumOfMarks + mark;
        }
        return (double) sumOfMarks / marksCount;
    }

    public static double averageClassMark(University university, UniversityClass universityClass, int group_id, int faculty_id) throws NoStudentClassesException, InvalidMarkException, NoStudentsInGroupException, NoGroupsInFacultyException, NoFacultiesInUniversityException {
        int sumOfMarks = 0;
        if(university.getFaculties().size() == 0) throw new NoFacultiesInUniversityException();
        if(university.getFaculties().get(faculty_id).getGroups().size() == 0) throw new NoGroupsInFacultyException(university.getFaculties().get(faculty_id).getName());
        Group group = university.getFaculties().get(faculty_id).getGroups().get(group_id);
        if(group.getStudents().size() == 0) throw new NoStudentsInGroupException(group.getName());
        int marksCount = 0;
        for (int i = 0; i < group.getStudents().size(); i++) {
            if (group.getStudents().get(i).getClassMarks().size() == 0) throw new NoStudentClassesException(group.getStudents().get(i).getFirstName());
            if(group.getStudents().get(i).getClassMarks().get(universityClass) != null) {
                int mark = group.getStudents().get(i).getClassMarks().get(universityClass);
                if (mark < 0 || mark > 10) throw new InvalidMarkException(mark);
                sumOfMarks = sumOfMarks + mark;
                marksCount++;
//                System.out.println(group.getStudents().get(i).getFirstName() + " " + group.getStudents().get(i).getClassMarks().get(universityClass));
            }
        }
//        System.out.println("Average mark of group" + university.getFaculties().get(faculty_id).getGroups().get(group_id).getName() + " = ");
        return (double) sumOfMarks / marksCount;
    }

    public static double averageUniversityClassMark(University university, UniversityClass universityClass) throws NoStudentClassesException, InvalidMarkException, NoStudentsInGroupException, NoGroupsInFacultyException, NoFacultiesInUniversityException {
        double sumOfMarks = 0;
        int numberOfClasses = 0;
        for(int i= 0; i < university.getFaculties().size(); i++) {
            for(int j = 0; j < university.getFaculties().get(i).getGroups().size(); j++) {
                sumOfMarks = sumOfMarks + averageClassMark(university, universityClass, j, i);
                numberOfClasses++;
            }
        }

        return sumOfMarks / numberOfClasses;
    }
}
