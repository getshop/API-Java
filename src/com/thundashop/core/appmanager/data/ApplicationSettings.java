package com.thundashop.core.appmanager.data;

import com.thundashop.core.common.DataCommon;
import java.util.Comparator;
import java.util.List;

public class ApplicationSettings extends DataCommon implements Comparator<ApplicationSettings> {
    public String appName;
    public String description;
    public List<String> allowedAreas;
    public boolean isSingleton;
    public boolean renderStandalone;
    public boolean isPublic;
    public Double price;
    public String userId;
    public String type;
    public String ownerStoreId;
    public String clonedFrom;
    
    @Override
    public int compare(ApplicationSettings o1, ApplicationSettings o2) {
        return o1.appName.compareTo(o2.appName);
    }

}
