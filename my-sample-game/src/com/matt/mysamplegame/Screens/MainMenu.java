package com.matt.mysamplegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.matt.mysamplegame.MySampleGame;

public class MainMenu implements Screen {

	MySampleGame game;
	
	public MainMenu(MySampleGame aGame) {
		this.game = aGame;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1); // white
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // clears the screen
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
