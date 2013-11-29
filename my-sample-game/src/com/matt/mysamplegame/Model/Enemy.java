package com.matt.mysamplegame.Model;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends MoveableEntity {

	public Enemy(float SPEED, float rotation, Vector2 position, float width, float height) {
		super(SPEED, rotation, position, width, height);
	}
	
	public abstract void advance(float delta, Ship ship);
}
