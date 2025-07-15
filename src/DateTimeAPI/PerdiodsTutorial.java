package DateTimeAPI;

import java.time.LocalDate;
import java.time.Period;

public class PerdiodsTutorial {
    /*
    Period is amount of time passed or that will be passed
     */
    public static void main(String[] args) {

        LocalDate ld = LocalDate.now();
        LocalDate ld2 = LocalDate.of(2028, 8, 20);

        Period myPeriod = ld.until(ld2);
        System.out.println(myPeriod.getDays());
        System.out.println(myPeriod.getMonths());
        System.out.println(myPeriod.getYears());
        // gives amount in months, like not years
        System.out.println(myPeriod.toTotalMonths());

        /*
        Another way of creating Periods
         */

        Period p = Period.between(ld, ld2);
        Period p2 = Period.ofDays(10);
        Period p3 = Period.ofYears(35);
    }

}
