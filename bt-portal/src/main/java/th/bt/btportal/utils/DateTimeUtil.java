package th.bt.btportal.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {
    public static Date dateTime() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);
        String hostdate=dateFormat.format(date);
        return string2Date(hostdate);
    }
    public static Date string2Date(String Date) {
        Date inActiveDate = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss",Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            inActiveDate = dateFormat.parse(Date);
            System.out.println(inActiveDate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return inActiveDate;
    }
}
