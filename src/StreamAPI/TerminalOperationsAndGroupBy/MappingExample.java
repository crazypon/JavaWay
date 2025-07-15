package StreamAPI.TerminalOperationsAndGroupBy;

import data.Student;
import data.StudentDatabase;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

public class MappingExample {
    public static void main(String[] args) {

        // same as the line below, honestly I don't understand what's the point
        System.out.println(StudentDatabase.getStudentsDatabase().stream()
                .collect(mapping(Student::getName, toList())));

        System.out.println(StudentDatabase.getStudentsDatabase().stream().map(Student::getName).toList());
    }
}
