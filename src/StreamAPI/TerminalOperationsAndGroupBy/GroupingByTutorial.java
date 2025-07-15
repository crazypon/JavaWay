package StreamAPI.TerminalOperationsAndGroupBy;

import data.Gender;
import data.Student;
import data.StudentDatabase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class GroupingByTutorial {
    static List<Student> students = StudentDatabase.getStudentsDatabase();

    static Map<Gender, List<Student>> groupByGender() {
        return students.stream()
                .collect(groupingBy(Student::getGender));
    }

    // now keys are string not enum
    static Map<String, List<Student>> customGroupBy() {
        return students.stream()
                .collect(groupingBy(s -> s.getGender().toString()));
    }

    static Map<String, List<Student>> customGroupBy2() {
        return students.stream()
                // just return the key you want store the student in
                .collect(groupingBy(s ->
                    s.getGpa() >= 3.5 ? "OUTSTANDING" : "AVERAGE"
                ));
    }

    /*
    when you specify two parameters inside groupingBy() it becomes key-value pair, like first parameter is key,
    the second one is value
     */
    static Map<Integer, Map<String, List<Student>>> twoLevelGrouping() {
        return students.stream()
                .collect(groupingBy(Student::getCourseLevel,
                        groupingBy(s ->
                                s.getGpa() >= 3.5 ? "OUTSTANDING" : "AVERAGE"
                        )));
    }

    static Map<Integer, Integer> customGroupBy3() {
        return students.stream()
                .collect(groupingBy(
                        Student::getCourseLevel,
                        summingInt(Student::getCourseLevel)
                ));
    }

    static Map<String, Set<Student>> threeLevelGroupBy() {
        return students.stream()
                .collect(
                        groupingBy(Student::getName, LinkedHashMap::new, toSet())
                );
    }

    static Map<String, Optional<Student>> groupTopGPA() {
        return students.stream()
                .collect(groupingBy(
                        Student::getName,
                        maxBy(Comparator.comparing(Student::getGpa))
                ));
    }

    /*
    collectAndThen() is very useful method, once getting the student we want, it will help us to get the data
    we need, look at groupTopGPa() it returns Optional<Student>, if we don't want that we should use collectAndThen()
     */
    static Map<String, Double> groupTopGpaAndThen() {
        return students.stream()
                .collect(groupingBy(
                        Student::getName,
                        collectingAndThen(
                                maxBy(Comparator.comparing(Student::getGpa)),
                                s -> s.get().getGpa())
                ));
    }

    public static void main(String[] args) {
        System.out.println(groupByGender());
        System.out.println();
        System.out.println(customGroupBy());
        System.out.println();
        System.out.println(customGroupBy2());
        System.out.println();
        System.out.println(twoLevelGrouping());
        System.out.println("Custom Group By #3");
        System.out.println(customGroupBy3());
        System.out.println();
        System.out.println(threeLevelGroupBy());
        System.out.println("Top GPA");
        System.out.println(groupTopGPA());
        System.out.println();
        System.out.println(groupTopGpaAndThen());
    }
}
