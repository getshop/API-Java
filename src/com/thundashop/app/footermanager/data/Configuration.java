/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.app.footermanager.data;

import com.thundashop.core.common.DataCommon;
import com.thundashop.core.listmanager.data.Entry;
import java.util.List;
import java.util.Map;

/**
 *
 * @author boggi
 */
public class Configuration extends DataCommon {
    /**
     * A map defined by the column number and a boolean.
     * Example: column 0 : isText.get(0) integer;
     * 0 = text
     * 1 = list
     */
    public Map<Integer, Integer> columnType;
    
    /**
     * A unique id for each column.
     */
    public Map<Integer, String> columnIds;
    
    public int numberOfColumns = 1;
}
