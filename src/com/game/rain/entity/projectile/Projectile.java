package com.game.rain.entity.projectile;

import com.game.graphic.Sprite;
import com.game.rain.entity.Entity;

public abstract class Projectile extends Entity {

	final protected int xOrigin, yOrigin;
	protected double angle;
	private Sprite sprite;
	protected double nx, ny;
	protected double speed, range, damage;
	protected double x, y;
	protected double distance;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}
