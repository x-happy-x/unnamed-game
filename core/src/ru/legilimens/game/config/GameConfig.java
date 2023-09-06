package ru.legilimens.game.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.legilimens.game.utils.ConfigLoader;
import ru.legilimens.game.utils.level.LevelInfo;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameConfig {

    private int version;
    private String channel;
    private List<LevelInfo> levels;

    public static GameConfig load(String file) throws IOException {
        return (GameConfig) ConfigLoader.load(file, GameConfig.class);
    }
}
