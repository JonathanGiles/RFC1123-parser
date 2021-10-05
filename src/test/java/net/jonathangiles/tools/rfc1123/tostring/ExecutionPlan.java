package net.jonathangiles.tools.rfc1123.tostring;

import net.jonathangiles.tools.rfc1123.RFC1123Parser;
import net.jonathangiles.tools.rfc1123.RFC1123String;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@State(Scope.Benchmark)
public class ExecutionPlan {
    private static Instant MIN_INSTANT = LocalDateTime.of(1500, 1, 1, 0, 0).toInstant(ZoneOffset.UTC);
    private static Instant MAX_INSTANT = LocalDateTime.of(2500, 12, 31, 23, 59).toInstant(ZoneOffset.UTC);

    @Param({ "1000" })
    public int iterations;

    public RFC1123StringInterface jdkToString1;
    public RFC1123StringInterface jdkToString2;
    public RFC1123StringInterface customToString;

    public List<OffsetDateTime> dates;

    @Setup(Level.Invocation)
    public void setUp() {
        // approach one on creating rfc1123 strings using the JDK:
        final DateTimeFormatter RFC1123_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss 'GMT'").withZone(ZoneId.of("UTC")).withLocale(Locale.US);
        jdkToString1 = RFC1123_DATE_TIME_FORMATTER::format;

        // approach two on creating rfc1123 strings using the JDK:
        jdkToString2 = DateTimeFormatter.RFC_1123_DATE_TIME::format;

        // new, custom method of toString for RFC1123 strings:
        customToString = RFC1123String::toString;

        Instant instant;
        int count = 2000;
        Random r = new Random();
        dates = new ArrayList<>();
        while (true) {
            instant = between(MIN_INSTANT, MAX_INSTANT);

            OffsetDateTime date = OffsetDateTime.ofInstant(instant, ZoneOffset.UTC);
            dates.add(date);

            if (count-- == 0) {
                break;
            }
        }
    }

    public static Instant between(Instant startInclusive, Instant endExclusive) {
        long startSeconds = startInclusive.getEpochSecond();
        long endSeconds = endExclusive.getEpochSecond();
        long random = ThreadLocalRandom
            .current()
            .nextLong(startSeconds, endSeconds);

        return Instant.ofEpochSecond(random);
    }
}