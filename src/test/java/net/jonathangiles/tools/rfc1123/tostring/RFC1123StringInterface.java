package net.jonathangiles.tools.rfc1123.tostring;

import java.time.OffsetDateTime;

@FunctionalInterface
public interface RFC1123StringInterface {

    String toString(OffsetDateTime datetime);
}
