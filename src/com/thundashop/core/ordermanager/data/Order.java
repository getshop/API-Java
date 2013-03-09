/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.ordermanager.data;

import com.thundashop.core.cartmanager.data.Cart;
import com.thundashop.core.common.DataCommon;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ktonder
 */
public class Order extends DataCommon implements Comparable<Order> {
    public String paymentType;
    public Shipping shipping;
    
    public static class Status  {
        public static int CREATED = 1;
        public static int WAITING_FOR_PAYMENT = 2;
        public static int PAYMENT_FAILED = 3;
        public static int COMPLETED = 4;
        public static int CANCELED = 5;
    }
    
    public Date createdDate;
    
    /**
     * The users id for whom placed the order
     * if order is created without user been logged in, this
     * will be empty
     */
    public String userId;
    
    public int status;
    public Cart cart;
    
    public String getDateCreated() {
        if (createdDate == null) {
            return "";
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        return sdf.format(createdDate);
    }
    
    public void setStatusCreated() {
        status = Status.CREATED;
    }
    
    public void setStatusPaymentFailed() {
        status = Status.PAYMENT_FAILED;
    }
    
    public void setStatusCompleted() {
        status = Status.COMPLETED;
    }
    
    public void setStatusCanceled() {
        status = Status.CANCELED;
    }
    
    @Override
    public int compareTo(Order o) {
        return createdDate.compareTo(o.createdDate);
    }
} 