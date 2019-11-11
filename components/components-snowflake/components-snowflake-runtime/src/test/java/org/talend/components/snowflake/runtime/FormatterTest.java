// ============================================================================
//
// Copyright (C) 2006-2018 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.components.snowflake.runtime;

import org.junit.Assert;
import org.junit.Test;

public class FormatterTest {

    @Test
    public void testFormatter4SafeThread() {
        final Formatter f1 = new Formatter();
        new Thread(new Runnable() {

            @Override
            public void run() {
                Formatter f2 = new Formatter();
                compare(f1,f2);
            }

        }).start();
    }

    public void compare(Formatter f1, Formatter f2) {
        Assert.assertNotEquals(f1.getDateFormatter(), f2.getDateFormatter());
        Assert.assertNotEquals(f1.getTimeFormatter(), f2.getTimeFormatter());
        Assert.assertNotEquals(f1.getTimestampFormatter(), f2.getTimestampFormatter());
    }

    @Test
    public void testFormatDateFromInteger() {
        Formatter formatter = new Formatter();

        // Sydney daylight saving time ended 2017-10-01
        Assert.assertEquals("2017-09-30", formatter.formatDate(17439));
        Assert.assertEquals("2017-10-01", formatter.formatDate(17440));

        // Seoul daylight saving time started 1988-05-08
        Assert.assertEquals("1988-05-07", formatter.formatDate(6701));
        Assert.assertEquals("1988-05-08", formatter.formatDate(6702));
    }
}
