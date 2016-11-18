package com.game.rain.entity.projectile;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.level.ParticleSpawner;
import com.game.rain.entity.particle.Particle;
import com.game.rain.entity.particle.spawner.Spawner;

public class WizardProjectile extends Projectile {
	public static final int FIRE_RATE = 15;

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 150;
		speed = 4;
		damage = 20;
		setSprite(Sprite.projectile_wizard);
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}

	public void update() {
		if (level.tileCollision((int) (x + nx), (int) (y + ny), 7, 5, 4)) {
			ParticleSpawner sp = new ParticleSpawner((int) x, (int) y, 44, 50,
					level);
			level.add(sp);
			remove();
		}
		move();
		if (distance() > range) {
			remove();
		}
	}

	public void render(Screen sc) {
		if (!this.isRemoved()) {
			sc.renderProjectile((int) x - 12, (int) y - 2, this);
		}
	}

	protected void move() {

		x += nx;
		y += ny;

	}

	private double distance() {
		double dist = 0;
		dist = Math.sqrt((xOrigin - x) * ((xOrigin - x))
				+ ((yOrigin - y) * (yOrigin - y)));
		return dist;

	}
}
