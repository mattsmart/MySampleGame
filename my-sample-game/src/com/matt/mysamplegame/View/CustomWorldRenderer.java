package com.matt.mysamplegame.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.matt.mysamplegame.Model.Ship;

public class CustomWorldRenderer {
	
	CustomWorld world;
	SpriteBatch batch;
	Ship ship;
	Camera cam;
	Texture shipTexture;
	
	public CustomWorldRenderer(CustomWorld world) {
		this.world = world;
		batch = new SpriteBatch();
		cam = new OrthographicCamera();
		shipTexture = new Texture("data/ship.png");
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1); // black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // clears the screen
	
		ship = world.getShip();
		batch.begin();
		batch.draw(shipTexture, ship.getPosition().x, ship.getPosition().y);
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		shipTexture.dispose();
	}

}
