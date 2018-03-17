package Nyansa

import spock.lang.Specification


class ReportByDateTest extends Specification {
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


    def "read input file"() {
        ReportByDate report = new ReportByDate("./resources/input.txt")
        expect:
        report.process();
        report.getNumReportDays() == 3
    }
}
