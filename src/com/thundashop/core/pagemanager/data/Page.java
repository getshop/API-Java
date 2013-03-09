/**
 * This class is a part of the thundashop project.
 * 
 * All rights reserved 
 *
 **/
package com.thundashop.core.pagemanager.data;

import com.thundashop.core.common.AppConfiguration;
import com.thundashop.core.common.DataCommon;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ktonder
 */
public class Page extends DataCommon implements Cloneable {

    public void clear() {
        for (PageArea pageArea : pageAreas.values()) {
            pageArea.clear();
        }
    }

    public void moveApplicationUp(String appid) {
        sortApplications();
        for (PageArea pageArea : pageAreas.values()) {
            pageArea.moveApplicationUp(appid);
        }
    }

    public void moveApplicationDown(String appid) {
        sortApplications();
        for (PageArea pageArea : pageAreas.values()) {
            pageArea.moveApplicationDown(appid);
        }
    }
    
    public static class DefaultPages {
        public static String OrderOverviewPageId = "orderoverview";
        public static String CartPage = "cart";
        public static String Home = "home";
        public static String CheckOut = "checkout";
        public static String MyAccount = "myaccount";
        public static String Users = "users";
        public static String Settings = "settings";
        public static String Domain = "domain";
    }

    public void addAllPageAreas() {
        PageArea middle = new PageArea(this);
        PageArea bottom = new PageArea(this);
        PageArea right = new PageArea(this);
        PageArea left = new PageArea(this);
        PageArea top = new PageArea(this);

        middle.type = PageArea.Type.MIDDLE;
        bottom.type = PageArea.Type.BOTTOM;
        right.type = PageArea.Type.RIGHT;
        left.type = PageArea.Type.LEFT;
        top.type = PageArea.Type.TOP;

        this.pageAreas = new HashMap<String, PageArea>();
        this.pageAreas.put(top.type, top);
        this.pageAreas.put(bottom.type, bottom);
        this.pageAreas.put(left.type, left);
        this.pageAreas.put(middle.type, middle);
        this.pageAreas.put(right.type, right);
    }
    
    public static class PageType {
        public static int HeaderFooterLeftMiddleRight = 1;
        public static int HeaderLeftMiddleFooter = 2;
        public static int HeaderRightMiddleFooter = 3;
        public static int HeaderMiddleFooter = 4;
    }
    
    public Page parent;
    public int type;
    public int userLevel = 0;
    public HashMap<String, PageArea> pageAreas = new HashMap<String, PageArea>();
    
    public void populateApplications(Map<String, AppConfiguration> applications, boolean onlyExtraApplications) {
        for (PageArea pageArea : pageAreas.values()) {
            pageArea.populateApplications(applications, onlyExtraApplications);
        }
    }

    public HashMap<String, AppConfiguration> getApplications() {
        HashMap<String, AppConfiguration> applications = new HashMap();
        for (PageArea pageArea : pageAreas.values()) {
            applications.putAll(pageArea.applications());
        }
        return applications;
    }
    
    public void sortApplications() {
        for (PageArea pageArea : pageAreas.values()) 
            pageArea.sortApplications();
    }
}
