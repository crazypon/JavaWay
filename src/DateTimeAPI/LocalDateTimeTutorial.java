package DateTimeAPI;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeTutorial {


    public static void main(String[] args) {
        // very similar process
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        // Converting time to date time, vice versa is same
        LocalTime lT = LocalTime.now();
        lT.atDate(LocalDate.now());

    }
}
