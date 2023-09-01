package ru.legilimens.game.utils;

import java.util.Map;

public class Template {
    private Template() {

    }

    public static String replace(String template, String key, String value) {
        return template.replace("{% " + key + " %}", value);
    }

    public static String replace(String template, String[] keys, String[] values) {
        for (int i = 0; i < keys.length && i < values.length; i++) {
            template = replace(template, keys[i], values[i]);
        }
        return template;
    }

    public static String replace(String template, Map<String,String> values) {
        for (String key : values.keySet()) {
            template = replace(template, key, values.get(key));
        }
        return template;
    }
}
