package com.thundashop.core.loggermanager.data;

import com.thundashop.core.common.DataCommon;

/**
 *
 * @author boggi
 */
public class LoggerData extends DataCommon {
    
    public class Types {
        public final static int API = 0;
        public final static int Server = 1;
    }
    
    public int type;
    public Object data;
    public String additionalMessage;
    public String userId;
}
