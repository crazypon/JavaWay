package DateTimeAPI;

import java.time.Duration;
import java.time.LocalTime;

public class DurationTutorial {
    public static void main(String[] args) {
        /*
        Duration is just as Period, but in a short term, eg 2-hour period, 3.5 sec period
         */
        LocalTime lt = LocalTime.now();
        LocalTime lt2 = LocalTime.of(20, 4);

        Duration duration = Duration.between(lt, lt2);
        System.out.println("In seconds: " + duration.getSeconds());
        System.out.println("In seconds: " + duration.toMinutes());

        /*
        Another way of creating Duration
         */

        Duration myD = Duration.ofDays(3);
        System.out.println(myD.toHours());
    }
}
