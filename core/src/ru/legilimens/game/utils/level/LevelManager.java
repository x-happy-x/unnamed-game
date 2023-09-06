package ru.legilimens.game.utils.level;

public interface LevelManager {

    void setLevel(int level);

    int getLevel();

    int getCount();

    LevelInfo getLevelInfo();

    LevelInfo getLevelInfo(int level);
}
