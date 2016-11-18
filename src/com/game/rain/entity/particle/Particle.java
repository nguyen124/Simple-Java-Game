package com.game.rain.entity.particle;

import java.util.ArrayList;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.rain.entity.Entity;

public class Particle extends Entity {

	private Sprite sprite;
	private int life;
	protected double xx, yy, zz, xa, ya, za;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + random.nextInt(50) - 25;
		sprite = Sprite.particle_normal;
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		zz = 20.0;
	}

	private int time = 0;

	public void update() {
		time++;
		if (time >= 7400) {
			time = 0;
		}
		if (time > life)
			remove();
		za -= 0.1;
		if (zz < 0) {
			zz = 0;
			za *= -0.55;
			xa *= 0.4;
			ya *= 0.4;
		}
		move(xx + xa, (yy + ya) + (zz + za));

	}

	private void move(double x, double y) {
		// TODO Auto-generated method stub
		if (collision(x, y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}

	public boolean collision(double x, double y) {
		boolean solid = false;

		for (int corner = 0; corner < 4; corner++) {
			double xt = (x + corner % 2 * 16) / 16;
			double yt = (y + corner / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (corner % 2 == 0) {
				ix = (int) Math.floor(xt);
			}
			if (corner / 2 == 0) {
				iy = (int) Math.floor(yt);
			}

			if (level.getTile(ix, iy).solid()) {
				solid = true;
			}
		}

		return solid;
	}

	public void render(Screen sc) {
		sc.renderSprite((int) xx, (int) yy, sprite, true);

	}
}
