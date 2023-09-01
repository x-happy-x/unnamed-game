package ru.legilimens.game.utils.render;

public class ShapeRenderer extends com.badlogic.gdx.graphics.glutils.ShapeRenderer {

    private ShapeRenderer() {}
    private static class Holder {
        public static final ViewRenderer VIEW_RENDERER = ViewRenderer.getInstance();
        public static final ShapeRenderer SHAPE_RENDERER = new ShapeRenderer();
    }
    public static ShapeRenderer getInstance() {
        return Holder.SHAPE_RENDERER;
    }


    public void forceBegin() {
        if (!isDrawing()) {
            if (Holder.VIEW_RENDERER.isDrawing()) {
                Holder.VIEW_RENDERER.end();
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
