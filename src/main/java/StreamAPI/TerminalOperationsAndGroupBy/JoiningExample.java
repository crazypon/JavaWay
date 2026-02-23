package StreamAPI.TerminalOperationsAndGroupBy;

import data.Student;
import data.StudentDatabase;

import java.util.stream.Collectors;

public class JoiningExample {

    static String joiningV1() {
        return StudentDatabase.getStudentsDatabase().stream()
                .map(Student::getName)
                .collect(Collectors.joining());
    }

    static String joiningV2() {
        return StudentDatabase.getStudentsDatabase().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));
    }

    static String joiningV3() {
        return StudentDatabase.getStudentsDatabase().stream()
                .map(Student::getName)
                .collect(Collectors.joining("-", "|", "|"));
    }

    public static void main(String[] args) {
        System.out.println("Joining V1: "  + joiningV1());
        System.out.println("Joining V2: "  + joiningV2());
        System.out.println("Joining V3: "  + joiningV3());
    }
}
