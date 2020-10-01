package learn.errorandexceptions;

public class Action {

    public static University university = new University();

    public static void main(String[] args) {
        System.out.println(university.averageStudentAllClassesMark(1));
        System.out.println(university.averageGroupClassMark(1, 0,0));
        System.out.println(university.averageUniversityClassMark(1));

    }
}
