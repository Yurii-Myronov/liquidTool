package com.liquidtool.test.platform.base;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtilities extends BaseTest {

    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyy HH:mm:ss");
    Date date = new Date();
    String date1 = dateFormat.format(date);

    // STATIC SLEEP
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
