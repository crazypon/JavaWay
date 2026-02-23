package StreamAPI.Basics;

import data.StudentDatabase;

public class FindAnyFistTutorial {
    public static void main(String[] args) {
        // findAny() and findFirst() they are different, but this difference is noticeable at concurrent streams
        // they return the first element they encounter
        StudentDatabase.getStudentsDatabase().stream()
                .filter(s -> s.getGpa() >= 3.5)
                .findAny().ifPresent(System.out::println);
    }
}
