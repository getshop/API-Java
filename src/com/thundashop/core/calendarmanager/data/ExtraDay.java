/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.calendarmanager.data;

import java.io.Serializable;

/**
 *
 * @author ktonder
 */
public class ExtraDay implements Serializable, Comparable<ExtraDay>  {
    public int day;
    public int month;
    public int year;
    public String starttime;
    public String stoptime;

    @Override
    public int compareTo(ExtraDay o) {
        if (o.year > year)
            return -1;
        
        if (o.year == year && o.month > month)
            return -1;
        
        if (o.year == year && o.month == month && o.day > day)
            return -1;
        
        if (o.year == year && o.month == month && o.day == day)
            return 0;
        
        return 1;
    }
}
