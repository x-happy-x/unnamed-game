package ru.legilimens.game.io.files;

import ru.legilimens.game.io.Files;
import ru.legilimens.game.utils.CharsetUtils;

public class QuickFiles {
    public static String read(String path) {
        return Files.getHandle(path).readString().replace("\r", "");
    }

    public static void write(String path, String text) {
        Files.getHandle(path).writeString(text, false, CharsetUtils.DEFAULT_CHARSET);
    }
}
