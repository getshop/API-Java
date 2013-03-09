/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.calendarmanager.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ktonder
 */
public class Entry implements Serializable, Comparable<Entry> {
    public List<String> attendees = new ArrayList();
    public List<ExtraDay> otherDays = new ArrayList();
    
    public int maxAttendees;
    
    public boolean availableForBooking = true;
    public boolean isOriginal = true;
    
    public String description;
    public String starttime;
    public String location;
    public String stoptime;
    public String entryId;
    public String userId;
    public String title;
    public String color;
    
    public int year;
    public int month;
    public int day;

    public Entry() {
    }
    
    public Entry(Entry entry) {
        this.maxAttendees = entry.maxAttendees;
        this.description = entry.description;
        this.attendees = entry.attendees;
        this.otherDays = entry.otherDays;
        this.starttime = entry.starttime;
        this.stoptime = entry.stoptime;
        this.location = entry.location;
        this.entryId = entry.entryId;
        this.userId = entry.userId;
        this.title = entry.title;
        this.color = entry.color;
        this.year = entry.year;
        this.month = entry.month;
        this.day = entry.day;
    }

    @Override
    public int compareTo(Entry o) {
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
