package ru.legilimens.game.utils.screen;

import com.badlogic.gdx.Screen;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import ru.legilimens.game.Context;

public class ScreenManagerImpl implements ScreenManager {

    private final Context context;
    private final IGameScreen gameScreen;
    private final Map<String, Screen> screens;

    private String currentScreen;

    public ScreenManagerImpl(IGameScreen gameScreen, Context context) {
        this.context = context;
        this.gameScreen = gameScreen;
        this.screens = new HashMap<>();
    }

    public void setScreen(String screenName) {
        String fullScreenName = this.getClass().getPackage().getName().replace("utils.screen", "ui.screen.") + screenName;
        if (screens.containsKey(fullScreenName)) {
            setScreen(screens.get(fullScreenName));
        } else {
            Class<?> screenClass;
            try {
                screenClass = Class.forName(fullScreenName);
                Screen screen = (Screen) screenClass.getDeclaredConstructor(Context.class).newInstance(context);
                screens.put(fullScreenName, screen);
                setScreen(screen);
            } catch (ClassNotFoundException | InvocationTargetException | InstantiationException |
                     IllegalAccessException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
        currentScreen = fullScreenName;
    }

    public String getScreen() {
        return currentScreen;
    }

    public void setScreen(Screen screen) {
        gameScreen.setScreen(screen);
    }

    public Screen getCurrentScreen() {
        return gameScreen.getScreen();
    }
}
