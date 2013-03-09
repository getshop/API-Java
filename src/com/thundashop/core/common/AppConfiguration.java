package com.thundashop.core.common;

import com.thundashop.core.appmanager.data.ApplicationSettings;
import java.util.HashMap;

public class AppConfiguration extends DataCommon {
    public HashMap<String, Setting> settings = new HashMap<>();
    public int sticky;
    public int sequence;
    public String appName;
    public int inheritate;
    public String originalPageId;
    public String appSettingsId;

    public AppConfiguration secureClone() {
        AppConfiguration appConfig = new AppConfiguration();
        appConfig.sticky = sticky;
        appConfig.sequence = sequence;
        appConfig.appName = appName;
        appConfig.inheritate = inheritate;
        appConfig.originalPageId = originalPageId;
        appConfig.appSettingsId = appSettingsId;
        
        
        appConfig.id = id;
        appConfig.storeId = storeId;
        appConfig.deleted = deleted;
        appConfig.className = className;
        appConfig.rowCreatedDate = rowCreatedDate;
        
        for (String key : settings.keySet()) {
            Setting setting = settings.get(key);
            
            Setting clonedSetting = new Setting();
            clonedSetting.value = setting.value;
            
            if (setting.secure)
                clonedSetting.value = "****************";
                
            appConfig.settings.put(key, clonedSetting);
        }

        return appConfig;
    }
}
