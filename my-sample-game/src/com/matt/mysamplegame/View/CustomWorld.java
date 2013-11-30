package com.matt.mysamplegame.View;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.matt.mysamplegame.MySampleGame;
import com.matt.mysamplegame.Model.Bullet;
import com.matt.mysamplegame.Model.Enemy;
import com.matt.mysamplegame.Model.Follower;
import com.matt.mysamplegame.Model.Ship;

public class CustomWorld {
	
	MySampleGame game;
	Ship ship;
	Array<Bullet> bullets = new Array<Bullet>();
	Array<Enemy> enemies = new Array<Enemy>();
	CustomWorldRenderer wr;
	Iterator<Bullet> bIter;
	Iterator<Enemy> eIter;
	Bullet bullet;
	Enemy enemy;

	public CustomWorld(MySampleGame game) {
		this.game = game;	
		ship = new Ship(5f, 0, new Vector2(5, 5), 1, 1);
		enemies.add(new Follower(5f, 0, new Vector2(10, 10), 1, 1));
		Gdx.input.setInputProcessor(new InputHandler(this));
	}

	public Ship getShip() {
		return this.ship;
	}
	
	public Array<Enemy> getEnemies() {
		return this.enemies;
	}
	
	public Array<Bullet> getBullets() {
		return this.bullets;
	}
	
	public void addBullet(Bullet bullet) {
		bullets.add(bullet);
	}
	
	public void setRenderer(CustomWorldRenderer wr) {
		this.wr = wr;
	}
	
	public CustomWorldRenderer getRenderer() {
		return this.wr;
	}
	

	
	public void update() {
		ship.update();
		
		bIter = bullets.iterator();
		while(bIter.hasNext()){
			bullet = bIter.next();
			bullet.update(ship);
			
			eIter = enemies.iterator();
			while(eIter.hasNext()) {
				enemy = eIter.next();
				enemy.advance(Gdx.graphics.getDeltaTime(), ship);
				
				if(ship.getBounds().overlaps(enemy.getBounds()))
					Gdx.app.log(MySampleGame.LOG, "SHIP HIT :0");
				
				if(enemy.getBounds().overlaps(bullet.getBounds())) {
					Gdx.app.log(MySampleGame.LOG, "Enemy Hit :)");
					eIter.remove();
					bIter.remove();
				}
			}
		}
	}
	
	public void dispose() {

	}
}
