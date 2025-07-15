package StreamAPI.Basics;

import data.Student;

import java.util.List;

import static data.StudentDatabase.getStudentsDatabase;

public class FlatMapTutorial {
    public static List<String> collectActivities(List<Student> students){
        /*
        * flatMap() performs flattening of the element type you give, here in our stream
        * it is stream of List<String>, toList() cannot make two-dimensional List
        * that is why we are converting it to one-dimensional list of strings
        * */
        return students.stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .toList();
    }

    public static void main(String[] args) {
        System.out.println(collectActivities(getStudentsDatabase()));
    }
}
