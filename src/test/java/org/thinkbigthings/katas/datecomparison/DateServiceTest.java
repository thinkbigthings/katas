package org.thinkbigthings.katas.datecomparison;

import java.time.Clock;
import static java.time.Clock.fixed;
import java.time.Instant;
import static java.time.Instant.parse;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.ZoneId.of;
import java.time.ZoneOffset;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DateServiceTest {
    
    private final DateService service = new DateService(fixed(parse("2016-01-29T00:00:01.00Z"), of("UTC")));
    private final String birthday;
    private final boolean minor;
    
    public DateServiceTest(String inputDate, boolean expectedMinor) {
        birthday = inputDate;
        minor = expectedMinor;
    }
    
    @Test
    public void testIsMinor() {
        assertEquals(minor, service.isMinor(birthday));
    }
    
    @Parameterized.Parameters
    public static Collection getTestArgs() {
        return Arrays.asList(new Object[][] {
            { "01/29/2016", true},
            { "01/30/16",   false},
            { "7/12/1998",  true},
            { "12/16/1996", false},
            { "04/30/2001", true},
            { "9/6/96",     false},
            { "01/02/1995", false},
            { "2/30/1995",  false},
            { "3/31/1997",  false}    
        });
    };
    

}
