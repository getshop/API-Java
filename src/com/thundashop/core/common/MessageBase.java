/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.common;

import java.io.Serializable;

/**
 *
 * @author hjemme
 */
public class MessageBase implements Serializable {
    public String sessionId = "";
    public String guid = "";
    public AppConfiguration conf;
    public Class sentFrom;
}
