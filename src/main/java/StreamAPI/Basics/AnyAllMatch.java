package StreamAPI.Basics;

import static data.StudentDatabase.getStudentsDatabase;

public class AnyAllMatch {
    /*
    match functions return boolean and they are terminal operators
     */

    // checks whether all elements match the predicate
    static boolean allMatchFunc() {
        return getStudentsDatabase().stream()
                .allMatch(s -> s.getGpa() >= 2);
    }

    // checks whether at least one element matches the predicate
    static boolean anyMatchFunc() {
        return getStudentsDatabase().stream()
                .anyMatch(s -> s.getGpa() >= 3.5);
    }

    // checks if no element is found in the stream
    static boolean nonMatchFunc() {
        return getStudentsDatabase().stream()
                .noneMatch(s -> s.getGpa() >= 4.1);
    }

    public static void main(String[] args) {
        System.out.println(allMatchFunc());
        System.out.println(anyMatchFunc());
        System.out.println(nonMatchFunc());
    }
}
