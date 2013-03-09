/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.cartmanager.data;

import com.thundashop.core.common.DataCommon;
import com.thundashop.core.productmanager.data.Product;
import com.thundashop.core.usermanager.data.Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author ktonder
 */
public class Cart extends DataCommon {
    public Address address;
    public HashMap<String, Product> products = new HashMap<String, Product>();
    public HashMap<String, Integer> counter = new HashMap<String, Integer>();    
    
    public double getTotal() {
        double price = 0;
        
        for (Product product : products.values()) 
            price += product.price * getProductCount(product);

        return price;
    }
    
    public void addProduct(Product product) {
        products.put(product.id, product);
        int count = getProductCount(product);
        counter.put(product.id, ++count);
    }
    
    public List<Product> getProductList() {
        return new ArrayList<Product>(products.values());
    }

    public Product getProductById(String productId) {
        return products.get(productId);
    }
    
    public void removeProduct(String productId) {
        Product product = getProductById(productId);
        if (product != null)
            products.remove(product);
    }

    public int getProductCount(Product product) {
        return (counter.get(product.id) != null) ? counter.get(product.id) : 0;
    }

    public void setProductCount(String productId, int count) {
        counter.put(productId, count);
    }

    public HashMap<Product, Integer> getProducts() {
        HashMap<Product, Integer> returns = new HashMap<Product, Integer>();
        for (Product product : products.values()) {
            returns.put(product, getProductCount(product));
        }
        return returns;
    }
    
}
