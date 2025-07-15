package optional;

import data.Bike;
import data.Student;
import data.StudentDatabase;

import java.util.Optional;

import static data.Student.PedroPascal;

public class FilterMapFlatMapTutorial {
    static void myFilterExample() {
        Optional<Student> student = Optional.ofNullable(PedroPascal.get());
        student.filter(s -> s.getGpa() >= 3.5)
                .ifPresent(System.out::println);
    }

    static void myMapExample() {
        Optional<Student> student = Optional.ofNullable(PedroPascal.get());
        student.filter(s -> s.getGpa() >= 3.5)
                .map(Student::getName)
                .ifPresent(System.out::println);
    }

    /*
    flatMap() is basically used when there is Optional inside of Optional, in this example Student has Optional<Bike>
    whereas Student itself is inside Optional
     */
    static void myFlatMapExample() {
        Optional<Student> student = Optional.ofNullable(PedroPascal.get());
        student.filter(s -> s.getGpa() >= 3.5)
                // just provide which member variable you need
                .flatMap(Student::getBike)
                .map(Bike::getName)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        myFilterExample();
        myMapExample();
        myFlatMapExample();
    }
}
