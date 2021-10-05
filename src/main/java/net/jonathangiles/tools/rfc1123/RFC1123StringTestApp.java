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
import java.util.function.Function;

public class RFC1123StringTestApp {
    // approach one on creating rfc1123 strings:
    private static final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZone(ZoneId.of("UTC")).withLocale(Locale.US);
    private static final Function<OffsetDateTime, String> RFC1123_DATE_TIME_FORMATTER_APPROACH_1 =
        RFC1123_DATE_TIME_FORMATTER::format;

    // approach two on creating rfc1123 strings:
    private static final Function<OffsetDateTime, String> RFC1123_DATE_TIME_FORMATTER_APPROACH_2 =
        DateTimeFormatter.RFC_1123_DATE_TIME::format;

    // approach three on creating rfc1123 strings:
    private static final Function<OffsetDateTime, String> RFC1123_DATE_TIME_FORMATTER_APPROACH_3 =
        RFC1123String::toString;

    private static final boolean DO_EQUALITY_CHECK = true;

    // we collect dates for use in the JMH benchmarks
    private static final boolean COLLECT_DATES = false;
    private static final int NUMBER_OF_DATES_TO_COLLECT = 500;
    private static final List<String> GENERATED_DATES = new ArrayList<>();
    private static final int COUNTDOWN = 100000;

    // Expected output: 'Tue, 05 Oct 2021 01:02:37 GMT'
    public static void main(String[] args) {
        final Random r = new Random();

        Instant instant = Instant.EPOCH;
        int count = COUNTDOWN;
        while (true) {
            OffsetDateTime date = OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);

            String dateString = RFC1123_DATE_TIME_FORMATTER_APPROACH_3.apply(date);

            if (DO_EQUALITY_CHECK) {
                String jdkDateString1 = RFC1123_DATE_TIME_FORMATTER_APPROACH_1.apply(date);
                if (!dateString.equals(jdkDateString1)) {
                    System.out.print("FAIL ");
                    System.out.print(dateString);
                    System.out.print(" != ");
                    System.out.println(jdkDateString1);
                    System.exit(-1);
                }
            }

            if (count-- == 0) {
                // we print occasionally just to show a heartbeat
                System.out.println(dateString);
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
