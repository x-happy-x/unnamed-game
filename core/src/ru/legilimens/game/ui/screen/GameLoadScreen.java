package ru.legilimens.game.ui.screen;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.legilimens.game.Context;
import ru.legilimens.game.Game;
import ru.legilimens.game.io.Logger;
import ru.legilimens.game.utils.screen.ScreenManager;

public class GameLoadScreen extends Screen {

    public GameLoadScreen(Context context) {
        super(context);

    }
TextureAtlas t;
    @Override
    public void show() {
        Logger.log("GameLoadScreen", "show");
        context.assets.loadAll();
        context.assets.waitLoad("load");
         t = context.assets.get("load");
    }

    @Override
    public void render(float delta) {
        Logger.log("GameLoadScreen", "render");
        ScreenUtils.clear(1,1,0,1);
        rShape.forceBegin();
        rShape.setColor(1,0,0,1);
        rShape.set(ShapeRenderer.ShapeType.Filled);
        rShape.rect(0, 0, 100, 100);
        rShape.forceEnd();
        rView.forceBegin();
        rView.draw(t.getRegions().get(0),100,100,300,200);
        rView.forceEnd();
    }

    @Override
    public void resize(int width, int height) {
        Logger.log("GameLoadScreen", "resize", width, height);
    }

    @Override
    public void pause() {
        Logger.log("GameLoadScreen", "pause");
    }

    @Override
    public void resume() {
        Logger.log("GameLoadScreen", "resume");
    }

    @Override
    public void hide() {
        Logger.log("GameLoadScreen", "hide");
    }

    @Override
    public void dispose() {
        Logger.log("GameLoadScreen", "dispose");
    }
}
