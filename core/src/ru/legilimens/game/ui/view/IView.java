package ru.legilimens.game.ui.view;

public interface IView {
    IView draw(float delta);

    boolean enabled();
    boolean visible();

    IView setEnable(boolean enable);
    IView setVisible(boolean visible);
    float getWidth();
    float getHeight();
    float getX();
    float getY();
    IView setWidth(float width);
    IView setHeight(float height);
    IView setX(float x);
    IView setY(float y);
    IView setPosition(float x, float y);
    IView setSize(float width, float height);
}
