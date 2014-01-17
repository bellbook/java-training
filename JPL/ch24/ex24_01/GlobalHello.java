package ch24.ex24_01;

import java.util.Locale;
import java.util.ResourceBundle;

public class GlobalHello {

    public static void main(String[] args) {

        // default
        {
            ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes");
            System.out.println(res.getString(GlobalRes.HELLO));
            System.out.println(res.getString(GlobalRes.GOODBYE));
        }

        // en
        {
            Locale locale = new Locale("en");
            ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locale);
            System.out.println(res.getString(GlobalRes.HELLO));
            System.out.println(res.getString(GlobalRes.GOODBYE));
        }

        // en_AU
        {
            Locale locale = new Locale("en", "AU");
            ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locale);
            System.out.println(res.getString(GlobalRes.HELLO));
            System.out.println(res.getString(GlobalRes.GOODBYE));
        }

        // ja
        {
            Locale locale = new Locale("ja");
            ResourceBundle res = ResourceBundle.getBundle("ch24.ex24_01.GlobalRes", locale);
            System.out.println(res.getString(GlobalRes.HELLO));
            System.out.println(res.getString(GlobalRes.GOODBYE));
        }

    }

}
