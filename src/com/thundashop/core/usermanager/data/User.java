/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.usermanager.data;

import com.thundashop.core.common.DataCommon;
import com.thundashop.core.common.ErrorException;
import java.util.Date;

/**
 *
 * @author hjemme
 */

public class User extends DataCommon  {
    public int resetCode;

    public static class Type {
        public static int ADMINISTRATOR = 100;
        public static int EDITOR = 50;
        public static int CUSTOMER = 10;
    }
    
    public Address address;
    public String fullName = "";
    public String emailAddress = "";
    
    public String password = "";
    public String username = "";
    
    public int type = 0;
    
    public int loggedInCounter = 0;
    
    public Date lastLoggedIn;
    public Date expireDate;
    
    public String birthDay;
    
    public String companyName;
    
    public String cellPhone;
    
    public String key;

    public void ValidateUserFields() throws ErrorException {
        if (fullName.equals("")) {
            throw new ErrorException(2);
        }
        
        if (emailAddress.equals("")) {
            throw new ErrorException(4);
        }
    }
    
    public boolean isAdministrator() {
        return (type == User.Type.ADMINISTRATOR);
    }
    
    public boolean isEditor() {
        return (type == User.Type.EDITOR);
    }
    
    public boolean isCustomer() {
        return (type == User.Type.CUSTOMER);
    }
    
    public boolean hasKey(String key) {
        if(this.key != null && this.key.equals(key)) {
            return true;
        }
        
        return false;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
}
