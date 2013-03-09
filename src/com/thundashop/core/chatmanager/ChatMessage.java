/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.chatmanager;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ktonder
 */
public class ChatMessage implements Serializable, Comparable<ChatMessage> {
    public boolean operator = false;
    public String message;
    public Date rowCreatedDate = new Date();
    
    @Override
    public int compareTo(ChatMessage o) {
        if (o.rowCreatedDate.after(rowCreatedDate))
            return -1;
     
        if (o.rowCreatedDate.before(rowCreatedDate))
            return 1;
        
        return 0;
    }
}
