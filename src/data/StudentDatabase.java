package data;

import java.util.Arrays;
import java.util.List;

public class StudentDatabase {
    public static List<Student> getStudentsDatabase() {

        Student student1 = new Student("George Washington", 4, 3.4,
                Arrays.asList("swimming", "drawing"), 10, Gender.MALE);
        Student student2 = new Student("Peter Parker", 3, 3.5,
                Arrays.asList("bowling", "swimming", "hobbyhorsing"), 9, Gender.MALE);
        Student student3 = new Student("Shawn Mendess", 2, 3.2,
                Arrays.asList("running", "acting"), 8, Gender.FEMALE);
        Student student4 = new Student("Elizabeth Swann", 1, 4.0,
                Arrays.asList("travelling", "diving"), 14, Gender.FEMALE);
        Student student5 = new Student("Lana del Ray", 2, 3.1,
                Arrays.asList("singing", "dancing"), 5, Gender.FEMALE);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        return students;
    }


}
