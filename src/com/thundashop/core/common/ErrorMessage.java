/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.common;

import java.io.Serializable;

/**
 *
 * @author ktonder
 */
public class ErrorMessage implements Serializable {
    public String additionalInformation;
    public int errorCode;
    
    public ErrorMessage(ErrorException execption) {
        errorCode = execption.code;
        additionalInformation = execption.additionalInformation;
    }
}
