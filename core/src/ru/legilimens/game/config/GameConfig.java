package ru.legilimens.game.config;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.legilimens.game.utils.ConfigLoader;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameConfig {

    private int version;
    private String channel;
    private List<LevelInfo> levels;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class LevelInfo {
        private String name;
        private String path;
    }

    public int getLevelsCount() {
        return getLevels().size();
    }

    public static GameConfig load(String file) throws IOException {
        return (GameConfig) ConfigLoader.load(file, GameConfig.class);
    }
}
