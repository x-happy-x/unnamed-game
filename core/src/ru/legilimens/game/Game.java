package ru.legilimens.game;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.List;

import ru.legilimens.game.config.GameConfig;
import ru.legilimens.game.config.LevelConfig;
import ru.legilimens.game.io.Assets;
import ru.legilimens.game.io.Logger;
import ru.legilimens.game.io.Resources;
import ru.legilimens.game.resources.R;
import ru.legilimens.game.resources.Resource;
import ru.legilimens.game.utils.render.ViewRenderer;
import ru.legilimens.game.utils.screen.IGameScreen;

public class Game extends com.badlogic.gdx.Game implements IGameScreen {


    private Context context;


    public Game() {

    }

    @Override
    public void create() {
        context = new Context(this);
        context.mScreen.setScreen(R.screen.GameLoadScreen);
    }

    @Override
    public void render() {
        super.render();
    }


    @Override
    public void dispose() {
        context.dispose();
        super.dispose();
    }
}
