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
            parseInt(date.substring(12, 16)),  // year
            parseMonth(date.substring(8, 11)), // month
            parseInt(date.substring(5, 7)),    // dayOfMonth
            parseInt(date.substring(17, 19)),  // hour
            parseInt(date.substring(20, 22)),  // minute
            parseInt(date.substring(23, 25)),  // second
            0,                    // nanoOfSecond
            ZoneOffset.UTC);
    }

    private static int parseInt(final String s) {
        // Check for a sign.
        int num  = 0;
        int sign = -1;
        final int len  = s.length();
        final char ch  = s.charAt(0);
        if (ch == '-') {
            sign = 1;
        } else {
            num = '0' - ch;
        }

        int i = 1;
        while ( i < len ) {
            num = num * 10 + '0' - s.charAt(i++);
        }

        return sign * num;
    }

    private static int parseMonth(final String month) {
        switch (month) {
            case "Jan": return 1;
            case "Feb": return 2;
            case "Mar": return 3;
            case "Apr": return 4;
            case "May": return 5;
            case "Jun": return 6;
            case "Jul": return 7;
            case "Aug": return 8;
            case "Sep": return 9;
            case "Oct": return 10;
            case "Nov": return 11;
            case "Dec": return 12;
            default: throw new IllegalArgumentException("Unknown month " + month);
        }
    }
}
