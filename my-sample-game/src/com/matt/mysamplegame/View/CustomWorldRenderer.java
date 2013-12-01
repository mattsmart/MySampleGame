package com.matt.mysamplegame.View;

import java.io.IOException;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.Model.Bullet;
import com.matt.mysamplegame.Model.Enemy;
import com.matt.mysamplegame.Model.Ship;

public class CustomWorldRenderer {
	
	CustomWorld world;
	SpriteBatch batch;
	OrthographicCamera cam;
	Texture shipTexture, followerTexture, bulletTexture;
	float width, height;
	ShapeRenderer sr;
	Ship ship;
	Bullet bullet;
	Enemy enemy;
	Array<Bullet> bullets;
	Array<Enemy> enemies;
	Iterator<Bullet> bIter;
	Iterator<Enemy> eIter;
	ParticleEmitter exhaust;
	
	
	public CustomWorldRenderer(CustomWorld world) {
		this.world = world;
		
		world.setRenderer(this);
		
		width = Gdx.graphics.getWidth() / 40;
		height = Gdx.graphics.getHeight() / 40;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		shipTexture = new Texture("data/ship.png");
		shipTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear); // change linear to nearest if ya like
		followerTexture = new Texture("data/follower.png");
		followerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bulletTexture = new Texture("data/bullet.png");
		bulletTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		sr = new ShapeRenderer();
		
		exhaust = new ParticleEmitter();
		
		try {
			exhaust.load(Gdx.files.internal("data/exhaust").reader(2024));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Texture particleTexture = new Texture(Gdx.files.internal("data/particle.png"));
		Sprite particle = new Sprite(particleTexture);
		exhaust.setSprite(particle);
		exhaust.getScale().setHigh(0.3f);
		exhaust.start();
	
	}
	
	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1); // black
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT); // clears the screen
		
		// Get objects from world
		ship = world.getShip();
		enemies = world.getEnemies();
		bullets = world.getBullets();
		
		// Deal with exhaust particle effect		
		exhaust.setPosition(ship.getPosition().x + ship.getWidth() / 2, ship.getPosition().y + ship.getHeight() / 2);
		setExhaustRotation();
		
		// Update the camera (follow ship or not)
		cam.position.set(ship.getPosition().x, ship.getPosition().y, 0);
		cam.update();
		
		// Set the batch matrix to the camera matrix
		batch.setProjectionMatrix(cam.combined);
		
		// Commence rendering
		batch.begin();
		
		// Draw exhaust
		exhaust.draw(batch, Gdx.graphics.getDeltaTime());
		
		// Draw ship
		batch.draw(shipTexture, ship .getPosition().x, ship.getPosition().y, ship.getWidth() / 2, ship.getHeight() / 2, ship.getWidth(), ship.getHeight(), 1, 1, ship.getRotation(), 0, 0, shipTexture.getWidth(), shipTexture.getHeight(), false, false);
		
		// Draw enemies using iterator
		eIter = enemies.iterator();
		while (eIter.hasNext()) {
			enemy = eIter.next();
			batch.draw(followerTexture, enemy.getPosition().x, enemy.getPosition().y, enemy.getWidth() / 2, enemy.getHeight() / 2, enemy.getWidth(), enemy.getHeight(), 1, 1, enemy.getRotation(), 0, 0, followerTexture.getWidth(), followerTexture.getHeight(), false, false);
		}
		
		// Draw bullets using iterator
		bIter = bullets.iterator();
		while (bIter.hasNext()) {
			bullet = bIter.next();
			batch.draw(bulletTexture, bullet.getPosition().x, bullet.getPosition().y, bullet.getWidth() / 2, bullet.getHeight() / 2, bullet.getWidth(), bullet.getHeight(), 1, 1, bullet.getRotation(), 0, 0, bulletTexture.getWidth(), bulletTexture.getHeight(), false, false);
		}
		batch.end();
		
		// Only draw hit boxes if DEBUG is on
		if (MySampleGame.DEBUG) {
			sr.setProjectionMatrix(cam.combined);
			sr.begin(ShapeType.Line);
			
			sr.setColor(Color.CYAN);
			sr.rect(ship.getBounds().x, ship.getBounds().y,
					ship.getBounds().width, ship.getBounds().height);
			
			sr.setColor(Color.RED);
			eIter = enemies.iterator();
			while (eIter.hasNext()) {
				enemy = eIter.next();
				sr.rect(enemy.getBounds().x, enemy.getBounds().y,
						enemy.getBounds().width, enemy.getBounds().height);
			}
			
			sr.setColor(Color.PINK);
			bIter = bullets.iterator();
			while (bIter.hasNext()) {
				bullet = bIter.next();
				sr.rect(bullet.getBounds().x, bullet.getBounds().y,
						bullet.getBounds().width, bullet.getBounds().height);
			}
			sr.end();
		}
	}
	
	public OrthographicCamera getCamera() {
		return this.cam;
	}
	
	private void setExhaustRotation() {
		float angle = ship.getRotation();
		exhaust.getAngle().setLow(angle + 270);
		exhaust.getAngle().setHighMin(angle + 270 - 45);
		exhaust.getAngle().setHighMax(angle + 270 + 45);
	}
	
	public void dispose() {
		batch.dispose();
		shipTexture.dispose();
		followerTexture.dispose();
		bulletTexture.dispose();
		sr.dispose();
	}

}
