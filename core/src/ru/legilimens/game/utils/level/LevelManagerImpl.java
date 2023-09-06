package ru.legilimens.game.utils.level;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import ru.legilimens.game.config.GameConfig;

@Getter
@Setter
public class LevelManagerImpl implements LevelManager {

    private int level;
    private List<LevelInfo> levels;

    public LevelManagerImpl() {
        this.level = 0;
    }

    public LevelManagerImpl(GameConfig config) {
        this();
        setConfig(config);
    }

    public void setConfig(GameConfig config) {
        this.levels = config.getLevels();
    }

    public int getCount() {
        return levels.size();
    }

    public LevelInfo getLevelInfo() {
        return levels.get(level);
    }

    public LevelInfo getLevelInfo(int level) {
        return levels.get(level);
    }
}
