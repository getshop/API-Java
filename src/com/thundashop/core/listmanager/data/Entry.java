/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.listmanager.data;

import java.io.Serializable;
import java.util.List;

/**
 * @author boggi
 * @param navigateByPages
 */
public class Entry implements Serializable {
    public boolean navigateByPages = true;
    public String name;
    public String parentId;
    public String pageId;
    public String imageId;
    public String hardLink;
    public int userLevel;
    public String id;
    public String productId;
    
    //Appended when fetching the list.
    public List<Entry> subentries;
}
