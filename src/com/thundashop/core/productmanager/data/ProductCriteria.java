/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.productmanager.data;

import com.thundashop.core.common.DataCommon;
import java.util.ArrayList;

/**
 *
 * @author ktonder
 */
public class ProductCriteria extends DataCommon {
    public ArrayList<String> parentPageIds = new ArrayList();
    public ArrayList<String> pageIds = new ArrayList();
    public ArrayList<String> ids = new ArrayList();
    public String search = "";
}
