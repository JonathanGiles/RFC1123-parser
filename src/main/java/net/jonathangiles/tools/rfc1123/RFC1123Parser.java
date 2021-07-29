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
            0,                                 // nanoOfSecond
            ZoneOffset.UTC);
    }

    private static int parseInt(final CharSequence date, final int start, final int end) {
        int num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + (date.charAt(i) - '0');
        }

        return num;
    }

    private static int parseMonth(final CharSequence date, final int start, final int end) {
        final char c1 = date.charAt(start);
        final char c2 = date.charAt(start + 1);
        final char c3 = date.charAt(start + 2);

        switch (c1) {
            case 'J': {
                // Jan, Jun, Jul
                switch (c2) {
                    case 'a': return 1; // Jan
                    case 'u': {
                        switch (c3) {
                            case 'n': return 6; // Jun
                            case 'l': return 7; // Jul
                        }
                    }
                }
            }
            case 'F': return 2; // Feb
            case 'M': {
                // Mar, May
                switch (c3) {
                    case 'r': return 3; // Mar
                    case 'y': return 5; // May
                }
            }
            case 'A': {
                // Apr, Aug
                switch (c3) {
                    case 'r': return 4; // Apr
                    case 'g': return 8; // Aug
                }
            }
            case 'S': return 9; //Sep
            case 'O': return 10; // Oct
            case 'N': return 11; // Nov
            case 'D': return 12; // Dec
            default: throw new IllegalArgumentException("Unknown month " + date);
        }

        // The above code is quite long-winded, so a perf benchmark should be run to see if it is any better than the
        // simpler code below
//        switch (month) {
//            case "Jan": return 1;
//            case "Feb": return 2;
//            case "Mar": return 3;
//            case "Apr": return 4;
//            case "May": return 5;
//            case "Jun": return 6;
//            case "Jul": return 7;
//            case "Aug": return 8;
//            case "Sep": return 9;
//            case "Oct": return 10;
//            case "Nov": return 11;
//            case "Dec": return 12;
//            default: throw new IllegalArgumentException("Unknown month " + month);
//        }
    }
}
