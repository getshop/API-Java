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
public class Day implements Serializable {
    public List<Entry> entries = new ArrayList();
    public int day;
    
    public Day() {
        this.day = day;
    }

    public Day(Day day) {
        this.day = day.day;
        for (Entry entry : day.entries) {
            this.entries.add(new Entry(entry));
        }
    }

    public void add(Entry entry) {
        if (entry == null)
            throw new NullPointerException("Can not have null entries added to a day");
        
        Entry oldEntry = null;
        for (Entry entryMem : entries) {
            if (entryMem.entryId.equals(entry.entryId)) {
                oldEntry = entryMem;
                entry.attendees = oldEntry.attendees;
            }
        }
        
        if (oldEntry != null)
            entries.remove(oldEntry);
        
        entries.add(entry);
    }

    public List<Entry> getEntries() {
        return entries;
    }
    
}
