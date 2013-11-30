package com.matt.mysamplegame.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.Model.Follower;
import com.matt.mysamplegame.Model.Ship;

public class CustomWorld {
	
	MySampleGame game;
	Ship ship;
	Follower follower;

	public CustomWorld(MySampleGame game) {
		this.game = game;	
		ship = new Ship(5f, 0, new Vector2(5, 5), 1, 1);
		follower = new Follower(5f, 0, new Vector2(10, 10), 1, 1);
		Gdx.input.setInputProcessor(new InputHandler(this));
	}

	public Ship getShip() {
		return ship;
	}
	
	public Follower getFollower() {
		return follower;
	}

	public void update() {
		ship.update();
		follower.update(ship);
		
		if(ship.getBounds().overlaps(follower.getBounds()))
			Gdx.app.log(MySampleGame.LOG, "SHIP HIT :0");
	}
	
	public void dispose() {

	}
}
