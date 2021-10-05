package net.jonathangiles.tools.rfc1123;

import java.time.OffsetDateTime;

public class RFC1123String {

    public static String toString(OffsetDateTime datetime) {
        // TODO ensure UTC

        StringBuilder sb = new StringBuilder(32);

        switch (datetime.getDayOfWeek()) {
            case MONDAY: sb.append("Mon, "); break;
            case TUESDAY: sb.append("Tue, "); break;
            case WEDNESDAY: sb.append("Wed, "); break;
            case THURSDAY: sb.append("Thu, "); break;
            case FRIDAY: sb.append("Fri, "); break;
            case SATURDAY: sb.append("Sat, "); break;
            case SUNDAY: sb.append("Sun, "); break;
        }

        sb.append(datetime.getDayOfMonth());

        switch (datetime.getMonth()) {
            case JANUARY: sb.append(" Jan "); break;
            case FEBRUARY: sb.append(" Feb "); break;
            case MARCH: sb.append(" Mar "); break;
            case APRIL: sb.append(" Apr "); break;
            case MAY: sb.append(" May "); break;
            case JUNE: sb.append(" Jun "); break;
            case JULY: sb.append(" Jul "); break;
            case AUGUST: sb.append(" Aug "); break;
            case SEPTEMBER: sb.append(" Sep "); break;
            case OCTOBER: sb.append(" Oct "); break;
            case NOVEMBER: sb.append(" Nov "); break;
            case DECEMBER: sb.append(" Dec "); break;
        }

        sb.append(datetime.getYear());
        sb.append(" ");

        zeroPad(datetime.getHour(), sb);
        sb.append(":");
        zeroPad(datetime.getMinute(), sb);
        sb.append(":");
        zeroPad(datetime.getSecond(), sb);
        sb.append(" GMT");

        return sb.toString();
    }

    private static void zeroPad(int value, StringBuilder sb) {
        if (value < 10) {
            sb.append("0");
        }
        sb.append(value);
    }
}