package StreamAPI.Basics;

import data.Student;
import static data.StudentDatabase.getStudentsDatabase;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example1 {
    public static void main(String[] args) {
        // static import (nice function btw)
        List<Student> students = getStudentsDatabase();
        /*
        * with the help of peek() we can debug the stream by printing out its values,
        * pay attention to the order by checking the ID of the object
        * */
        Map<String, List<String>> studentActivities = students.stream()
                .peek(s -> System.out.println("Before filter 1 " + s))
                .filter(s -> s.getCourseLevel() >= 3)
                .peek(s -> System.out.println("Before filter 2 " + s))
                .filter(s -> s.getGpa() >= 3.5)
                .peek(s -> System.out.println("After filter 2 " + s))
                .collect(Collectors.toMap(Student::getName, Student::getActivities));

        System.out.println("Result: " + studentActivities);
    }
}
