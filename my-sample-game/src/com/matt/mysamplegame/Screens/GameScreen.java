package com.matt.mysamplegame.Screens;

import com.badlogic.gdx.Screen;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.View.CustomWorld;

public class GameScreen implements Screen {

	MySampleGame game;
	CustomWorld customWorld;
	//WorldRenderer render;
	
	public GameScreen(MySampleGame aGame) {
		this.game = aGame;
	}
	
	@Override
	public void render(float delta) {
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
	}

}
