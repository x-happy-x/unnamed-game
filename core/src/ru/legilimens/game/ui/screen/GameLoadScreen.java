package ru.legilimens.game.ui.screen;

import com.badlogic.gdx.Screen;

import ru.legilimens.game.Game;
import ru.legilimens.game.io.Logger;

public class GameLoadScreen implements Screen {
    public GameLoadScreen() {
        Logger.log("GameLoadScreen", "constructing");
    }
    @Override
    public void show() {
        Logger.log("GameLoadScreen", "show");
    }

    @Override
    public void render(float delta) {
        Logger.log("GameLoadScreen", "render");
    }

    @Override
    public void resize(int width, int height) {
        Logger.log("GameLoadScreen", "resize");
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
