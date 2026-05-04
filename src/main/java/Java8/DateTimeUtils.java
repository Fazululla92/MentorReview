package Java8;
import java.time.*;
import java.util.function.*;

public class DateTimeUtils {
    public static Predicate<LocalDate> isYesterday() {
        return date -> date.equals(LocalDate.now().minusDays(1));
    }

    public static Supplier<LocalDate> nextThursday() {
        return () -> {
            LocalDate today = LocalDate.now();
            int daysUntilThursday = DayOfWeek.THURSDAY.getValue() - today.getDayOfWeek().getValue();
            if (daysUntilThursday <= 0) {
                daysUntilThursday += 7;
            }
            return today.plusDays(daysUntilThursday);
        };
    }
    public static Supplier<ZonedDateTime> currentTimeInEST() {
        return () -> ZonedDateTime.now(ZoneId.of("America/New_York"));
    }

    public static Function<LocalDate, Integer> calculateAge() {
        return dob -> {
            LocalDate today = LocalDate.now();
            return Period.between(dob, today).getYears();
        };
    }
    public static void main(String[] args) {
        LocalDate testDate = LocalDate.now().minusDays(1); // yesterday
        System.out.println("Is yesterday? " + isYesterday().test(testDate));

        System.out.println("Next Thursday: " + nextThursday().get());

        System.out.println("Current EST time: " + currentTimeInEST().get());

        LocalDate dob = LocalDate.of(1990, 5, 15);
        System.out.println("Age: " + calculateAge().apply(dob));
    }
}
