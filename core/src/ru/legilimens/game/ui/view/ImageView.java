package ru.legilimens.game.ui.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import ru.legilimens.game.Context;
import ru.legilimens.game.math.shape.Rectangle;

public class ImageView extends View {

    private final TextureRegion textureRegion;
    private final Rectangle textureRectangle;

    @Setter
    @Getter
    private float radius;

    public ImageView(Context context, TextureRegion textureRegion) {
        super(context);
        this.textureRegion = textureRegion;
        this.textureRectangle = new Rectangle(
                textureRegion.getRegionX(),
                textureRegion.getRegionY(),
                textureRegion.getRegionHeight(),
                textureRegion.getRegionWidth()
        );
        this.radius = 0f;
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
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
            viewRenderer.draw(
                    textureRegion,
                    position.x + position.width - radius,
                    position.y + radius,
                    radius,
                    position.height - radius * 2
            );
        } else {
            viewRenderer.draw(textureRegion, position);
        }
        return setRegion(textureRectangle);
    }
}
