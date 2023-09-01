package ru.legilimens.game.io;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Files {

    /**
     * Файл-хандлер по указанному пути
     *
     * @param path путь к файлу
     * @return файл-хандлер
     */
    public static FileHandle getAbsoluteHandle(String path) {
        return Gdx.files.absolute(PathManager.path(path));
    }

    /**
     * Файл-хандлер из папки с данными игры
     *
     * @param path путь к файлу
     * @return файл-хандлер
     */
    public static FileHandle getHandle(String path) {
        return getHandle(path, com.badlogic.gdx.Files.FileType.Absolute);
    }

    /**
     * Файл-хандлер по указанному пути
     *
     * @param path     путь к файлу
     * @param fileType тип пути
     * @return файл-хандлер
     */
    public static FileHandle getHandle(String path, com.badlogic.gdx.Files.FileType fileType) {
        return switch (fileType) {
            case Local -> Gdx.files.local(PathManager.path(path));
            case Internal -> Gdx.files.internal(PathManager.path(path));
            case External -> Gdx.files.external(PathManager.path(path));
            case Classpath -> Gdx.files.classpath(PathManager.path(path));
            default -> Gdx.files.absolute(PathManager.dataPath() + "/" + PathManager.path(path));
        };
    }

    /**
     * Получить файл
     *
     * @param path путь
     * @return файл
     */
    public static File get(String path) {
        return getHandle(path).file();
    }

    /**
     * Содержимое файла
     *
     * @param path путь
     * @return содержимое файла
     */
    public static String read(String path) {
        return getHandle(path).readString().replace("\r", "");
    }

    /**
     * Проверка на существование файла
     *
     * @param path путь
     * @return существует ли файл
     */
    public static boolean isExists(String path) {
        return getHandle(path).exists();
    }

    /**
     * Удаление файла/папки
     *
     * @param path путь
     * @return удалось ли удалить
     */
    public static boolean delete(String path) {
        return delete(get(path));
    }

    /**
     * Удаление файла/папки
     *
     * @param file файл
     * @return удалось ли удалить
     */
    public static boolean delete(File file) {
        boolean success = false;
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isDirectory())
                            success = delete(f);
                        else
                            success = f.delete();
                        Logger.log("Files", success ? "Папка/Файл " + f + " удален(а)" : "Не удалось удалить папку/файл " + f);
                    }
                }
            }
            success = file.delete();
            Logger.log("Files", success ? "Папка/файл " + file + " удалена" : "Не удалось удалить папку/файл " + file);
        } else {
            Logger.log("Files", "Такой папки/файла " + file + " нет");
        }
        return success;
    }
}
