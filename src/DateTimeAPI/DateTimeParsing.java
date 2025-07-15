package DateTimeAPI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeParsing {
    public static void main(String[] args) {
        /*
        Parsing String to LocalDate
         */
        String myDate = "2025-10-13";
        LocalDate parsedDate = LocalDate.parse(myDate);
        System.out.println(parsedDate);

        LocalDate parsedDate2 = LocalDate.parse(myDate, DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parsedDate2);

        String myDate3 = "20251013";
        LocalDate parsedDate3 = LocalDate.parse(myDate3, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(parsedDate3);

        String customDate = "2025|10|13";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy|MM|dd");
        LocalDate parsedDate4 = LocalDate.parse(customDate, formatter);
        System.out.println(parsedDate4);

        /*
        Formatting, LocalDate -> String
         */

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy@MM@dd");
        LocalDate myDate4 = LocalDate.now();
        String stringDate = myDate4.format(formatter2);
        System.out.println(stringDate);
    }
}
