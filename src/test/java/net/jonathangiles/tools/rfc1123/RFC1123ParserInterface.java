package net.jonathangiles.tools.rfc1123;

import java.time.OffsetDateTime;

@FunctionalInterface
public interface RFC1123ParserInterface {

    OffsetDateTime parse(String s);
}
