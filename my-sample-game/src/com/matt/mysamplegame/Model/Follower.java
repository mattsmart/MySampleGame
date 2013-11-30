package com.matt.mysamplegame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Follower extends Enemy {

	float ROTATION_SPEED = 100;
	
	public Follower(float SPEED, float rotation, Vector2 position, float width, float height) {
		super(SPEED, rotation, position, width, height);
	}

	@Override
	public void advance(float delta, Ship ship) {
		position.lerp(ship.getPosition(), delta);
		
		rotation += (delta * ROTATION_SPEED) % 360; 
		
		super.update(ship);		
	}

}
