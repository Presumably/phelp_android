package ussdmaster.divum.phelp.ussd;

import android.net.Uri;

/**
 * Created by Marcelo on 04-09-2015.
 */
public class UssdUtils {


    public static Uri ussdToCallableUri(String ussd) {

        String uriString = "";

        if (!ussd.startsWith("tel:"))
            uriString += "tel:";

        for (char c : ussd.toCharArray()) {

            if (c == '#')
                uriString += Uri.encode("#");
            else
                uriString += c;
        }

        return Uri.parse(uriString);
    }
}
