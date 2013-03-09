package com.thundashop.app.bannermanager.data;

import com.thundashop.core.common.DataCommon;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ktonder
 */
public class BannerSet extends DataCommon {
    public List<Banner> banners = new ArrayList();
    public int width = 100;
    public int height = 100;
    public String listId;
}
