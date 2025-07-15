package StreamAPI.Basics;

import data.Student;

import static data.StudentDatabase.getStudentsDatabase;

public class MapFilterReduceExample {
    public static void main(String[] args) {
        // sum of notebooks of 3+ courseLevel students
        getStudentsDatabase().stream()
                .filter(student -> student.getCourseLevel() >= 3)
                .map(Student::getNotebooks)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);
    }
}
