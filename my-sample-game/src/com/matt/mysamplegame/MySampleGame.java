package com.matt.mysamplegame;

//import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.matt.mysamplegame.Screens.SplashScreen;

//public class MySampleGame implements ApplicationListener {
public class MySampleGame extends Game {
	
	public static final String VERSION = "0.01 Pre-Alpha";
	public static final String LOG = "Angry Masons";
	
	@Override
	public void create() {
		Texture.setEnforcePotImages(false);
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
