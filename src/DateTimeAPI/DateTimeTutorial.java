package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeTutorial {
    public static void main(String[] args) {
        //Local time
        LocalTime time = LocalTime.now();
        System.out.println(time);
        //Local Date
        LocalDate date = LocalDate.now();
        System.out.println(date);
        //Local Date Time
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println(dateTime);
    }
}
