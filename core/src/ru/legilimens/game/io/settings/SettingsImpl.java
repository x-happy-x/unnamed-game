package ru.legilimens.game.io.settings;

import java.util.HashMap;
import java.util.Map;

public class SettingsImpl implements Settings {

    Map<String, String> storage;
    String filepath;

    public SettingsImpl(String filepath) {
        this.filepath = filepath;
        storage = new HashMap<>();
    }

    public void add(String key, String value) {
        storage.put(key, value);
    }

    public void add(String key, Object value) {
        storage.put(key, value.toString());
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public String getString(String key, String defaultValue) {
        return storage.containsKey(key) ? storage.get(key) : defaultValue;
    }

    public Integer getInt(String key) {
        return getInt(key, null);
    }

    public Integer getInt(String key, Integer defaultValue) {
        return storage.containsKey(key) ? Integer.parseInt(storage.get(key)) : defaultValue;
    }

    public Float getFloat(String key) {
        return getFloat(key, null);
    }

    public Float getFloat(String key, Float defaultValue) {
        return storage.containsKey(key) ? Float.parseFloat(storage.get(key)) : defaultValue;
    }

    public Double getDouble(String key) {
        return getDouble(key, null);
    }

    public Double getDouble(String key, Double defaultValue) {
        return storage.containsKey(key) ? Double.parseDouble(storage.get(key)) : defaultValue;
    }

    public Boolean getBoolean(String key) {
        return getBoolean(key, null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return storage.containsKey(key) ? Boolean.parseBoolean(storage.get(key)) : defaultValue;
    }

    @Override
    public void save() {
        SVLoader.toFile(storage, filepath);
    }

}
