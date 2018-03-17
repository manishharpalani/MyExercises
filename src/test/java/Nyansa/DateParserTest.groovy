package Nyansa

import spock.lang.Specification

import java.util.concurrent.TimeUnit

class DateParserTest extends Specification {
    String input = "1407564301|www.nba.com\n" +
            "1407478021|www.facebook.com\n" +
            "1407478022|www.facebook.com\n" +
            "1407481200|news.ycombinator.com\n" +
            "1407478028|www.google.com\n" +
            "1407564301|sports.yahoo.com\n" +
            "1407564300|www.cnn.com\n" +
            "1407564300|www.nba.com\n" +
            "1407564300|www.nba.com\n" +
            "1407564301|sports.yahoo.com\n" +
            "1407478022|www.google.com\n" +
            "1407648022|www.twitter.com"
        /*
        Output

        08/08/2014 GMT
        www.facebook.com 2
        www.google.com 2
        news.ycombinator.com 1
        08/09/2014 GMT
        www.nba.com 3
        sports.yahoo.com 2
        www.cnn.com 1
        08/10/2014 GMT
        www.twitter.com 1
         */

    def "test getReportDate near midnight"() {
        given:
        String dateEpochStart = "01/01/1970 GMT"
        String dayAfterEpochStart = "01/02/1970 GMT"

        long timeStamp = 0
        expect:
        // start of epoch
        assertReportDate(timeStamp, dateEpochStart)

        // before midnight
        assertReportDate(TimeUnit.DAYS.toSeconds(1) - 1, dateEpochStart)

        // at midnight
        assertReportDate(TimeUnit.DAYS.toSeconds(1), dayAfterEpochStart)
    }

    private assertReportDate(long timeStamp, String dateEpochStart) {
        assertReportDate(String.valueOf(timeStamp), dateEpochStart)
    }


    def "test getReportDate matches sample data"() {
        given: "dates in sample data"
        String aug8 = "08/08/2014 GMT"
        String aug9 = "08/09/2014 GMT"
        String aug10 = "08/10/2014 GMT"
        List<String> reportDates = Arrays.asList(aug9, aug8, aug8, aug8, aug8, aug9, aug9, aug9, aug9, aug9, aug8, aug10);

        expect: "getReportDate returns expected report date"
        String[] lines = input.split();

        for (int ii = 0; ii < lines.size(); ++ii) {
            assertReportDate(lines[ii], reportDates.get(ii))
        }
    }

    private assertReportDate(String line, String dateStr) {
        String timeStamp = line.split("\\|")[0];
        DateParser.getReportDate(timeStamp) == dateStr
    }
}
