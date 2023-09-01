package ru.legilimens.game.utils;

import com.badlogic.gdx.Screen;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.legilimens.game.Game;

public class ScreenManager {

    private ScreenManager() {
        screens = new HashMap<>();
    }
    private static class Holder {
        public static final ScreenManager SCREEN_MANAGER = new ScreenManager();
    }
    public static ScreenManager getInstance() {
        return Holder.SCREEN_MANAGER;
    }

    private Map<String, Screen> screens;
    private String currentScreen;

    public void setScreen(String screenName) {
        String fullScreenName = this.getClass().getPackage().getName().replace("utils", "ui.screen.") + screenName;
        if (screens.containsKey(fullScreenName)) {
            Game.getInstance().setScreen(screens.get(fullScreenName));
        } else {
            Class<?> screenClass = null;
            try {
                screenClass = Class.forName(fullScreenName);
                Screen screen = (Screen) screenClass.getDeclaredConstructor().newInstance();
                screens.put(fullScreenName, screen);
                Game.getInstance().setScreen(screen);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        currentScreen = fullScreenName;

//        try {
//            Class<?> screenClass = Class.forName(this.getClass().getPackage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
}
