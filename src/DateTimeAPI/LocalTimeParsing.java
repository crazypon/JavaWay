package DateTimeAPI;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeParsing {
    /*
    Process is absolutely the same as for LocalDate parsing
     */

    static void parser() {
        String myTime = "10^35^18";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH^mm^ss");
        LocalTime time = LocalTime.parse(myTime, formatter);
        System.out.println(time);
    }

    static void formatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH*mm*ss");
        LocalTime lt = LocalTime.now();
        String myTime = lt.format(formatter);
        System.out.println(myTime);
    }

    public static void main(String[] args) {
        parser();
        formatter();
    }
}
