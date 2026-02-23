package optional;

import data.Student;

import java.util.Optional;

public class OrElseTutorial {
    static String OrElseExample() {
        // orElse() provides default value when we give null value
        Optional<Student> student = Optional.ofNullable(null);
        return student.map(Student::getName).orElse("def");
    }

    // orElseGet() same as orElse() but takes Supplier instead
    static String OrElseGetExample() {
        Optional<Student> student = Optional.ofNullable(null);
        return student.map(Student::getName).orElseGet(() -> "def");
    }

    static String orElseThrowExample() {
        Optional<Student> student = Optional.ofNullable(null);
        return student.map(Student::getName).orElseThrow(() -> new RuntimeException("No Such Name"));
    }
    public static void main(String[] args) {
        System.out.println(OrElseExample());
        System.out.println(OrElseGetExample());

        try {
            System.out.println(orElseThrowExample());
        } catch (Exception e) {
            System.out.println("Error Caught: " + e.getMessage());;
        }
    }

}
