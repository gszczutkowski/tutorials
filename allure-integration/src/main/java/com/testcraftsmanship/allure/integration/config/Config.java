package com.testcraftsmanship.allure.integration.config;

import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final String PROPERTIES_FILE = "configuration.properties";
    private static final String ALLURE_BUG_TRACING_TOOL_PROPERTY = "allure.link.issue.pattern";
    private static final String ALLURE_TEST_MANAGEMENT_TOOL_PROPERTY = "allure.link.tms.pattern";
    private static Properties properties = new Properties();
    private static Config config;

    private Config() {
        try {
            properties.load(Config.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE));
            initializeAllureSettings();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Config config() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public void initializeAllureSettings() {
        System.setProperty(ALLURE_BUG_TRACING_TOOL_PROPERTY, properties.getProperty(ALLURE_BUG_TRACING_TOOL_PROPERTY));
        System.setProperty(ALLURE_TEST_MANAGEMENT_TOOL_PROPERTY, properties.getProperty(ALLURE_TEST_MANAGEMENT_TOOL_PROPERTY));
    }
}
