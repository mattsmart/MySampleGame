package com.matt.mysamplegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matt.mysamplegame.MySampleGame;

public class SplashScreen implements Screen {
	
	Texture splashTexture; // just an image, mostly
	Sprite splashSprite; // more advanced -- image manipulation
	SpriteBatch batch; // sends bound images (for speed)
	MySampleGame game;
	
	public SplashScreen(MySampleGame aGame) {
		this.game = aGame;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		splashSprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
		splashTexture = new Texture("data/goat1280.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		splashSprite = new Sprite(splashTexture);
		//splashSprite.setOrigin(splashSprite.getWidth() / 2, splashSprite.getHeight() / 2);
		//splashSprite.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		splashSprite.setPosition(0,0);
	
		batch = new SpriteBatch();
	}

	@Override
	public void hide() {
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
