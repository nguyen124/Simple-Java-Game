package com.game.rain.entity.mob;

import java.util.ArrayList;

import com.game.graphic.Sprite;
import com.game.rain.entity.Entity;
import com.game.rain.entity.particle.Particle;
import com.game.rain.entity.projectile.Projectile;
import com.game.rain.entity.projectile.WizardProjectile;

public abstract class Mob extends Entity {
	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;
	protected ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

	public void move(int xa, int ya) {

		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;
		if (!collision(xa, 0)) {
			x += xa;
		}
		if (!collision(0, ya)) {
			y += ya;
		} else {
			Particle p = new Particle(x, y, 50);
			level.add(p);
		}
	}

	protected void shoot(int x, int y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		// projectiles.add(p);
		level.add(p);
	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;

		for (int corner = 0; corner < 4; corner++) {
			int xt = ((x + xa) + corner % 2 * 14 - 8) / 16;
			int yt = ((y + ya) + corner / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid()) {
				solid = true;
			}
		}

		return solid;
	}

	public void render() {

	}
}
