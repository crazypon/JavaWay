package LambdaFunInterfaces;

import data.Student;
import data.StudentDatabase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;


import static LambdaFunInterfaces.PredicateExample.courseLevel;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> func1 = name -> name.toUpperCase();
        Function<String, String> func2 = name -> "Hello " + name + "!";

        // andThen() executes operation left to right "--->"
        System.out.println(func1.andThen(func2).apply("Ilnur"));
        // compose() executes operation right to left "<---"
        System.out.println(func1.compose(func2).apply("George"));

        System.out.println();
        System.out.println();
        System.out.println("<--- Advanced Function Example --->");

        List<Student> studentsDB = StudentDatabase.getStudentsDatabase();

        Function<List<Student>, Map<String, Double>> studentsFilter = students -> {
            Map<String, Double> seniors = new HashMap<>();

            students.forEach(student -> {
                // pay attention to courseLevel predicate, as you see it is reusable, and it again confirmed
                // lambdas reusability
                if(courseLevel.test(student.getCourseLevel())) seniors.put(student.getName(), student.getGpa());
            });

            return seniors;
        };

        System.out.println(studentsFilter.apply(studentsDB));
    }
}
