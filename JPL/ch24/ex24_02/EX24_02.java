package ch24.ex24_02;

import java.util.Currency;
import java.util.Locale;

public class EX24_02 {

    public static void main(String[] args) {

        for (Country country : Country.values())
            System.out.println(country.name() + "\t: "
                    + Currency.getInstance(country.getLocale()).getSymbol());

    }

    private enum Country {

        JAPAN (Locale.JAPAN),
        CHINA (Locale.CHINA),
        UK (Locale.UK),
        FRANCE (Locale.FRANCE),
        GERMANY (Locale.GERMANY),
        ITALY (Locale.ITALY),
        ;

        private Locale locale;

        private Country(Locale locale) {
            this.locale = locale;
        }

        public Locale getLocale() {
            return locale;
        }
    }

}
