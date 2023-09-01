package ru.legilimens.game.ui.screen;

import com.badlogic.gdx.Screen;

import ru.legilimens.game.Game;
import ru.legilimens.game.io.Logger;
import ru.legilimens.game.utils.ScreenManager;

public class GameMenuScreen implements Screen {
    @Override
    public void show() {
        Logger.log("GameMenuScreen", "show");

        ScreenManager.getInstance().setScreen("GameLoadScreen");
    }

    @Override
    public void render(float delta) {
        Logger.log("GameMenuScreen", "render");
    }

    @Override
    public void resize(int width, int height) {
        Logger.log("GameMenuScreen", "resize");
    }

    @Override
    public void pause() {
        Logger.log("GameMenuScreen", "pause");
    }

    @Override
    public void resume() {
        Logger.log("GameMenuScreen", "resume");
    }

    @Override
    public void hide() {
        Logger.log("GameMenuScreen", "hide");
    }

    @Override
    public void dispose() {
        Logger.log("GameMenuScreen", "dispose");
    }
}
