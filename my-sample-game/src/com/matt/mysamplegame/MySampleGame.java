package com.matt.mysamplegame;

//import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.matt.mysamplegame.Screens.GameScreen;
import com.matt.mysamplegame.Screens.MainMenu;
import com.matt.mysamplegame.Screens.SplashScreen;
import com.matt.mysamplegame.View.CustomAudio;

//public class MySampleGame implements ApplicationListener {
public class MySampleGame extends Game {
	
	public static final String VERSION = "0.2 Pre-Alpha";
	public static final String LOG = "My Sample Game";
	public static boolean DEBUG = false;
	FPSLogger log;
	
	@Override
	public void create() {
		log = new FPSLogger();
		CustomAudio.playMusic(true);
		setScreen(new SplashScreen(this));
		//setScreen(new MainMenu(this));
		//setScreen(new GameScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		CustomAudio.dispose();
	}

	@Override
	public void render() {		
		super.render();
		log.log();
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
