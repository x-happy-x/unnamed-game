package ru.legilimens.game.utils.render;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class ViewRenderer extends SpriteBatch {

    private ViewRenderer() {}
    private static class Holder {
        public static final ViewRenderer VIEW_RENDERER = new ViewRenderer();
        public static final ShapeRenderer SHAPE_RENDERER = ShapeRenderer.getInstance();
    }
    public static ViewRenderer getInstance() {
        return Holder.VIEW_RENDERER;
    }

    public void forceBegin() {
        if (!isDrawing()) {
            if (Holder.SHAPE_RENDERER.isDrawing()) {
                Holder.SHAPE_RENDERER.end();
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
