package Nyansa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateParser {
    public static String getReportDate(String timeStamp) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return dateFormat.format(new Date(Long.parseLong(timeStamp)*1000)).concat(" GMT");
    }
}
