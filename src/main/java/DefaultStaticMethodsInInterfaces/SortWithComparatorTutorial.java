package DefaultStaticMethodsInInterfaces;

import data.Student;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import static data.StudentDatabase.getStudentsDatabase;

public class SortWithComparatorTutorial {
    static Consumer<Student> studentPrinter = System.out::println;
    static Comparator<Student> compareGpa = Comparator.comparing(Student::getGpa);
    static Comparator<Student> compareName = Comparator.comparing(Student::getName);

    static void compareBasedOnGpa() {
        List<Student> students = getStudentsDatabase();
        students.sort(compareGpa);
        students.forEach(studentPrinter);
    }

    static void compareBasedOnName() {
        List<Student> students = getStudentsDatabase();
        students.sort(compareName);
        students.forEach(studentPrinter);
    }

    static void compareBasedOnNameAndGpa() {
        List<Student> students = getStudentsDatabase();
        students.sort(compareName.thenComparing(Student::getGpa));
        students.forEach(studentPrinter);
    }

    static void compareWithNulls() {
        List<Student> students = getStudentsDatabase();
        // nullsLast() will show the null values at the end of the List once sorted
        Comparator<Student> withNullsComparator = Comparator.nullsLast(compareName.thenComparing(compareGpa));
        // Comparator<Student> withNullsComparator = Comparator.nullsFirst(compareName.thenComparing(compareGpa));
        students.sort(withNullsComparator);
        students.forEach(studentPrinter);
    }

    public static void main(String[] args) {
        compareBasedOnGpa();
        System.out.println();
        compareBasedOnName();
        System.out.println();
        compareBasedOnNameAndGpa();
        System.out.println();
        compareWithNulls();
    }
}
