package ru.legilimens.game.ui.screen;

import ru.legilimens.game.Context;
import ru.legilimens.game.io.Logger;

public class GameMenuScreen extends Screen {

    public GameMenuScreen(Context context) {
        super(context);
    }

    @Override
    public void show() {
        Logger.log("GameMenuScreen", "show");

        context.mScreen.setScreen("GameLoadScreen");
    }

    @Override
    public void render(float delta) {
        Logger.log("GameMenuScreen", "render");
    }

    @Override
    public void resize(int width, int height) {
        Logger.log("GameMenuScreen", "resize", width, height);
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
