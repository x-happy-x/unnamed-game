package ru.legilimens.game.ui.view;

import ru.legilimens.game.Context;
import ru.legilimens.game.math.shape.Rectangle;
import ru.legilimens.game.utils.render.ShapeRenderer;
import ru.legilimens.game.utils.render.ViewRenderer;

public abstract class View implements IView {
    protected Context context;
    protected ViewRenderer viewRenderer;
    protected ShapeRenderer shapeRenderer;




    protected Rectangle position;

    protected boolean enabled;
    protected boolean visible;

    public View(Context context) {
        this.context = context;
        this.viewRenderer = context.rView;
        this.shapeRenderer = context.rShape;

        this.position = new Rectangle();
        this.enabled = true;
        this.visible = true;
    }


    @Override
    public boolean enabled() {
        return enabled;
    }

    @Override
    public boolean visible() {
        return visible;
    }

    @Override
    public IView setEnable(boolean enable) {
        this.enabled = enable;
        return this;
    }

    @Override
    public IView setVisible(boolean visible) {
        this.visible = visible;
        return this;
    }

    @Override
    public float getWidth() {
        return position.getWidth();
    }

    @Override
    public float getHeight() {
        return position.getHeight();
    }

    @Override
    public float getX() {
        return position.getX();
    }

    @Override
    public float getY() {
        return position.getY();
    }

    @Override
    public IView setWidth(float width) {
        position.setWidth(width);
        return this;
    }

    @Override
    public IView setHeight(float height) {
        position.setHeight(height);
        return this;
    }

    @Override
    public IView setX(float x) {
        position.setX(x);
        return this;
    }

    @Override
    public IView setY(float y) {
        position.setY(y);
        return this;
    }

    @Override
    public IView setPosition(float x, float y) {
        position.setPosition(x, y);
        return this;
    }

    @Override
    public IView setSize(float width, float height) {
        position.setSize(width, height);
        return this;
    }
}
