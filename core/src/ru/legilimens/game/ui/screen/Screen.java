package ru.legilimens.game.ui.screen;

import com.badlogic.gdx.Gdx;

import ru.legilimens.game.Context;
import ru.legilimens.game.io.Logger;
import ru.legilimens.game.utils.render.ShapeRenderer;
import ru.legilimens.game.utils.render.ViewRenderer;
import ru.legilimens.game.utils.screen.ScreenManager;

public abstract class Screen implements com.badlogic.gdx.Screen {

    protected Context context;
    protected ShapeRenderer rShape;
    protected ViewRenderer rView;

    public Screen(Context context) {
        this.context = context;

        rView = context.rView;
        rShape = context.rShape;
    }

}
