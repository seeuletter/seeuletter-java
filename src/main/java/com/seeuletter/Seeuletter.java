package com.seeuletter;

public class Seeuletter {

    public static final String API_BASE_URL = "https://api.seeuletter.com/";
    public static final String VERSION = "1.0.0";

    public static String apiKey;
    public static String apiVersion;

    public static void init(final String apiKey) {
        Seeuletter.apiKey = apiKey;
        Seeuletter.apiVersion = null;
    }

    public static void init(final String apiKey, final String apiVersion) {
        Seeuletter.apiKey = apiKey;
        Seeuletter.apiVersion = apiVersion;
    }

}
