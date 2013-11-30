package com.matt.mysamplegame.Screens;

import com.badlogic.gdx.Screen;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.View.CustomWorld;
import com.matt.mysamplegame.View.CustomWorldRenderer;

public class GameScreen implements Screen {

	MySampleGame game;
	CustomWorld world;
	CustomWorldRenderer render;
	
	public GameScreen(MySampleGame game) {
		this.game = game;
		render = new CustomWorldRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update();
		render.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		world.dispose();
	}

}
