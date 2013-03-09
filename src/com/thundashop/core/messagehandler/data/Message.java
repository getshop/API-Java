/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.messagehandler.data;

import com.thundashop.core.common.DataCommon;
import java.util.Date;

/**
 *
 * @author ktonder
 */
public class Message extends DataCommon {
    public static class Type {
        public static String MAIL = "mail";
        public static String SMS = "sms";
    }
    
    public Date sentDate = new Date();
    public String to;
    public String from;
    public String content;
    
    public String toName;
    public String title;
    public String fromName;
    public String type;
    
    public Message() {
    
    }
    
}
