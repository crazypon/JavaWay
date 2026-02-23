package StreamAPI.Basics;

import data.Student;

import java.util.Comparator;
import java.util.List;

import static data.StudentDatabase.getStudentsDatabase;

public class SortedTutorial {
    static List<Student> students = getStudentsDatabase();

    static List<String> sortStudentsByGPA() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getGpa).reversed()) // reversed() makes descending order
                .map(Student::getName)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(sortStudentsByGPA());
    }
}
