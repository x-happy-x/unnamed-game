package ru.legilimens.game.io.settings;

import java.util.HashMap;
import java.util.Map;

import ru.legilimens.game.io.Files;

public class SVLoader {

    private SVLoader() {}
    public static Map<String, String> fromText(String text) {
        Map<String, String> map = new HashMap<>();
        for (String row : text.replace("\r", "").trim().split("\n")) {
            map.put(row.split(":")[0].trim(), row.split(":", 2)[1].trim());
        }
        return map;
    }

    public static Map<String, String> fromFile(String filepath) {
        return fromText(Files.read(filepath));
    }

    public static String toString(Map<String, String> map) {
        StringBuilder out = new StringBuilder();
        for (String key : map.keySet()) {
            out.append(key).append(": ").append(map.get(key)).append("\n");
        }
        return out.toString();
    }

    public static void toFile(Map<String, String> map, String filepath) {
        Files.getHandle(filepath).writeString(toString(map), false);
    }
}
