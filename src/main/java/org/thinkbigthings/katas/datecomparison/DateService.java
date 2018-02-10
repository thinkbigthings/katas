package org.thinkbigthings.katas.datecomparison;

import java.time.Clock;
import static java.time.format.DateTimeFormatter.ofPattern;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
A Clock could be injected with a configuration like:

@Configuration
public class Config {
    
    @Bean
    public Clock createSystemClock() {
        return Clock.systemDefaultZone();
    }
}
*/
public class DateService {

    private static final DateTimeFormatter FORMATTER = new DateTimeFormatterBuilder()
                                                                .parseLenient()
                                                                .appendOptional(ofPattern("M/d/yy"))
                                                                .toFormatter();

    private final Clock clock;

    public DateService(Clock clock) {
        this.clock = clock;
    }
    
    public boolean isMinor(String date) {
        
        LocalDate today = LocalDate.now(clock);

        // two-digit years are generally parsed as being in the current century, so keep them in the past
        LocalDate inputAge = LocalDate.parse(date, FORMATTER);
        inputAge = inputAge.isAfter(today) ? inputAge.minusYears(100) : inputAge;

        return Period.between(inputAge, today).getYears() < 18;
    }

}
