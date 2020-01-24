package com.bank.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceManager {
    private static final ResourceManager INSTANCE;

    static {
        INSTANCE = new ResourceManager();
    }

    private ResourceBundle resourceBundle;
    private static final String RESOURCE_BUNDLE = "messages";

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE);
    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE, locale);
    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }

    public static ResourceManager getInstance() {
        return INSTANCE;
    }
}
