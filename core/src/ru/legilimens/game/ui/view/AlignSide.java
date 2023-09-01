package ru.legilimens.game.ui.view;

import com.badlogic.gdx.utils.Align;

public enum AlignSide {
    TOP(Align.top),
    LEFT(Align.left),
    CENTER(Align.center),
    RIGHT(Align.right),
    BOTTOM(Align.bottom);

    private final int value;

    AlignSide(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
