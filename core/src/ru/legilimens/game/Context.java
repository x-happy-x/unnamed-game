package ru.legilimens.game;

import java.io.IOException;
import java.util.List;

import ru.legilimens.game.config.GameConfig;
import ru.legilimens.game.config.LevelConfig;
import ru.legilimens.game.io.Assets;
import ru.legilimens.game.io.PathManager;
import ru.legilimens.game.io.Resources;
import ru.legilimens.game.resources.Resource;
import ru.legilimens.game.utils.level.LevelManager;
import ru.legilimens.game.utils.level.LevelManagerImpl;
import ru.legilimens.game.utils.render.ShapeRenderer;
import ru.legilimens.game.utils.render.ViewRenderer;
import ru.legilimens.game.utils.screen.ScreenManager;
import ru.legilimens.game.utils.screen.ScreenManagerImpl;

public class Context {

    // Static Tools
    public static GameConfig gConfig;
    public static LevelManager mLevel;
    public static PathManager mPath;

    // Context Tools
    public ScreenManager mScreen;
    public ShapeRenderer rShape;
    public ViewRenderer rView;
    public Camera camera;


    public Resources resources;
    public Assets assets;

    public Context(Game game) {

        initStatics();

        mScreen = new ScreenManagerImpl(game, this);
        rView = new ViewRenderer(this);
        rShape = new ShapeRenderer(this);

        camera = new Camera();
        camera.setToOrtho(false, 1000,1000);
        rShape.setProjectionMatrix(camera.combined);
        rView.setProjectionMatrix(camera.combined);

        resources = new Resources();


        gConfig.getLevels().forEach(levelInfo -> {
            String levelPath = mPath.levelInfoPath(0);
            try {
                LevelConfig levelConfig = LevelConfig.load(levelPath);
                List<Resource> levelResources = levelConfig.getGroupResources("loadscreen");
                for (Resource levelResource : levelResources) {
                    resources.add(
                            0,
                            levelResource.getName(),
                            levelResource.getPath(),
                            levelResource.getType()
                    );
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        assets = new Assets(resources);
    }

    private void initStatics() {
        mLevel = new LevelManagerImpl();
        mPath = new PathManager();

        try {
            gConfig = GameConfig.load("game.yaml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ((LevelManagerImpl) mLevel).setConfig(gConfig);
    }

    public void dispose() {
        assets.clear();
        rView.dispose();
        rShape.dispose();
    }
}
