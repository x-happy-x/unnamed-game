package ru.legilimens.game.io;

import com.badlogic.gdx.Gdx;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Logger {

    public static String APP_LOG_TAG = "GAME";
    private Logger() {}

    private static Process logger;

    public static void enable() {
        //Gdx.app.setApplicationLogger();
        try {
            logger = Runtime.getRuntime().exec(new String[]{"logcat", "-f", Files.get("log.txt").getAbsolutePath()});//, APP_LOG_TAG + ":V", "*:S"});
            write("- LOG START -");
        } catch (IOException e) {
            write(e.getLocalizedMessage());
        }
    }

    public static void clear() {
        if (logger == null) return;
        try {
            logger.destroy();
            write(Files.get("log.txt").delete()?"Логи удалены":"Логи не удалось удалить");
            write(Files.get("log.txt").createNewFile()?"Новый файлик для логов создан":"Не удалось создать новый файл для логов");
            enable();
        } catch (IOException e) {
            write(e.getLocalizedMessage());
        }
    }

    public static void write(String text) {
        Gdx.app.log(APP_LOG_TAG, text);// EncryptManager.decodeString(text, true));
    }

    public static void log(String title, Object... messages) {
        String message = Arrays.stream(messages).map(Object::toString).collect(Collectors.joining(" "));
        write(title + ": " + message);
    }
}
