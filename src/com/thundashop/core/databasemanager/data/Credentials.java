/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.databasemanager.data;

import java.io.Serializable;

/**
 *
 * @author ktonder
 */
public class Credentials implements Serializable {
    private Class managerClass;
    public String manangerName;
    public String password;
    public String storeid;

    
    public Credentials(Class managerClass) {
        this.managerClass = managerClass;
    }
    
    public Class getManager() {
        return managerClass;
    }
}
