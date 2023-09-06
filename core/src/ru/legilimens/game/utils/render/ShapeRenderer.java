package ru.legilimens.game.utils.render;

import ru.legilimens.game.Context;

public class ShapeRenderer extends com.badlogic.gdx.graphics.glutils.ShapeRenderer {

    private final Context context;

    public ShapeRenderer(Context context) {
        this.context = context;
        this.setAutoShapeType(true);
    }

    public void forceBegin() {
        if (!isDrawing()) {
            if (context.rView.isDrawing()) {
                context.rView.end();
            }
            begin();
        }
    }

    public void forceEnd() {
        if (isDrawing()) {
            end();
        }
    }
}
