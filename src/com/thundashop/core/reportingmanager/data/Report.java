package com.thundashop.core.reportingmanager.data;

import com.thundashop.core.common.DataCommon;
import java.util.Date;

/**
 *
 * @author boggi
 */
public class Report extends DataCommon {
    public Date timestamp;
    public boolean changed = false;
    
    public int productsAccess = 0;
    public int usersLoggedOn = 0;
    public int pagesAccessed = 0;
    public int orderCount = 0;
    public int userCreated = 0;

    public void increasePageAccess() {
        pagesAccessed++;
        changed = true;
    }
    

    public void incrementProductAccess() {
        productsAccess++;
        changed = true;
    }

    public void incrementUserLoggedIn() {
        usersLoggedOn++;
        changed = true;
    }

    public void incrementOrderCount() {
        orderCount++;
        changed = true;
    }
    
    public void increaseUserCreated() {
        changed =true;
        userCreated++;
    }

    public void append(Report report) {
        productsAccess += report.productsAccess;
        usersLoggedOn += report.usersLoggedOn;
        pagesAccessed += report.pagesAccessed;
        orderCount += report.orderCount;
        userCreated += report.userCreated;
    }
}
