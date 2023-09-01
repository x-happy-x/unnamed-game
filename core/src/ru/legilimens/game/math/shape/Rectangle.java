package ru.legilimens.game.math.shape;

public class Rectangle extends com.badlogic.gdx.math.Rectangle {

    public Rectangle() {
    }

    public Rectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public Rectangle(com.badlogic.gdx.math.Rectangle rect) {
        super(rect);
    }
}
