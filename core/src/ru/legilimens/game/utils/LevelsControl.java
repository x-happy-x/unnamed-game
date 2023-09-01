package ru.legilimens.game.utils;

import java.util.List;

import ru.legilimens.game.config.GameConfig;

public class LevelsControl {
    private LevelsControl() {}

    private static int LEVEL;
    private static List<GameConfig.LevelInfo> levels;
    public static void init(GameConfig config) {
        levels = config.getLevels();
    }

    public static void setLevel(int level) {
        LevelsControl.LEVEL = level;
    }

    public static int getLevel() {
        return LEVEL;
    }

    public static List<GameConfig.LevelInfo> getLevels() {
        return levels;
    }

    public static GameConfig.LevelInfo getLevelInfo(int level) {
        return levels.get(level);
    }

    public static GameConfig.LevelInfo getLevelInfo() {
        return levels.get(getLevel());
    }
}
