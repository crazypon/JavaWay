package StreamAPI.Basics;

import data.Student;

import java.util.List;

import static data.StudentDatabase.getStudentsDatabase;
import static java.util.stream.Collectors.toList;

public class MapTutorial {
    public static List<String> studentToUpperCasseString(List<Student> students) {
        /*
        * map() converts(transforms) one type to another
        * map() also can modify the passed object
        * */
        return students.stream()
                .map(Student::getName)
                .map(String::toUpperCase)
                .collect(toList());
    }

    public static void main(String[] args) {
        List<Student> students = getStudentsDatabase();
        List<String> upperCasedNames = studentToUpperCasseString(students);
        System.out.println(upperCasedNames);
    }
}
