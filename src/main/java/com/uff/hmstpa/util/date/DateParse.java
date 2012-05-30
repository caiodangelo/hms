/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.hmstpa.util.date;

import com.uff.hmstpa.util.mediator.impl.MediatorImpl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.joda.time.DateTime;
import org.springframework.format.datetime.DateFormatter;

public class DateParse {

    public static Date parseStringDate(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            return df.parse(time);
        } catch (ParseException ex) {
            try {
                df = new SimpleDateFormat("dd-MM-aaaa hh:mm");
                return df.parse(time);
            } catch (ParseException ex2) {
                Logger.getLogger(MediatorImpl.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public static String parseDateToString(DateTime time) {
        DateFormatter df = new DateFormatter("yyyy-mm-dd hh:mm");
        return df.print(time.toDate(), Locale.getDefault());
    }
}
