package ru.legilimens.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.IOException;
import java.util.List;

import ru.legilimens.game.config.GameConfig;
import ru.legilimens.game.config.LevelConfig;
import ru.legilimens.game.io.Assets;
import ru.legilimens.game.io.Logger;
import ru.legilimens.game.io.PathManager;
import ru.legilimens.game.io.Resources;
import ru.legilimens.game.ui.screen.GameLoadScreen;
import ru.legilimens.game.ui.screen.GameMenuScreen;
import ru.legilimens.game.utils.LevelsControl;
import ru.legilimens.game.utils.render.ShapeRenderer;
import ru.legilimens.game.utils.render.ViewRenderer;

public class Game extends com.badlogic.gdx.Game {

	GameConfig config;
	Resources resources;
	ViewRenderer renderer;
	ShapeRenderer shaper;
	Assets assets;

	TextureAtlas atlas;
	TextureRegion region;


	private Game() {}
	private static class Holder {
		public static final Game GAME_INSTANCE = new Game();
	}
	public static Game getInstance() {
		return Holder.GAME_INSTANCE;
	}
	
	@Override
	public void create () {

		renderer = ViewRenderer.getInstance();
		shaper = ShapeRenderer.getInstance();

		try {
			config = GameConfig.load("game.yaml");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		resources = Resources.getInstance();
		assets = Assets.getInstance();
		LevelsControl.init(config);

		config.getLevels().forEach(levelInfo -> {
			String levelPath = PathManager.levelInfoPath(0);
			try {
				LevelConfig levelConfig = LevelConfig.load(levelPath);
				List<LevelConfig.Resource> levelResources = levelConfig.getGroupResources("loadscreen");
				for (LevelConfig.Resource levelResource : levelResources) {
					resources.add(
							0,
							levelResource.getName(),
							levelResource.getPath(),
							levelResource.getType()
					);
				}
				assets.loadAll();
				assets.waitLoad("load");
				atlas = assets.get("load");
				region = atlas.findRegion("dog");
				Logger.log("config", levelConfig);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		});

//		for (int i = 0; i <= config.getLevelsCount(); i++) {
//			resources.setProperty(i, "path",);
//		}
//
//		x = 50;
//		y = 200;
//		img = new Texture("badlogic2.jpg");

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		renderer.forceBegin();
		renderer.draw(region, 0,0);
		renderer.forceEnd();
		setScreen(new GameMenuScreen());
		//renderer.begin();
		//renderer.draw(img, x, align.getValue() * y);
		//renderer.end();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
		shaper.dispose();
		//img.dispose();
	}
}
