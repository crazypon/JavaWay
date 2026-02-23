package DateTimeAPI;

import java.time.LocalTime;

public class LocalTimeTutorial {
    public static void main(String[] args) {
        /*
        LocalTime is more or less the same as LocalDate, that's why I decided to keep it short
         */
        LocalTime localTime = LocalTime.now();
        System.out.println("Time: " + localTime);

        System.out.println(localTime.with(LocalTime.NOON));
    }
}
