package optional;

import data.Student;

import java.util.Optional;

import static data.Student.PedroPascal;

public class OptionalExample {
    static Optional<Student> getStudent() {
        // ofNullable() wraps the object into Optional object
        return Optional.ofNullable(PedroPascal.get());
    }

    static Optional<Integer> getStudentName() {
        // with map() you can put some specific data of the object, or you can perform some kind of operation before
        // wrapping it up
        return Optional.ofNullable(PedroPascal.get()).map(Student::getCourseLevel);
    }

    static Optional<Student> getEmptyStudent() {
        return Optional.empty();
    }

    static Optional<String> ofDemo() {
        // off always expects you to put some value, if you put value an exception will be raised
        return Optional.of("Hello world");
    }

    static Optional<Student> getStudentEmpty() {
        return Optional.ofNullable(null);
    }

    public static void main(String[] args) {
        getStudent().ifPresent(System.out::println);

        if(getStudentName().isPresent())
            System.out.println(getStudentName().get());
        else System.out.println("No Student Course Level Was Found");

        if(getEmptyStudent().isEmpty() && getStudentEmpty().isPresent())
            System.out.println("No Pedro Pascal ;(");

        System.out.println(ofDemo().get());
    }
}
