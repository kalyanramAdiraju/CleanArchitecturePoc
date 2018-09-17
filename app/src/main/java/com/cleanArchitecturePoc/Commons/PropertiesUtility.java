package com.cleanArchitecturePoc.Commons;

import android.content.Context;
import android.content.res.AssetManager;

import com.cleanArchitecturePoc.Commons.Exception.PropertiesUtilityException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtility {
    protected Context mContext;
    private Properties properties = null;


    public PropertiesUtility(Context context) {
        mContext = context;
    }
    public void loadProperties() throws PropertiesUtilityException {

        AssetManager assetManager = mContext.getAssets();
        InputStream inputStream = null;
        properties = new Properties();
        try {

            inputStream = assetManager.open("app.properties");
            properties.load(inputStream);

        } catch (IOException e) {
            throw new PropertiesUtilityException("Unable to load property file.");
        }
    }

    public Properties getAllProperties() throws PropertiesUtilityException {
        if (null == properties) {
            loadProperties();
        }
        return properties;
    }

    public String getProperty(String key) throws PropertiesUtilityException {

        String returnString = "";

        if (null == properties) {
            loadProperties();
        }

        returnString = properties.getProperty(key);

        if (null == returnString) {
            throw new PropertiesUtilityException("Property not found in property file");
        }

        return returnString;
    }

    public void resetProperty() {
        properties = null;
    }

}
