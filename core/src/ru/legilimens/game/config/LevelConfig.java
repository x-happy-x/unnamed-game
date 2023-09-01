package ru.legilimens.game.config;

import java.io.IOException;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.legilimens.game.utils.ConfigLoader;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LevelConfig {

    private String classLoad;
    private List<ResourceGroup> resources;

    public List<Resource> getGroupResources(String name) {
        for (ResourceGroup group : resources) {
            if (group.getGroup().equals("loadscreen")) {
                return group.getFiles();
            }
        }
        return null;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class ResourceGroup {
        private String group;
        private List<Resource> files;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public static class Resource {
        private String name;
        private String path;
        private String type;
        private boolean preload;
    }

    public static LevelConfig load(String file) throws IOException {
        return (LevelConfig) ConfigLoader.load(file, LevelConfig.class);
    }
}
