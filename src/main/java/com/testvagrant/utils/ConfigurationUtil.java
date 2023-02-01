package com.testvagrant.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

public class ConfigurationUtil {

    static Properties prop = new Properties();
    static InputStream input = null;

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private ConfigurationUtil() {
    }

    private static ConfigurationUtil _instance = null;

    public static ConfigurationUtil getInstance() {
        if (_instance == null) {
            _instance = new ConfigurationUtil();
        }
        return _instance;
    }

    public static void setFileName(String fileName) {
        loadProperties(fileName, prop, input);
    }

    private static void loadProperties(String fileName, Properties prop,
                                       InputStream input) {
        // TODO Auto-generated method stub
        try {
            input = new FileInputStream(fileName);
            if (prop != null) {
                prop.load(input);
                input.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getValue(String key) {
        if (getInstance().getProperty(key) != null) {
            return getInstance().getProperty(key);
        } else {
            return key;
        }
    }

    public String getProperty(String key) {
        return (String) prop.get(key);
    }

    public static Set<Object> getAllPropertyNames() {
        return prop.keySet();
    }

}