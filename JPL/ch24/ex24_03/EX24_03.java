package ch24.ex24_03;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class EX24_03 {

    public static void main(String[] args) {

        final String str = "1970/1/1 00:00:00";

        try {
            Date date = parseDate(str);

            Locale[] locales = Locale.getAvailableLocales();
            for (Locale locale : locales) {
                System.out.println("--- " + locale + " ---");
                showDate(date, locale);
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static Date parseDate(String str) throws ParseException {
        DateFormat format = DateFormat.getDateInstance();
        return format.parse(str);
    }

    public static void showDate(Date date, Locale locale) {

        {
            Format fmt = DateFormat.getDateInstance(DateFormat.SHORT, locale);
            System.out.println(fmt.format(date));
        }

        {
            Format fmt = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            System.out.println(fmt.format(date));
        }

        {
            Format fmt = DateFormat.getDateInstance(DateFormat.LONG, locale);
            System.out.println(fmt.format(date));
        }

        {
            Format fmt = DateFormat.getDateInstance(DateFormat.FULL, locale);
            System.out.println(fmt.format(date));
        }

    }

}
