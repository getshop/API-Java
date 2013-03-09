/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.chatmanager;

import com.thundashop.core.common.DataCommon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ktonder
 */
public class Chatter extends DataCommon {
    public Date lastActive = new Date();
    public boolean closed = false;
    public String sessionId;
    public List<ChatMessage> messages = new ArrayList();
    public String username = "";
}
