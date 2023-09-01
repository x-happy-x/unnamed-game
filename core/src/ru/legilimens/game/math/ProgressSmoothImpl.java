package ru.legilimens.game.math;

public class ProgressSmoothImpl implements Progress {

    private float real;
    private float smoothed;

    @Override
    public float get() {
        if (smoothed < 1 && real >= smoothed)
            smoothed += Math.max(0.0005f, (real - smoothed) / 100);
        if (smoothed > 1) smoothed = 1f;
        return smoothed;
    }

    @Override
    public void set(float value) {
        this.real = value;
    }

    @Override
    public void reset() {
        this.real = 0;
        this.smoothed = 0;
    }
}
