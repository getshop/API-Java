/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.common;

/**
 *
 * @author hjemme
 */
public class ErrorException extends Throwable {
    public String additionalInformation;
    public int code;
    
    public ErrorException(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return String.valueOf(code);
    }
 
}
