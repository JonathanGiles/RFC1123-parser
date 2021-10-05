package net.jonathangiles.tools.rfc1123;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RFC1123ParserTestApp {
    // for testing purposes only
    private static final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZone(ZoneId.of("UTC")).withLocale(Locale.US);

    private static final boolean DO_EQUALITY_CHECK = true;

    // we collect dates for use in the JMH benchmarks
    private static final boolean COLLECT_DATES = false;
    private static final int NUMBER_OF_DATES_TO_COLLECT = 500;
    private static final List<String> GENERATED_DATES = new ArrayList<>();
    private static final int COUNTDOWN = 100000;

    public static void main(String[] args) {
        final Random r = new Random();
        final RFC1123Parser rfc1123Parser = new RFC1123Parser();

        Instant instant = Instant.EPOCH;
        int count = COUNTDOWN;
        while (true) {
            OffsetDateTime date = OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);
            String dateString = RFC1123_DATE_TIME_FORMATTER.format(date);

            if (DO_EQUALITY_CHECK) {
                OffsetDateTime d1 = OffsetDateTime.parse(dateString, DateTimeFormatter.RFC_1123_DATE_TIME);
                OffsetDateTime d2 = rfc1123Parser.parse(dateString);
                if (!d1.equals(d2)) {
                    System.out.print("FAIL ");
                    System.out.print(d1);
                    System.out.print(" == ");
                    System.out.println(d2);
                    System.exit(-1);
                }
            }

            if (count-- == 0) {
                // we print occasionally just to show a heartbeat
                System.out.println(date);
                count = COUNTDOWN;
                if (COLLECT_DATES) {
                    GENERATED_DATES.add(dateString);
                }
            }

            // move time forward
            instant = instant.plusMillis(r.nextInt(100000));

            if (COLLECT_DATES && GENERATED_DATES.size() == NUMBER_OF_DATES_TO_COLLECT) {
                GENERATED_DATES.forEach(d -> System.out.println("\"" + d + "\","));
                System.exit(0);
            }
        }
    }
}
