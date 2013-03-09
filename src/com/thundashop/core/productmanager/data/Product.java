/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thundashop.core.productmanager.data;

import com.google.code.morphia.annotations.Transient;
import com.thundashop.core.common.Administrator;
import com.thundashop.core.common.DataCommon;
import com.thundashop.core.common.Editor;
import com.thundashop.core.common.ErrorException;
import com.thundashop.core.pagemanager.data.Page;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ktonder
 */
public class Product extends DataCommon {
    public Map<String, ProductImage> images = new HashMap<String, ProductImage>();    
    public String description;
    public String shortDescription;
    public double price;
    public String name;
    public int stockQuantity;
    
    @Transient
    public Page page;
    public String pageId;
    
    /**
     * Should always be in gram.
     */
    public int weight;
    
    @Editor
    public String supplier;
    
    @Administrator
    public double cost;
    
    //Inidicated if nessesary appliations has been added in simple mode.
    public boolean simpleAppsAdded;
    
    /**
     * This should always be in percents.
     */
    @Editor
    private double taxes;

    public void addImage(String fileId, String description) {
        ProductImage productImage = new ProductImage();
        productImage.name = "";
        productImage.imageDescription = description;
        productImage.type = (images.isEmpty()) ? ProductImage.Type.MAIN : ProductImage.Type.ADDITIONAL;
        productImage.fileId = fileId;
        images.put(fileId, productImage);
    }
    
    public void setMainImage(String fileId) {
        removeAllMainImages();
        
        ProductImage productImage = images.get(fileId);
        if (productImage == null) {
            addImage(fileId, "");
            productImage = images.get(fileId);
        }
        
        productImage.type = ProductImage.Type.MAIN;
    }
    
    private void removeAllMainImages() {
        for (ProductImage image : images.values()) {
            if (image.type == ProductImage.Type.MAIN)
                image.type = ProductImage.Type.ADDITIONAL;
        }
    }
    
    public ProductImage getMainImage() {
        for (ProductImage productImage : images.values()) {
            if (productImage.type == ProductImage.Type.MAIN)
                return productImage;
        }
        
        return null;
    }
    
    public List<ProductImage> getAdditionalImages() {
        List<ProductImage> retimages = new ArrayList<ProductImage>();
        for (ProductImage productImage : images.values()) {
            if (productImage.type == ProductImage.Type.ADDITIONAL)
                retimages.add(productImage);
        }
        
        return retimages;
    }
    
    public void removeImage(String fileId) {
        if (images == null) {
            return;
        }
        
        images.remove(fileId);
        
        if (images.values().iterator().hasNext()) {
            if (images.values().iterator().next() != null)
                images.values().iterator().next().type = ProductImage.Type.MAIN;
        }
    }
    
    @Override
    public int hashCode() {
        int h = 0;
        int len = id.length();
        for (int i = 0; i < len; i++) {
            h = 31 * h + id.charAt(i);
        }
        return h;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj.hashCode() == obj.hashCode());
    }
    
    @Override
    public String toString() {
        return id;
    }

    @Override
    public void onSaveValidate() throws ErrorException {
        int mainImageCount = 0;
        for (ProductImage img : images.values()) {
            if (img.type == ProductImage.Type.MAIN)
                mainImageCount++;
        }
        
        if (mainImageCount == 0 && images.size() > 0)
            throw new ErrorException(1014);
        
        if (mainImageCount > 1)
            throw new ErrorException(1013);
    }

    public boolean check(ProductCriteria searchCriteria) {
        if (id != null && searchCriteria.ids.contains(id))
            return true;
        
        if (page != null && page.id != null && searchCriteria.pageIds.contains(page.id))
            return true;
        
        if (searchCriteria.search != null 
                && !searchCriteria.search.equals("") 
                && name.toLowerCase().matches("(.*)"+searchCriteria.search.toLowerCase()+"(.*)"))
            return true;
        
        if (page != null && page.parent != null && searchCriteria.parentPageIds.contains(page.parent.id))
            return true;
        
        return false;
    }
    
}
