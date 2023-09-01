package ru.legilimens.game.utils;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class FileUtils {

    @SuppressWarnings("DefaultLocale")
    public static String formatSize(long bytes) {
        long absB = bytes == Long.MIN_VALUE ? Long.MAX_VALUE : Math.abs(bytes);
        if (absB < 1024) {
            return bytes + " Б";
        }
        long value = absB;
        CharacterIterator ci = new StringCharacterIterator("КМГТПЕ");
        for (int i = 40; i >= 0 && absB > 0xfffccccccccccccL >> i; i -= 10) {
            value >>= 10;
            ci.next();
        }
        value *= Long.signum(bytes);
        return String.format("%.1f %cБ", value / 1024.0, ci.current());
    }
}
