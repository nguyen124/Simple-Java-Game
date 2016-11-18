package com.game.rain.entity.mob;

import com.game.Game;
import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.input.Keyboard;
import com.game.input.Mouse;
import com.game.rain.entity.projectile.Projectile;
import com.game.rain.entity.projectile.WizardProjectile;

public class Player extends Mob {
	private Keyboard input;
	private Sprite sprite;
	int animate = 0;
	private boolean walking = false;

	private int fireRate = 0;

	public Player(int x, int y, Keyboard keyboard) {
		this.x = x;
		this.y = y;
		input = keyboard;
		sprite = Sprite.player_forward;
		fireRate = WizardProjectile.FIRE_RATE;
	}

	public Player(Keyboard keyboard) {
		this.input = keyboard;
		sprite = Sprite.player_forward;
	}

	public void update() {
		if (fireRate > 0)
			fireRate--;
		animate++;
		animate = animate % 7500;
		int xa = 0;
		int ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		updateShooting();
		clear();
	}

	private void clear() {
		for (int i = 0; i < projectiles.size(); i++) {
			Projectile p = projectiles.get(i);
			if (p.isRemoved()) {
				projectiles.remove(i);
			}
		}

	}

	public void updateShooting() {
		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double shootDir = Math.atan2(dy, dx);
			shoot(x, y, shootDir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	public void render(Screen sc) {
		int xx = x - 16;
		int yy = y - 16;
		if (dir == 0) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_forward1;
				} else {
					sprite = Sprite.player_forward2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.player_right;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_right1;
				} else {
					sprite = Sprite.player_right2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_back1;
				} else {
					sprite = Sprite.player_back2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_left;
			if (walking) {
				if (animate % 20 > 10) {
					sprite = Sprite.player_left1;
				} else {
					sprite = Sprite.player_left2;
				}
			}
		}
		sc.renderPlayer(xx, yy, sprite);

	}
}
