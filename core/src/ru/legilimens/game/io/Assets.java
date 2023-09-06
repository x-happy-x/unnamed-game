package ru.legilimens.game.io;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;

import ru.legilimens.game.Context;
import ru.legilimens.game.math.Progress;
import ru.legilimens.game.math.ProgressSmoothImpl;
import ru.legilimens.game.utils.level.LevelManager;

public class Assets {

    private final AssetManager manager;
    private final Resources resources;
    private final Progress progress;

    private final PathManager mPath = Context.mPath;
    private final LevelManager mLevel = Context.mLevel;

    public Assets(Resources resources) {
        this.resources = resources;

        manager = new AssetManager(new ExtFileHandleResolver());
        progress = new ProgressSmoothImpl();
    }

    public String getLevelContent(String file) {
        return Files.read(mPath.levelPath() + "/" + file);
    }

    public String getContent(String file) {
        return Files.read("resources/" + file);
    }


    public void load(String resource) {
        manager.load(resources.get(resource));
    }

    public void loadAll() {
        int level = mLevel.getLevel();
        if (level >= 0) {
            resources.getFiles(level).forEach(file ->
                    manager.load(resources.get(level, file))
            );
        } else {

        }
        if (level != 0) manager.load(resources.getGUI());
    }


    public <T> T get(AssetDescriptor<T> descriptor) {
        return manager.get(descriptor);
    }

    public <T> T get(String name) {
        return get((AssetDescriptor<T>) resources.get(name));
    }


    public void waitLoad(AssetDescriptor<?> asset) {
        Logger.log("wait load", asset);
        manager.finishLoadingAsset(asset.fileName);
    }

    public void waitLoad(String name) {
        waitLoad(resources.get(name));
    }

    public void waitLoadFile(String fileName) {
        Logger.log("wait load file", fileName);
        manager.finishLoadingAsset(fileName);
    }


    public boolean loading() {
        return !manager.update();
    }

    public float getProgress() {
        progress.set(manager.getProgress());
        return progress.get();
    }

    public void clear() {
        manager.clear();
        progress.reset();
    }
}
