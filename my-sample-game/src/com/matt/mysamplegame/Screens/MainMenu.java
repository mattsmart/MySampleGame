package com.matt.mysamplegame.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.Align;
import com.matt.mysamplegame.MySampleGame;

public class MainMenu implements Screen {

	MySampleGame game;
	Stage stage;
	BitmapFont black;
	BitmapFont white;
	TextureAtlas atlas;
	Skin skin;
	SpriteBatch batch;
	TextButton button;
	Label label;
	
	public MainMenu(MySampleGame aGame) {
		this.game = aGame;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1); // black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // clears the screen
	
		stage.act(delta);
		
		batch.begin();
		stage.draw();
		//white.draw(batch, "My Sample Game", Gdx.graphics.getWidth() / 2 - 15, Gdx.graphics.getHeight() / 2 + 100);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		if (stage == null) 
			stage = new Stage(width, height, true);
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		TextButtonStyle style = new TextButtonStyle();
		style.up = skin.getDrawable("buttonnormal");
		style.down = skin.getDrawable("buttonpressed");
		style.font = black;
		
		button = new TextButton("Oops", style);
		button.setWidth(400);
		button.setHeight(100);
		button.setX(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2);
		button.setY(Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);
		
		button.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//System.out.println("Down");
				return true;
			}
			
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {
				game.setScreen(new GameScreen(game));
				System.out.println("Up");
			}
		});
		
		LabelStyle ls = new LabelStyle(white, Color.WHITE);
		label = new Label("My Sample Game", ls);
		label.setX(0);
		label.setX(Gdx.graphics.getHeight() / 2 + 100);
		label.setWidth(width);
		label.setAlignment(Align.center);
		
		stage.addActor(button);
		stage.addActor(label);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		skin = new Skin();
		atlas = new TextureAtlas("data/button.pack");
		skin.addRegions(atlas);
		white = new BitmapFont(Gdx.files.internal("data/whitefont.fnt"), false);
		black = new BitmapFont(Gdx.files.internal("data/font.fnt"), false);
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
		batch.dispose();
		skin.dispose();
		atlas.dispose();
		white.dispose();
		black.dispose();
		stage.dispose();
	}

	
	
}
