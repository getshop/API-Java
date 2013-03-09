/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.productmanager.data;

import java.io.Serializable;

/**
 *
 * @author boggi
 */
public class ProductImage implements Serializable {

    static class Type {
        static int MAIN = 0;
        static int ADDITIONAL = 1;
    }
    public int type;
    public String name;
    public String fileId;
    public String imageDescription;
}
