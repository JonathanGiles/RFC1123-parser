package net.jonathangiles.tools.rfc1123;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@State(Scope.Benchmark)
public class ExecutionPlan {

    @Param({ "1000" })
    public int iterations;

    public RFC1123ParserInterface newParser;
    public RFC1123ParserInterface oldParser;
    public List<String> datesToParse;

    @Setup(Level.Invocation)
    public void setUp() {
        final RFC1123Parser rfc1123Parser = new RFC1123Parser();
        newParser = rfc1123Parser::parse;

        oldParser = s -> OffsetDateTime.parse(s, DateTimeFormatter.RFC_1123_DATE_TIME);

        datesToParse = new ArrayList<>(DATES_TO_PARSE);
    }

    private static final List<String> DATES_TO_PARSE = Arrays.asList(
        "Fri, 27 Feb 1970 23:08:12 GMT",
        "Mon, 27 Apr 1970 00:50:17 GMT",
        "Tue, 23 Jun 1970 21:28:08 GMT",
        "Thu, 20 Aug 1970 18:21:45 GMT",
        "Sat, 17 Oct 1970 12:54:17 GMT",
        "Mon, 14 Dec 1970 08:50:14 GMT",
        "Wed, 10 Feb 1971 04:14:31 GMT",
        "Fri, 09 Apr 1971 01:45:48 GMT",
        "Sun, 06 Jun 1971 00:09:07 GMT",
        "Mon, 02 Aug 1971 22:43:26 GMT",
        "Wed, 29 Sep 1971 17:14:20 GMT",
        "Fri, 26 Nov 1971 16:50:23 GMT",
        "Sun, 23 Jan 1972 13:02:38 GMT",
        "Tue, 21 Mar 1972 11:12:32 GMT",
        "Thu, 18 May 1972 07:59:50 GMT",
        "Sat, 15 Jul 1972 06:25:29 GMT",
        "Mon, 11 Sep 1972 04:59:34 GMT",
        "Tue, 07 Nov 1972 23:40:17 GMT",
        "Thu, 04 Jan 1973 18:44:52 GMT",
        "Sat, 03 Mar 1973 15:27:38 GMT",
        "Mon, 30 Apr 1973 11:47:27 GMT",
        "Wed, 27 Jun 1973 06:44:03 GMT",
        "Thu, 23 Aug 1973 22:52:24 GMT",
        "Sat, 20 Oct 1973 19:58:24 GMT",
        "Mon, 17 Dec 1973 16:45:22 GMT",
        "Wed, 13 Feb 1974 13:23:29 GMT",
        "Fri, 12 Apr 1974 13:50:39 GMT",
        "Sun, 09 Jun 1974 10:57:57 GMT",
        "Tue, 06 Aug 1974 09:32:29 GMT",
        "Thu, 03 Oct 1974 05:22:00 GMT",
        "Sat, 30 Nov 1974 00:39:10 GMT",
        "Mon, 27 Jan 1975 00:49:20 GMT",
        "Wed, 26 Mar 1975 00:27:01 GMT",
        "Thu, 22 May 1975 23:00:07 GMT",
        "Sat, 19 Jul 1975 23:41:31 GMT",
        "Mon, 15 Sep 1975 20:30:55 GMT",
        "Wed, 12 Nov 1975 15:22:23 GMT",
        "Fri, 09 Jan 1976 14:05:12 GMT",
        "Sun, 07 Mar 1976 09:44:23 GMT",
        "Tue, 04 May 1976 07:55:55 GMT",
        "Thu, 01 Jul 1976 04:13:16 GMT",
        "Sat, 28 Aug 1976 07:46:57 GMT",
        "Mon, 25 Oct 1976 02:12:00 GMT",
        "Wed, 22 Dec 1976 01:25:50 GMT",
        "Thu, 17 Feb 1977 23:55:54 GMT",
        "Sun, 17 Apr 1977 02:03:50 GMT",
        "Mon, 13 Jun 1977 21:10:19 GMT",
        "Wed, 10 Aug 1977 16:13:58 GMT",
        "Fri, 07 Oct 1977 12:40:41 GMT",
        "Sun, 04 Dec 1977 09:11:19 GMT",
        "Tue, 31 Jan 1978 08:32:01 GMT",
        "Thu, 30 Mar 1978 08:03:52 GMT",
        "Sat, 27 May 1978 08:42:59 GMT",
        "Mon, 24 Jul 1978 09:24:05 GMT",
        "Wed, 20 Sep 1978 04:47:31 GMT",
        "Thu, 16 Nov 1978 22:53:15 GMT",
        "Sat, 13 Jan 1979 22:47:26 GMT",
        "Tue, 13 Mar 1979 00:22:31 GMT",
        "Wed, 09 May 1979 20:57:21 GMT",
        "Fri, 06 Jul 1979 16:16:57 GMT",
        "Sun, 02 Sep 1979 14:49:31 GMT",
        "Tue, 30 Oct 1979 08:38:39 GMT",
        "Thu, 27 Dec 1979 05:59:06 GMT",
        "Sat, 23 Feb 1980 03:41:39 GMT",
        "Mon, 21 Apr 1980 00:49:23 GMT",
        "Tue, 17 Jun 1980 23:07:45 GMT",
        "Thu, 14 Aug 1980 18:50:05 GMT",
        "Sat, 11 Oct 1980 13:54:38 GMT",
        "Mon, 08 Dec 1980 11:13:31 GMT",
        "Wed, 04 Feb 1981 06:37:47 GMT",
        "Fri, 03 Apr 1981 02:55:40 GMT",
        "Sun, 31 May 1981 00:58:29 GMT",
        "Mon, 27 Jul 1981 17:10:05 GMT",
        "Wed, 23 Sep 1981 12:48:40 GMT",
        "Fri, 20 Nov 1981 10:53:17 GMT",
        "Sun, 17 Jan 1982 08:27:54 GMT",
        "Tue, 16 Mar 1982 06:21:27 GMT",
        "Thu, 13 May 1982 06:19:05 GMT",
        "Sat, 10 Jul 1982 02:12:40 GMT",
        "Mon, 06 Sep 1982 00:58:53 GMT",
        "Tue, 02 Nov 1982 19:28:43 GMT",
        "Thu, 30 Dec 1982 18:52:57 GMT",
        "Sat, 26 Feb 1983 13:55:49 GMT",
        "Mon, 25 Apr 1983 12:50:00 GMT",
        "Wed, 22 Jun 1983 08:32:42 GMT",
        "Fri, 19 Aug 1983 09:29:30 GMT",
        "Sun, 16 Oct 1983 06:05:06 GMT",
        "Tue, 13 Dec 1983 01:18:44 GMT",
        "Wed, 08 Feb 1984 22:03:03 GMT",
        "Fri, 06 Apr 1984 20:47:55 GMT",
        "Sun, 03 Jun 1984 17:31:19 GMT",
        "Tue, 31 Jul 1984 10:43:09 GMT",
        "Thu, 27 Sep 1984 07:03:55 GMT",
        "Sat, 24 Nov 1984 03:18:57 GMT",
        "Mon, 21 Jan 1985 00:40:51 GMT",
        "Tue, 19 Mar 1985 21:02:18 GMT",
        "Thu, 16 May 1985 15:01:17 GMT",
        "Sat, 13 Jul 1985 08:02:25 GMT",
        "Mon, 09 Sep 1985 09:41:41 GMT",
        "Wed, 06 Nov 1985 08:38:51 GMT",
        "Fri, 03 Jan 1986 11:02:43 GMT",
        "Sun, 02 Mar 1986 07:58:58 GMT",
        "Tue, 29 Apr 1986 07:37:57 GMT",
        "Thu, 26 Jun 1986 04:19:53 GMT",
        "Sat, 23 Aug 1986 01:10:52 GMT",
        "Sun, 19 Oct 1986 20:56:52 GMT",
        "Tue, 16 Dec 1986 18:20:13 GMT",
        "Thu, 12 Feb 1987 14:32:33 GMT",
        "Sat, 11 Apr 1987 09:52:25 GMT",
        "Mon, 08 Jun 1987 08:45:00 GMT",
        "Wed, 05 Aug 1987 10:13:40 GMT",
        "Fri, 02 Oct 1987 06:18:55 GMT",
        "Sun, 29 Nov 1987 05:30:52 GMT",
        "Tue, 26 Jan 1988 01:28:18 GMT",
        "Wed, 23 Mar 1988 21:49:15 GMT",
        "Fri, 20 May 1988 18:32:06 GMT",
        "Sun, 17 Jul 1988 12:31:45 GMT",
        "Tue, 13 Sep 1988 09:45:56 GMT",
        "Thu, 10 Nov 1988 07:46:33 GMT",
        "Sat, 07 Jan 1989 01:18:39 GMT",
        "Sun, 05 Mar 1989 20:57:22 GMT",
        "Tue, 02 May 1989 19:12:02 GMT",
        "Thu, 29 Jun 1989 20:47:51 GMT",
        "Sat, 26 Aug 1989 21:14:58 GMT",
        "Mon, 23 Oct 1989 17:21:11 GMT",
        "Wed, 20 Dec 1989 11:02:05 GMT",
        "Fri, 16 Feb 1990 08:17:31 GMT",
        "Sun, 15 Apr 1990 05:46:19 GMT",
        "Tue, 12 Jun 1990 01:11:50 GMT",
        "Wed, 08 Aug 1990 17:36:04 GMT",
        "Fri, 05 Oct 1990 14:57:57 GMT",
        "Sun, 02 Dec 1990 09:37:25 GMT",
        "Tue, 29 Jan 1991 09:26:49 GMT",
        "Thu, 28 Mar 1991 03:15:27 GMT",
        "Sat, 25 May 1991 04:44:47 GMT",
        "Sun, 21 Jul 1991 22:17:03 GMT",
        "Tue, 17 Sep 1991 21:43:58 GMT",
        "Thu, 14 Nov 1991 20:49:44 GMT",
        "Sat, 11 Jan 1992 18:21:15 GMT",
        "Mon, 09 Mar 1992 18:15:06 GMT",
        "Wed, 06 May 1992 19:14:58 GMT",
        "Fri, 03 Jul 1992 15:59:01 GMT",
        "Sun, 30 Aug 1992 13:58:34 GMT",
        "Tue, 27 Oct 1992 09:12:11 GMT",
        "Thu, 24 Dec 1992 06:56:12 GMT",
        "Sat, 20 Feb 1993 01:25:55 GMT",
        "Sun, 18 Apr 1993 19:45:17 GMT",
        "Tue, 15 Jun 1993 18:56:41 GMT",
        "Thu, 12 Aug 1993 13:43:40 GMT",
        "Sat, 09 Oct 1993 12:59:51 GMT",
        "Mon, 06 Dec 1993 09:47:11 GMT",
        "Wed, 02 Feb 1994 09:15:24 GMT",
        "Fri, 01 Apr 1994 03:14:47 GMT",
        "Sun, 29 May 1994 00:14:58 GMT",
        "Mon, 25 Jul 1994 17:39:33 GMT",
        "Wed, 21 Sep 1994 11:05:01 GMT",
        "Fri, 18 Nov 1994 04:13:02 GMT",
        "Sun, 15 Jan 1995 04:09:11 GMT",
        "Tue, 14 Mar 1995 03:00:31 GMT",
        "Wed, 10 May 1995 23:26:21 GMT",
        "Fri, 07 Jul 1995 21:44:01 GMT",
        "Sun, 03 Sep 1995 17:57:13 GMT",
        "Tue, 31 Oct 1995 16:08:10 GMT",
        "Thu, 28 Dec 1995 18:01:14 GMT",
        "Sat, 24 Feb 1996 16:46:13 GMT",
        "Mon, 22 Apr 1996 20:07:01 GMT",
        "Wed, 19 Jun 1996 15:34:39 GMT",
        "Fri, 16 Aug 1996 11:23:32 GMT",
        "Sun, 13 Oct 1996 09:28:39 GMT",
        "Tue, 10 Dec 1996 05:45:06 GMT",
        "Thu, 06 Feb 1997 04:44:00 GMT",
        "Sat, 05 Apr 1997 01:59:18 GMT",
        "Sun, 01 Jun 1997 22:41:07 GMT",
        "Tue, 29 Jul 1997 17:22:53 GMT",
        "Thu, 25 Sep 1997 15:32:55 GMT",
        "Sat, 22 Nov 1997 09:13:42 GMT",
        "Sun, 18 Jan 1998 21:51:33 GMT",
        "Tue, 17 Mar 1998 19:36:05 GMT",
        "Thu, 14 May 1998 17:03:25 GMT",
        "Sat, 11 Jul 1998 16:49:03 GMT",
        "Mon, 07 Sep 1998 15:16:23 GMT",
        "Wed, 04 Nov 1998 09:54:22 GMT",
        "Fri, 01 Jan 1999 07:33:22 GMT",
        "Sun, 28 Feb 1999 07:11:52 GMT",
        "Tue, 27 Apr 1999 04:02:41 GMT",
        "Thu, 24 Jun 1999 03:51:39 GMT",
        "Fri, 20 Aug 1999 23:38:50 GMT",
        "Sun, 17 Oct 1999 21:53:29 GMT",
        "Tue, 14 Dec 1999 17:24:15 GMT",
        "Thu, 10 Feb 2000 17:42:23 GMT",
        "Sat, 08 Apr 2000 12:13:03 GMT",
        "Mon, 05 Jun 2000 10:14:17 GMT",
        "Wed, 02 Aug 2000 09:54:52 GMT",
        "Fri, 29 Sep 2000 04:54:34 GMT",
        "Sun, 26 Nov 2000 02:46:52 GMT",
        "Mon, 22 Jan 2001 23:21:42 GMT",
        "Wed, 21 Mar 2001 22:11:10 GMT",
        "Fri, 18 May 2001 17:05:53 GMT",
        "Sun, 15 Jul 2001 17:40:26 GMT",
        "Tue, 11 Sep 2001 09:14:26 GMT",
        "Thu, 08 Nov 2001 06:55:10 GMT",
        "Sat, 05 Jan 2002 06:54:58 GMT",
        "Mon, 04 Mar 2002 02:39:28 GMT",
        "Wed, 01 May 2002 01:30:02 GMT",
        "Thu, 27 Jun 2002 20:16:46 GMT",
        "Sat, 24 Aug 2002 14:50:38 GMT",
        "Mon, 21 Oct 2002 10:07:01 GMT",
        "Wed, 18 Dec 2002 10:08:59 GMT",
        "Fri, 14 Feb 2003 05:16:17 GMT",
        "Sun, 13 Apr 2003 02:47:11 GMT",
        "Mon, 09 Jun 2003 22:44:53 GMT",
        "Wed, 06 Aug 2003 15:42:21 GMT",
        "Fri, 03 Oct 2003 12:10:23 GMT",
        "Sun, 30 Nov 2003 12:18:22 GMT",
        "Tue, 27 Jan 2004 11:58:04 GMT",
        "Thu, 25 Mar 2004 07:05:47 GMT",
        "Fri, 21 May 2004 22:40:01 GMT",
        "Sun, 18 Jul 2004 21:24:26 GMT",
        "Tue, 14 Sep 2004 20:11:05 GMT",
        "Thu, 11 Nov 2004 20:52:56 GMT",
        "Sat, 08 Jan 2005 20:32:29 GMT",
        "Mon, 07 Mar 2005 21:55:14 GMT",
        "Wed, 04 May 2005 17:51:57 GMT",
        "Fri, 01 Jul 2005 13:38:23 GMT",
        "Sun, 28 Aug 2005 11:45:10 GMT",
        "Tue, 25 Oct 2005 06:46:52 GMT",
        "Thu, 22 Dec 2005 01:59:41 GMT",
        "Fri, 17 Feb 2006 20:36:08 GMT",
        "Sun, 16 Apr 2006 21:21:31 GMT",
        "Tue, 13 Jun 2006 18:08:02 GMT",
        "Thu, 10 Aug 2006 16:31:22 GMT",
        "Sat, 07 Oct 2006 12:45:04 GMT",
        "Mon, 04 Dec 2006 09:31:07 GMT",
        "Wed, 31 Jan 2007 06:16:42 GMT",
        "Fri, 30 Mar 2007 04:33:12 GMT",
        "Sat, 26 May 2007 22:18:35 GMT",
        "Mon, 23 Jul 2007 21:35:47 GMT",
        "Wed, 19 Sep 2007 18:11:37 GMT",
        "Fri, 16 Nov 2007 13:57:06 GMT",
        "Sun, 13 Jan 2008 08:35:38 GMT",
        "Tue, 11 Mar 2008 10:29:55 GMT",
        "Thu, 08 May 2008 02:52:57 GMT",
        "Fri, 04 Jul 2008 22:30:14 GMT",
        "Sun, 31 Aug 2008 19:54:47 GMT",
        "Tue, 28 Oct 2008 18:25:55 GMT",
        "Thu, 25 Dec 2008 14:13:17 GMT",
        "Sat, 21 Feb 2009 10:53:59 GMT",
        "Mon, 20 Apr 2009 06:20:05 GMT",
        "Wed, 17 Jun 2009 04:08:20 GMT",
        "Fri, 14 Aug 2009 04:29:41 GMT",
        "Sat, 10 Oct 2009 23:55:27 GMT",
        "Mon, 07 Dec 2009 19:41:24 GMT",
        "Wed, 03 Feb 2010 21:03:22 GMT",
        "Fri, 02 Apr 2010 17:46:01 GMT",
        "Sun, 30 May 2010 12:26:19 GMT",
        "Tue, 27 Jul 2010 08:46:38 GMT",
        "Thu, 23 Sep 2010 07:15:26 GMT",
        "Sat, 20 Nov 2010 01:29:15 GMT",
        "Sun, 16 Jan 2011 21:44:34 GMT",
        "Tue, 15 Mar 2011 14:39:47 GMT",
        "Thu, 12 May 2011 09:54:20 GMT",
        "Sat, 09 Jul 2011 09:18:23 GMT",
        "Mon, 05 Sep 2011 09:09:56 GMT",
        "Wed, 02 Nov 2011 04:04:18 GMT",
        "Thu, 29 Dec 2011 23:56:43 GMT",
        "Sat, 25 Feb 2012 18:04:59 GMT",
        "Mon, 23 Apr 2012 17:56:49 GMT",
        "Wed, 20 Jun 2012 14:41:07 GMT",
        "Fri, 17 Aug 2012 09:33:13 GMT",
        "Sun, 14 Oct 2012 07:48:40 GMT",
        "Tue, 11 Dec 2012 05:36:39 GMT",
        "Thu, 07 Feb 2013 01:17:41 GMT",
        "Fri, 05 Apr 2013 21:33:02 GMT",
        "Sun, 02 Jun 2013 20:04:08 GMT",
        "Tue, 30 Jul 2013 19:59:50 GMT",
        "Thu, 26 Sep 2013 18:40:08 GMT",
        "Sat, 23 Nov 2013 11:19:42 GMT",
        "Mon, 20 Jan 2014 08:49:22 GMT",
        "Wed, 19 Mar 2014 08:17:10 GMT",
        "Fri, 16 May 2014 00:46:10 GMT",
        "Sat, 12 Jul 2014 20:35:20 GMT",
        "Mon, 08 Sep 2014 15:37:39 GMT",
        "Wed, 05 Nov 2014 12:34:28 GMT",
        "Fri, 02 Jan 2015 10:13:35 GMT",
        "Sun, 01 Mar 2015 10:05:52 GMT",
        "Tue, 28 Apr 2015 06:48:05 GMT",
        "Thu, 25 Jun 2015 03:23:50 GMT",
        "Fri, 21 Aug 2015 23:03:54 GMT",
        "Sun, 18 Oct 2015 22:15:16 GMT",
        "Tue, 15 Dec 2015 18:41:28 GMT",
        "Thu, 11 Feb 2016 14:27:45 GMT",
        "Sat, 09 Apr 2016 12:30:53 GMT",
        "Mon, 06 Jun 2016 09:44:47 GMT",
        "Wed, 03 Aug 2016 14:44:25 GMT",
        "Fri, 30 Sep 2016 13:36:42 GMT",
        "Sun, 27 Nov 2016 08:46:09 GMT",
        "Tue, 24 Jan 2017 06:16:34 GMT",
        "Thu, 23 Mar 2017 07:17:18 GMT",
        "Sat, 20 May 2017 01:35:30 GMT",
        "Sun, 16 Jul 2017 23:24:50 GMT",
        "Wed, 13 Sep 2017 00:57:05 GMT",
        "Fri, 10 Nov 2017 00:31:44 GMT",
        "Sat, 06 Jan 2018 22:49:07 GMT",
        "Mon, 05 Mar 2018 17:22:30 GMT",
        "Wed, 02 May 2018 14:32:10 GMT",
        "Fri, 29 Jun 2018 07:36:20 GMT",
        "Sun, 26 Aug 2018 06:23:02 GMT",
        "Tue, 23 Oct 2018 02:10:52 GMT",
        "Wed, 19 Dec 2018 22:26:37 GMT",
        "Fri, 15 Feb 2019 16:34:22 GMT",
        "Sun, 14 Apr 2019 13:47:59 GMT",
        "Tue, 11 Jun 2019 08:13:26 GMT",
        "Wed, 07 Aug 2019 23:54:54 GMT",
        "Fri, 04 Oct 2019 20:31:43 GMT",
        "Sun, 01 Dec 2019 17:28:03 GMT",
        "Tue, 28 Jan 2020 10:18:31 GMT",
        "Thu, 26 Mar 2020 03:34:19 GMT",
        "Sat, 23 May 2020 04:13:08 GMT",
        "Mon, 20 Jul 2020 03:34:58 GMT",
        "Wed, 16 Sep 2020 02:38:51 GMT",
        "Fri, 13 Nov 2020 01:37:48 GMT",
        "Sat, 09 Jan 2021 22:31:16 GMT",
        "Mon, 08 Mar 2021 18:14:44 GMT",
        "Wed, 05 May 2021 15:03:16 GMT",
        "Fri, 02 Jul 2021 07:53:21 GMT",
        "Sun, 29 Aug 2021 03:00:26 GMT",
        "Tue, 26 Oct 2021 01:04:14 GMT",
        "Wed, 22 Dec 2021 22:37:37 GMT",
        "Fri, 18 Feb 2022 14:58:46 GMT",
        "Sun, 17 Apr 2022 09:14:25 GMT",
        "Tue, 14 Jun 2022 05:12:51 GMT",
        "Thu, 11 Aug 2022 01:22:26 GMT",
        "Fri, 07 Oct 2022 23:46:34 GMT",
        "Sun, 04 Dec 2022 19:52:15 GMT",
        "Tue, 31 Jan 2023 18:08:30 GMT",
        "Thu, 30 Mar 2023 16:07:49 GMT",
        "Sat, 27 May 2023 09:14:37 GMT",
        "Mon, 24 Jul 2023 07:14:21 GMT",
        "Wed, 20 Sep 2023 02:08:08 GMT",
        "Thu, 16 Nov 2023 21:32:13 GMT",
        "Sat, 13 Jan 2024 17:37:15 GMT",
        "Mon, 11 Mar 2024 16:24:42 GMT",
        "Wed, 08 May 2024 10:13:27 GMT",
        "Fri, 05 Jul 2024 04:50:41 GMT",
        "Sun, 01 Sep 2024 04:22:41 GMT",
        "Tue, 29 Oct 2024 01:05:21 GMT",
        "Wed, 25 Dec 2024 21:30:20 GMT",
        "Fri, 21 Feb 2025 16:10:23 GMT",
        "Sun, 20 Apr 2025 09:38:58 GMT",
        "Tue, 17 Jun 2025 02:11:55 GMT",
        "Wed, 13 Aug 2025 23:52:00 GMT",
        "Fri, 10 Oct 2025 20:59:47 GMT",
        "Sun, 07 Dec 2025 19:33:37 GMT",
        "Tue, 03 Feb 2026 18:19:15 GMT",
        "Thu, 02 Apr 2026 15:17:17 GMT",
        "Sat, 30 May 2026 15:30:44 GMT",
        "Mon, 27 Jul 2026 10:28:11 GMT",
        "Wed, 23 Sep 2026 09:13:56 GMT",
        "Fri, 20 Nov 2026 15:06:57 GMT",
        "Sun, 17 Jan 2027 13:20:41 GMT",
        "Tue, 16 Mar 2027 05:02:49 GMT",
        "Thu, 13 May 2027 00:33:44 GMT",
        "Fri, 09 Jul 2027 19:59:18 GMT",
        "Sun, 05 Sep 2027 16:48:30 GMT",
        "Tue, 02 Nov 2027 13:29:40 GMT",
        "Thu, 30 Dec 2027 13:55:46 GMT",
        "Sat, 26 Feb 2028 13:18:59 GMT",
        "Mon, 24 Apr 2028 09:05:53 GMT",
        "Wed, 21 Jun 2028 06:56:41 GMT",
        "Fri, 18 Aug 2028 02:04:36 GMT",
        "Sun, 15 Oct 2028 02:52:49 GMT",
        "Mon, 11 Dec 2028 19:14:28 GMT",
        "Wed, 07 Feb 2029 15:54:25 GMT",
        "Fri, 06 Apr 2029 10:12:17 GMT",
        "Sun, 03 Jun 2029 05:22:00 GMT",
        "Tue, 31 Jul 2029 03:59:01 GMT",
        "Thu, 27 Sep 2029 06:30:00 GMT",
        "Sat, 24 Nov 2029 03:15:59 GMT",
        "Sun, 20 Jan 2030 22:49:50 GMT",
        "Tue, 19 Mar 2030 20:09:20 GMT",
        "Thu, 16 May 2030 16:40:18 GMT",
        "Sat, 13 Jul 2030 12:11:05 GMT",
        "Mon, 09 Sep 2030 09:12:07 GMT",
        "Wed, 06 Nov 2030 05:43:22 GMT",
        "Fri, 03 Jan 2031 04:08:06 GMT",
        "Sun, 02 Mar 2031 00:38:52 GMT",
        "Mon, 28 Apr 2031 22:31:16 GMT",
        "Wed, 25 Jun 2031 18:01:14 GMT",
        "Fri, 22 Aug 2031 13:45:15 GMT",
        "Sun, 19 Oct 2031 11:07:52 GMT",
        "Tue, 16 Dec 2031 09:59:36 GMT",
        "Thu, 12 Feb 2032 05:35:57 GMT",
        "Sat, 10 Apr 2032 01:17:56 GMT",
        "Sun, 06 Jun 2032 21:59:21 GMT",
        "Tue, 03 Aug 2032 19:24:30 GMT",
        "Thu, 30 Sep 2032 14:45:42 GMT",
        "Sat, 27 Nov 2032 08:47:11 GMT",
        "Mon, 24 Jan 2033 09:35:51 GMT",
        "Wed, 23 Mar 2033 05:37:12 GMT",
        "Fri, 20 May 2033 02:22:42 GMT",
        "Sat, 16 Jul 2033 21:36:18 GMT",
        "Tue, 13 Sep 2033 01:31:53 GMT",
        "Wed, 09 Nov 2033 23:46:07 GMT",
        "Fri, 06 Jan 2034 17:01:19 GMT",
        "Sun, 05 Mar 2034 12:35:13 GMT",
        "Tue, 02 May 2034 12:39:38 GMT",
        "Thu, 29 Jun 2034 03:31:11 GMT",
        "Sat, 26 Aug 2034 01:43:08 GMT",
        "Mon, 23 Oct 2034 02:13:12 GMT",
        "Tue, 19 Dec 2034 21:06:29 GMT",
        "Thu, 15 Feb 2035 17:45:31 GMT",
        "Sat, 14 Apr 2035 12:02:04 GMT",
        "Mon, 11 Jun 2035 08:00:58 GMT",
        "Tue, 07 Aug 2035 23:24:31 GMT",
        "Thu, 04 Oct 2035 18:32:46 GMT",
        "Sat, 01 Dec 2035 16:27:45 GMT",
        "Mon, 28 Jan 2036 13:37:49 GMT",
        "Wed, 26 Mar 2036 11:53:07 GMT",
        "Fri, 23 May 2036 08:29:20 GMT",
        "Sun, 20 Jul 2036 06:34:43 GMT",
        "Tue, 16 Sep 2036 03:28:52 GMT",
        "Thu, 13 Nov 2036 00:27:46 GMT",
        "Fri, 09 Jan 2037 22:24:53 GMT",
        "Sun, 08 Mar 2037 20:32:46 GMT",
        "Tue, 05 May 2037 12:22:44 GMT",
        "Thu, 02 Jul 2037 08:21:01 GMT",
        "Sat, 29 Aug 2037 05:52:02 GMT",
        "Mon, 26 Oct 2037 00:07:04 GMT",
        "Tue, 22 Dec 2037 18:04:58 GMT",
        "Thu, 18 Feb 2038 12:36:02 GMT",
        "Sat, 17 Apr 2038 09:06:19 GMT",
        "Mon, 14 Jun 2038 07:36:43 GMT",
        "Wed, 11 Aug 2038 05:18:56 GMT",
        "Thu, 07 Oct 2038 23:02:34 GMT",
        "Sat, 04 Dec 2038 21:45:37 GMT",
        "Mon, 31 Jan 2039 17:13:46 GMT",
        "Wed, 30 Mar 2039 18:27:37 GMT",
        "Fri, 27 May 2039 13:26:45 GMT",
        "Sun, 24 Jul 2039 09:14:45 GMT",
        "Tue, 20 Sep 2039 02:06:50 GMT",
        "Thu, 17 Nov 2039 01:18:28 GMT",
        "Fri, 13 Jan 2040 20:55:12 GMT",
        "Sun, 11 Mar 2040 18:27:15 GMT",
        "Tue, 08 May 2040 14:37:48 GMT",
        "Thu, 05 Jul 2040 07:35:28 GMT",
        "Sat, 01 Sep 2040 04:27:23 GMT",
        "Mon, 29 Oct 2040 00:32:09 GMT",
        "Tue, 25 Dec 2040 22:52:46 GMT",
        "Thu, 21 Feb 2041 19:00:41 GMT",
        "Sat, 20 Apr 2041 17:39:23 GMT",
        "Mon, 17 Jun 2041 18:34:33 GMT",
        "Wed, 14 Aug 2041 14:12:48 GMT",
        "Fri, 11 Oct 2041 09:55:42 GMT",
        "Sun, 08 Dec 2041 05:18:50 GMT",
        "Tue, 04 Feb 2042 04:28:31 GMT",
        "Thu, 03 Apr 2042 03:04:24 GMT",
        "Fri, 30 May 2042 22:44:07 GMT",
        "Sun, 27 Jul 2042 23:39:58 GMT",
        "Tue, 23 Sep 2042 17:58:08 GMT",
        "Thu, 20 Nov 2042 18:29:58 GMT",
        "Sat, 17 Jan 2043 13:23:31 GMT",
        "Mon, 16 Mar 2043 09:39:17 GMT",
        "Wed, 13 May 2043 03:37:11 GMT",
        "Fri, 10 Jul 2043 01:51:35 GMT",
        "Sat, 05 Sep 2043 23:33:21 GMT",
        "Mon, 02 Nov 2043 22:20:18 GMT",
        "Wed, 30 Dec 2043 17:22:06 GMT",
        "Fri, 26 Feb 2044 15:16:10 GMT",
        "Sun, 24 Apr 2044 10:32:54 GMT",
        "Tue, 21 Jun 2044 07:44:15 GMT",
        "Thu, 18 Aug 2044 05:06:25 GMT",
        "Sat, 15 Oct 2044 01:46:58 GMT",
        "Sun, 11 Dec 2044 19:30:42 GMT",
        "Tue, 07 Feb 2045 18:59:34 GMT",
        "Thu, 06 Apr 2045 17:31:52 GMT",
        "Sat, 03 Jun 2045 11:55:12 GMT",
        "Mon, 31 Jul 2045 11:26:05 GMT",
        "Wed, 27 Sep 2045 03:44:18 GMT",
        "Fri, 24 Nov 2045 00:02:03 GMT",
        "Sat, 20 Jan 2046 22:43:51 GMT",
        "Mon, 19 Mar 2046 16:12:57 GMT",
        "Wed, 16 May 2046 08:40:27 GMT",
        "Fri, 13 Jul 2046 07:24:25 GMT",
        "Sun, 09 Sep 2046 03:06:25 GMT",
        "Tue, 06 Nov 2046 00:53:50 GMT",
        "Wed, 02 Jan 2047 19:17:10 GMT",
        "Fri, 01 Mar 2047 18:07:35 GMT",
        "Sun, 28 Apr 2047 16:00:31 GMT",
        "Tue, 25 Jun 2047 13:53:10 GMT",
        "Thu, 22 Aug 2047 10:14:32 GMT",
        "Sat, 19 Oct 2047 07:18:00 GMT",
        "Mon, 16 Dec 2047 02:32:47 GMT",
        "Tue, 11 Feb 2048 20:59:07 GMT",
        "Thu, 09 Apr 2048 21:13:13 GMT",
        "Sat, 06 Jun 2048 18:27:21 GMT",
        "Mon, 03 Aug 2048 17:08:44 GMT",
        "Wed, 30 Sep 2048 15:02:04 GMT",
        "Fri, 27 Nov 2048 08:35:42 GMT",
        "Sun, 24 Jan 2049 04:20:00 GMT",
        "Tue, 23 Mar 2049 02:40:33 GMT"
    );
}