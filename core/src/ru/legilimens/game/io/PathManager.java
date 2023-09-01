package ru.legilimens.game.io;

import com.badlogic.gdx.Gdx;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import ru.legilimens.game.resources.R;
import ru.legilimens.game.utils.LevelsControl;
import ru.legilimens.game.utils.Template;

public abstract class PathManager {

    public static final Map<String, String> RESOURCES_PATHS = new HashMap<>();

    static {
        RESOURCES_PATHS.put("resources", R.path.resources);
        RESOURCES_PATHS.put("textures", R.path.textures);
        RESOURCES_PATHS.put("strings", R.path.strings);
        RESOURCES_PATHS.put("shaders", R.path.shaders);
        RESOURCES_PATHS.put("sounds", R.path.sounds);
        RESOURCES_PATHS.put("musics", R.path.musics);
        RESOURCES_PATHS.put("fonts", R.path.fonts);
        RESOURCES_PATHS.put("levels", R.path.levels);
        RESOURCES_PATHS.put("previews", R.path.previews);
    }

    public static String path(String... paths) {
        String path = String.join("/", paths);
        return Template.replace(path, RESOURCES_PATHS)
                .replace("\\", "/")
                .replace("//", "/");
    }

    public static String dataPath() {
        return switch (Gdx.app.getType()) {
            case Android -> Gdx.files.getLocalStoragePath();
            case Desktop -> "./";
            default -> null;
        };
    }

    public static String levelPath(int level) {
        return path(LevelsControl.getLevelInfo(level).getPath());
    }

    public static String levelPath() {
        return path(LevelsControl.getLevelInfo().getPath());
    }

    public static String levelInfoPath(int level) {
        return levelPath(level) + "/main/level.yaml";
    }

    public static String levelInfoPath() {
        return levelInfoPath(LevelsControl.getLevel());
    }
}
