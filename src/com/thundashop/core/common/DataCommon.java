/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.common;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.PostLoad;
import com.thundashop.core.productmanager.data.Product;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Date;

/**
 *
 * @author hjemme
 */

@Entity("Credentials")
public class DataCommon implements Serializable {
    @Id 
    public String id = "";
    public String storeId = "";
    public Date deleted = null;
    public String className = getClass().getName();
    public Date rowCreatedDate;

    private void checkAnnotations(Field field, boolean Administrator) throws IllegalArgumentException, IllegalAccessException {
        Object emptyObject = new Product();
        
        for (Annotation ann : field.getDeclaredAnnotations()) {
            if (ann instanceof Administrator) {
                field.set(this, field.get(emptyObject));
            }

            if (Administrator) continue;
            
            if (ann instanceof Editor) {
                field.set(this, field.get(emptyObject));
            }
        }

    }

    public void updatePermissionsCustomer() throws IllegalArgumentException, IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()) {
            checkAnnotations(field, false);
        }
    }
    
    public void updatePermissionsEditor() throws IllegalArgumentException, IllegalAccessException {
        for (Field field : this.getClass().getDeclaredFields()) {
            checkAnnotations(field, true);
        }
    }
    
    public void onSaveValidate() throws ErrorException  {
    }
    
    @PostLoad
    public void postLoad() {
        if (rowCreatedDate == null)
            rowCreatedDate = new Date(0);
    }
}