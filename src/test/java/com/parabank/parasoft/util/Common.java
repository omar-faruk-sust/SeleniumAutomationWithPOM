package com.parabank.parasoft.util;

import java.util.HashMap;
import java.util.Map;

public class Common {
    public static final int IMPLICIT_WAIT_TIME = 40;
    public static final String BASE_URL = "https://parabank.parasoft.com/parabank/index.htm";
    public static final String LOGIN_TITLE = "ParaBank | Welcome | Online Banking";
    public static final String FIREFOX = "firefox";
    public static final String FIREFOX_HEADLESS = "firefoxHeadless";
    public static final String CHROME = "chrome";
    public static final String CHROME_HEADLESS = "chromeHeadless";
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    public static final String USERNAME = "omar";
    public static final String PASSWORD = "omar";

    public static Map<String, String> getQueryParams(String query) {
        String[] params = query.split("&");
        Map<String, String> map = new HashMap<String, String>();

        for (String param : params) {
            String name = param.split("=")[0];
            String value = param.split("=")[1];
            map.put(name, value);
        }
        return map;
    }
}
