package ru.legilimens.game.io;

import com.badlogic.gdx.Gdx;

import java.util.HashMap;
import java.util.Map;

import ru.legilimens.game.Context;
import ru.legilimens.game.resources.R;
import ru.legilimens.game.utils.Template;
import ru.legilimens.game.utils.level.LevelManager;

public class PathManager {

    private final Map<String, String> RESOURCES_PATHS;
    private final LevelManager mLevel = Context.mLevel;

    public PathManager() {

        RESOURCES_PATHS = new HashMap<>();
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

    public String path(String... paths) {
        String path = String.join("/", paths);
        return Template.replace(path, RESOURCES_PATHS)
                .replace("\\", "/")
                .replace("//", "/");
    }

    public String dataPath() {
        switch (Gdx.app.getType()) {
            case Android:
                return Gdx.files.getLocalStoragePath();
            case Desktop:
                return "./data/";
            default:
                return null;
        }
    }

    public String levelPath(int level) {
        return path(mLevel.getLevelInfo(level).getPath());
    }

    public String levelPath() {
        return path(mLevel.getLevelInfo().getPath());
    }

    public String levelInfoPath(int level) {
        return levelPath(level) + "/main/level.yaml";
    }

    public String levelInfoPath() {
        return levelInfoPath(mLevel.getLevel());
    }
}
