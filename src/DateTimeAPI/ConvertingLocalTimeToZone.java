package DateTimeAPI;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertingLocalTimeToZone {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();
        // This way you can see the current time at The zone you want
        ZonedDateTime zdt = ldt.atZone(ZoneId.of("America/Los_Angeles"));
        System.out.println(zdt);
    }
}
