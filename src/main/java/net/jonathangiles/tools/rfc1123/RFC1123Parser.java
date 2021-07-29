package net.jonathangiles.tools.rfc1123;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * DAY, DD MON YYYY hh:mm:ss GMT
 * e.g:
 * Sun, 21 Oct 2018 12:16:24 GMT
 */
public class RFC1123Parser {

    public OffsetDateTime parse(String date) {
        return OffsetDateTime.of(
            parseInt(date, 12, 16),  // year
            parseMonth(date, 8, 11), // month
            parseInt(date, 5, 7),    // dayOfMonth
            parseInt(date, 17, 19),  // hour
            parseInt(date, 20, 22),  // minute
            parseInt(date, 23, 25),  // second
            0,                    // nanoOfSecond
            ZoneOffset.UTC);
    }

    private static int parseInt(final CharSequence date, final int start, final int end) {
        int num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + (date.charAt(i) - '0');
        }

        return num;
    }

    private static int parseMonth(final String date, final int start, final int end) {
        switch (date.charAt(start)) {
            case 'J': {
                // Jan, Jun, Jul
                switch (date.charAt(start + 1)) {
                    case 'a': return 1; // Jan
                    case 'u': {
                        switch (date.charAt(start + 2)) {
                            case 'n': return 6; // Jun
                            case 'l': return 7; // Jul
                            default: throw new IllegalArgumentException("Unknown month " + date);
                        }
                    }
                    default: throw new IllegalArgumentException("Unknown month " + date);
                }
            }
            case 'F': return 2; // Feb
            case 'M': {
                // Mar, May
                switch (date.charAt(start + 2)) {
                    case 'r': return 3; // Mar
                    case 'y': return 5; // May
                    default: throw new IllegalArgumentException("Unknown month " + date);
                }
            }
            case 'A': {
                // Apr, Aug
                switch (date.charAt(start + 2)) {
                    case 'r': return 4; // Apr
                    case 'g': return 8; // Aug
                    default: throw new IllegalArgumentException("Unknown month " + date);
                }
            }
            case 'S': return 9; //Sep
            case 'O': return 10; // Oct
            case 'N': return 11; // Nov
            case 'D': return 12; // Dec
            default: throw new IllegalArgumentException("Unknown month " + date);
        }
    }
}
