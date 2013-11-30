package com.matt.mysamplegame.View;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.matt.mysamplegame.Model.Bullet;
import com.matt.mysamplegame.Model.Ship;

public class InputHandler implements InputProcessor{

	CustomWorld world;
	Ship ship;
	Vector3 touch = new Vector3();
	Vector2 vec2Touch = new Vector2(); 
	
	public InputHandler(CustomWorld world) {
		this.world = world;
	}
	
	@Override
	public boolean keyDown(int keycode) {
		ship = world.getShip();
		switch(keycode) {
			case Keys.W:
				ship.getVelocity().y = 1;
				break;
			case Keys.S:
				ship.getVelocity().y = -1;
				break;
			case Keys.A:
				ship.getVelocity().x = -1;
				break;
			case Keys.D:
				ship.getVelocity().x = 1;
				break;
			default:
				break;
		}
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		ship = world.getShip();
		switch(keycode) {
			case Keys.W:
				if(ship.getVelocity().y == 1)
				ship.getVelocity().y = 0;
				break;
			case Keys.S:
				if(ship.getVelocity().y == -1)
				ship.getVelocity().y = 0;
				break;
			case Keys.A:
				if(ship.getVelocity().x == -1)
				ship.getVelocity().x = 0;
				break;
			case Keys.D:
				if(ship.getVelocity().x == 1)
				ship.getVelocity().x = 0;
				break;
			default:
				break;
		}
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touch.set(screenX, screenY, 0);
		world.getRenderer().getCamera().unproject(touch);
		vec2Touch.set(touch.x, touch.y);
		ship = world.getShip();
		world.addBullet(new Bullet(Bullet.SPEED, // speed
				0, // rot
				//new Vector2(ship.getPosition().x + ship.getWidth() / 2, ship.getPosition().y + ship.getHeight() / 2), // pos
				new Vector2(ship.getPosition().x, ship.getPosition().y), // pos
				.1f, .4f, // width and height
				new Vector2(vec2Touch.sub(ship.getPosition()).nor()))); // velocity
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
}
