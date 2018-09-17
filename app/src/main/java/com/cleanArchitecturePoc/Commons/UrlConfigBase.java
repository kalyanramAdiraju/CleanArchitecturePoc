package com.cleanArchitecturePoc.Commons;

import com.cleanArchitecturePoc.Commons.Exception.PropertiesUtilityException;

public class UrlConfigBase {

    protected PropertiesUtility mPropertiesUtility;

    protected String mBaseUrl;

    public UrlConfigBase(PropertiesUtility propertiesUtility) {
        mPropertiesUtility = propertiesUtility;
        setBaseUrl("BASE_URL");
    }

    public String getBaseUrl() {
        return mBaseUrl;
    }

    public void setBaseUrl(String key) {
        try {
            mBaseUrl = mPropertiesUtility.getProperty(key);
        } catch (PropertiesUtilityException e) {
            mBaseUrl = "";
        }
    }
}
