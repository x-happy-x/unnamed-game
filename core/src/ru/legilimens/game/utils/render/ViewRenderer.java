package ru.legilimens.game.utils.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import ru.legilimens.game.Context;

public class ViewRenderer extends SpriteBatch {

    private final Context context;

    public ViewRenderer(Context context) {
        this.context = context;
    }

    public void forceBegin() {
        if (!isDrawing()) {
            if (context.rShape.isDrawing()) {
                context.rShape.end();
            }
            begin();
        }
    }

    public void forceEnd() {
        if (isDrawing()) {
            end();
        }
    }

    public void draw(TextureRegion region, Rectangle rectangle) {
        super.draw(region, rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}
