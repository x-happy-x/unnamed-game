package ru.legilimens.game.io;

public interface IPackListener {
    void update(float progress);
    void update(int unpacked, int total);
}
