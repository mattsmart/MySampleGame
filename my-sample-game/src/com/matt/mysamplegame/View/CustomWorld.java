package com.matt.mysamplegame.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.Model.Ship;

public class CustomWorld {
	
	MySampleGame game;
	Ship ship;

	public CustomWorld(MySampleGame game) {
		this.game = game;
		float SPEED = 5f;
		float rotation = 0;
		int height = 1;
		int width = 1;
		Vector2 pos = new Vector2(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);	
		ship = new Ship(SPEED, rotation, pos, width, height);
	}
	
	public Ship getShip() {
		return ship;
	}

	public void update() {
		ship.update();
	}
	
	public void dispose() {

	}
}
