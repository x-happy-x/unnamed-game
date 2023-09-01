package ru.legilimens.game.io;

import com.badlogic.gdx.Gdx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Archive {

    private static final int BUFFER_SIZE = 1024;

    public static class Part {
        public File file;
        public String path;

        public Part(File f, String path) {
            this.file = f;
            this.path = path;
        }
    }

    public static boolean unpack(File zip, String path, IPackListener listener) {
        int ZIP_UNPACK_COUNT = 0, ZIP_UNPACK_ALL = 0;
//        try (ZipFile zipFile = new ZipFile(zip.getAbsoluteFile())){
//
//        } catch (ZipException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//
//        }
        try {
            ZipFile zipFile = new ZipFile(zip.getAbsoluteFile());
            ZIP_UNPACK_ALL = zipFile.size();
            if (listener != null) {
                listener.update(ZIP_UNPACK_COUNT, ZIP_UNPACK_ALL);
                listener.update(0);
            }
            int size;
            byte[] buf = new byte[BUFFER_SIZE];
            File ePath = new File(path);
            Logger.write("UNPACK: " + zip.getAbsolutePath());
            if (ePath.mkdirs())
                Logger.write("UNPACK: Created output dir: " + ePath.getAbsolutePath());
            ZipInputStream source = new ZipInputStream(new BufferedInputStream(new FileInputStream(zip)));
            ZipEntry ze;
            while ((ze = source.getNextEntry()) != null) {
                File child = new File(path + "/" + ze.getName());
                Logger.write("UNPACK: " + ze.getName());
                if (ze.isDirectory()) {
                    if (!child.isDirectory() && child.mkdirs())
                        ZIP_UNPACK_COUNT++;
                } else {
                    if (!child.getParentFile().exists() && child.getParentFile().mkdirs())
                        ZIP_UNPACK_COUNT++;
                    ZIP_UNPACK_COUNT++;
                    BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(child, false));
                    while ((size = source.read(buf, 0, BUFFER_SIZE)) != -1) {
                        out.write(buf, 0, size);
                    }
                    source.closeEntry();
                    out.flush();
                    out.close();
                }
                if (listener != null) {
                    listener.update(ZIP_UNPACK_COUNT, ZIP_UNPACK_ALL);
                    listener.update(1f / ZIP_UNPACK_ALL * ZIP_UNPACK_COUNT);
                }
            }
            source.close();
            return true;
        } catch (IOException e) {
            Logger.write("UNPACK: ERROR - " + e.getLocalizedMessage());
        }
        return false;
    }

    /**
     * Архивация файлов
     *
     * @param zip   - архив
     * @param files - файлы которые будут добавлены в архив
     * @return - значение удалась ли архивация
     */
    public static boolean pack(File zip, Part... files) {
        FileOutputStream fOut;
        ZipOutputStream zOut;
        try {
            fOut = new FileOutputStream(zip);
            zOut = new ZipOutputStream(fOut);
            for (Part f : files) {
                ZipEntry ze = new ZipEntry(f.path);
                zOut.putNextEntry(ze);
                zOut.write(Gdx.files.absolute(f.file.getAbsolutePath()).readBytes());
                zOut.closeEntry();
            }
            zOut.close();
            return true;
        } catch (IOException e) {
            Logger.write(e.getLocalizedMessage());
        }
        return false;
    }
}
