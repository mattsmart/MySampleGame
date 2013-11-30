package com.matt.mysamplegame.Model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends MoveableEntity {

	public static float SPEED = 15;
	
	public Bullet(float SPEED, float rotation, Vector2 position, float width, float height, Vector2 velocity) {
		super(SPEED, rotation, position, width, height);
		this.velocity = velocity;
	}
	
	@Override
	public void update(Ship ship) {
		position.add(velocity.cpy().scl(Gdx.graphics.getDeltaTime() * SPEED));
		rotation = velocity.angle() - 90;
		super.update(ship);
	}
	
}
