package DateTimeAPI;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTutorial {
    public static void main(String[] args) {
        // This method shows Today's date
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // Custom date, there various constructors, check them out
        LocalDate coronaDate = LocalDate.of(2019, 12, 2);
        System.out.println(coronaDate);
        // here you can get date of a certain day of the year
        LocalDate inDays = LocalDate.ofYearDay(2035, 252);
        System.out.println(inDays);

        // Once date is created you can extract any information you need
        // to get as String use getSomething(), to get numeric value use getSomethingValue()
        System.out.println("String representation: " + coronaDate.getMonth());
        System.out.println("Numeric representation: " + coronaDate.getMonthValue());
        System.out.println("Day of the year(2019) Covid-19 started: " + coronaDate.getDayOfYear());

        /*
        Modifying dates in Java is easy, Dates in java are immutable, that's why every time you want to modify it you
        will get a modified copy
         */
        System.out.println(localDate.plusDays(30));
        System.out.println(localDate.minusDays(9));
        // you minus this way if you want
        System.out.println(localDate.minus(10, ChronoUnit.DAYS));
        // replacing some kind of info
        System.out.println(localDate.withYear(2077));
        System.out.println(localDate.with(ChronoField.MONTH_OF_YEAR, 6));
        // Checkout methods of TemporalAdjusters it has a lot of handy methods
        System.out.println(localDate.with(TemporalAdjusters.firstDayOfNextMonth()));

        /*
        Additional method
         */
        System.out.println(localDate.isLeapYear());

        // Comparing
        System.out.println("IsEqual(): " + localDate.isEqual(coronaDate));
        System.out.println("IsBefore(): " + localDate.isBefore(LocalDate.ofYearDay(2077, 235)));
        System.out.println("IsAfter(): " + localDate.isAfter(coronaDate));

    }
}
