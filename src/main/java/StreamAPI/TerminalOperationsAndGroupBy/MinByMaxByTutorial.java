package StreamAPI.TerminalOperationsAndGroupBy;

import data.Student;
import data.StudentDatabase;

import java.util.Comparator;

import static java.util.stream.Collectors.maxBy;

public class MinByMaxByTutorial {
    public static void main(String[] args) {
        /*
        according to ChatGPT the difference between max() and maxBy() is when they should be used, maxBy() should be
        used when grouping some collections, and it is used inside collect as you see. Honestly, don't know the exact
        advantage, since I haven't learnt grouping yet

        if you just need the max element just use max()
         */
        System.out.println("MaxBy");
        System.out.println(StudentDatabase.getStudentsDatabase().stream()
                .collect(maxBy(Comparator.comparing(Student::getGpa))));
    }
}
