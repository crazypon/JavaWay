package LambdaFunInterfaces;

import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

/*
* if you forget something just press SHIFT key twice and search for interface or class you need, by
* reading the code it will be much easier to remember, or understand the code
* check the Predicate functional interface, I won't explain what is what here, it is pretty simple
*/

// lambdas embrace code reusability, imagine checking conditions without predicates, imagine that your conditions are
// very big, you will have to repeat yourself by manually putting the same code everywhere and spend
// a lot of time and space.

public class PredicateExample {

    static Predicate<Integer> courseLevel = level -> level >= 4;

    public static void main(String[] args) {
        Predicate<Integer> p1 = (n) -> n % 2 == 0;
        Predicate<Integer> p2 = (n) -> n % 5 == 0;

        System.out.println("4 is even number: " + p1.test(4));
        System.out.println("4 can be divided by 5: " + p2.test(4));
        System.out.println("10 is even and can be divided by 5: " + p1.and(p2).test(10));

        System.out.println("Now negating the upper statement");
        System.out.println("10 is even and can be divided by 5: " + p1.and(p2).negate().test(10));

        System.out.println();
        System.out.println();
        System.out.println("<----- BiPredicate example (with Consumer) ----->");
        // BiPredicate example
        List<Student> students = StudentDatabase.getStudentsDatabase();

        Consumer<Student> studentInfo = student -> System.out.println(student.getName() + " : "
                + student.getActivities());

        BiPredicate<Integer, Double> myPred = (courseLevel, gpa) -> courseLevel >= 3 && gpa >= 3.2;

        students.forEach((student) -> {
            if (myPred.test(student.getCourseLevel(), student.getGpa())) {
                studentInfo.accept(student);
            }
        });

    }
}