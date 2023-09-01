package ru.legilimens.game.ui.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.legilimens.game.math.shape.Rectangle;
import ru.legilimens.game.utils.render.ViewRenderer;

public class ImageView implements IView {

    private TextureRegion textureRegion;
    private Rectangle textureRectangle;
    private float radius;


    private boolean enabled;
    private boolean visible;

    private Rectangle position;

    private final ViewRenderer renderer;

    public ImageView(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
        this.textureRectangle = new Rectangle(
                textureRegion.getRegionX(),
                textureRegion.getRegionY(),
                textureRegion.getRegionHeight(),
                textureRegion.getRegionWidth()
        );
        this.radius = 10f;

        this.position = new Rectangle();
        this.enabled = true;
        this.visible = true;

        this.renderer = ViewRenderer.getInstance();
    }

    private ImageView setRegion(float x, float y, float width, float height) {
        this.textureRegion.setRegion((int) x, (int) y, (int) width, (int) height);
        return this;
    }

    private ImageView setRegion(Rectangle rectangle) {
        return setRegion(rectangle.getX(), rectangle.getY(), rectangle.getWidth(), rectangle.getHeight());
    }

    @Override
    public IView draw(float delta) {
        if (radius > 0) {
            /* Верхний левый угол */
            setRegion(
                    textureRectangle.x,
                    textureRectangle.y,
                    textureRectangle.width / 2f,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x,
                    position.y + position.height - radius,
                    radius,
                    radius
            );

            /* Верхний ряд */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2f - 1,
                    textureRectangle.y,
                    2,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x + radius,
                    position.y + position.height - radius,
                    position.width - radius * 2,
                    radius
            );

            /* Верхний правый угол */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2,
                    textureRectangle.y,
                    textureRectangle.width / 2f,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x + position.width - radius,
                    position.y + position.height - radius,
                    radius,
                    radius
            );

            /* Нижний левый угол */
            setRegion(
                    textureRectangle.x,
                    textureRectangle.y + textureRectangle.height / 2f,
                    textureRectangle.width / 2f,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x,
                    position.y,
                    radius,
                    radius
            );

            /* Нижний ряд */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2f - 1,
                    textureRectangle.y + textureRectangle.height / 2f,
                    2,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x + radius,
                    position.y,
                    position.width - radius * 2,
                    radius
            );

            /* Нижний правый угол */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2,
                    textureRectangle.y + textureRectangle.height / 2f,
                    textureRectangle.width / 2f,
                    textureRectangle.height / 2f
            );
            renderer.draw(
                    textureRegion,
                    position.x + position.width - radius,
                    position.y,
                    radius,
                    radius
            );

            /* Левый ряд */
            setRegion(
                    textureRectangle.x,
                    textureRectangle.y + textureRectangle.height / 2f - 1,
                    textureRectangle.width / 2f,
                    2
            );
            renderer.draw(
                    textureRegion,
                    position.x,
                    position.y + radius,
                    radius,
                    position.height - radius * 2
            );

            /* Центральная часть */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2f - 1,
                    textureRectangle.y + textureRectangle.height / 2f - 1,
                    2,
                    2
            );
            renderer.draw(
                    textureRegion,
                    position.x + radius,
                    position.y + radius,
                    position.width - radius * 2,
                    position.height - radius * 2
            );

            /* Правый ряд */
            setRegion(
                    textureRectangle.x + textureRectangle.width / 2,
                    textureRectangle.y + textureRectangle.height / 2f - 1,
                    textureRectangle.width / 2f,
                    2
            );
            renderer.draw(
                    textureRegion,
                    position.x + position.width - radius,
                    position.y + radius,
                    radius,
                    position.height - radius * 2
            );
        } else {
            renderer.draw(textureRegion, position);
        }
        return setRegion(textureRectangle);
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
