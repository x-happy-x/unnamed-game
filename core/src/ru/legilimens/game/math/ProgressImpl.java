package ru.legilimens.game.math;

public class ProgressImpl implements Progress {

    private float value;

    @Override
    public float get() {
        return value;
    }

    @Override
    public void set(float value) {
        this.value = value;
    }

    @Override
    public void reset() {
        this.value = 0;
    }
}
