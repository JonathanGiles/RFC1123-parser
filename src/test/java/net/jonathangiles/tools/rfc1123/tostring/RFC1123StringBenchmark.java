package net.jonathangiles.tools.rfc1123.tostring;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;

public class RFC1123StringBenchmark {
    public static void main(String[] args) throws IOException {
        org.openjdk.jmh.Main.main(args);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Measurement(iterations = 1, time = 10, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5)
    public void customToStringTest(ExecutionPlan plan, Blackhole blackhole) {
        for (final OffsetDateTime datetime : plan.dates) {
            blackhole.consume(plan.customToString.toString(datetime));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Measurement(iterations = 1, time = 10, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5)
    public void jdkToString1Test(ExecutionPlan plan, Blackhole blackhole) {
        for (final OffsetDateTime datetime : plan.dates) {
            blackhole.consume(plan.jdkToString1.toString(datetime));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Fork(value = 1, warmups = 1)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    @Measurement(iterations = 1, time = 10, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5)
    public void jdkToString2Test(ExecutionPlan plan, Blackhole blackhole) {
        for (final OffsetDateTime datetime : plan.dates) {
            blackhole.consume(plan.jdkToString2.toString(datetime));
        }
    }
}
