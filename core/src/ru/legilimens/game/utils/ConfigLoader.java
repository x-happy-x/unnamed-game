package ru.legilimens.game.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;

import ru.legilimens.game.io.Files;

public class ConfigLoader {

    public static Object load(String file, Class configClass) throws IOException {
        ObjectMapper mapper;
        if (file.endsWith(".json")) {
            mapper = new ObjectMapper(new JsonFactory());
        } else if (file.endsWith(".yaml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        } else {
            return null;
        }
        return mapper.readValue(Files.get(file), configClass);
    }

}
