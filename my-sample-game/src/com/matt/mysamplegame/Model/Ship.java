package com.matt.mysamplegame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Ship extends MoveableEntity {

	public Ship(float SPEED, float rotation, Vector2 position, float width, float height) {
		super(SPEED, rotation, position, width, height);
	}

	public void update() {
		position.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime() * SPEED));
		
		if(velocity.x != 0 || velocity.y != 0)
			rotation = velocity.angle() - 90;
		
		bounds.x = position.x;
		bounds.y = position.y;
	}

}
