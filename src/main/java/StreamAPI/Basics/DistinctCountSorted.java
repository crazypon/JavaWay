package StreamAPI.Basics;

import data.Student;

import java.util.List;

import static data.StudentDatabase.getStudentsDatabase;

public class DistinctCountSorted {

    /*
    * in last lesson we learned about flatMap(), now we are going to learn about three very useful methods
    * 1. distinct() - removes duplicates from the stream
    * 2. count() - counts how many values are in the stream
    * 3. sorted() - sorts the elements in the stream (we can implement our own way of sorting algorithms, checkout
    *    SortedTutorial
    * */
    public static void main(String[] args) {
        List<Student> students = getStudentsDatabase();
        List<String> activities = students.stream()
                .filter(s -> s.getGpa() >= 3.2)
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .toList();


        long distinctActivitiesCount = students.stream()
                .filter(s -> s.getGpa() >= 3.2)
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(activities);
        System.out.println("Number of activities: " + distinctActivitiesCount);
    }
}
