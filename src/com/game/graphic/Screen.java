package com.game.graphic;

import java.util.Random;

import com.game.level.tile.Tile;
import com.game.rain.entity.projectile.Projectile;

public class Screen {
	private int width;
	private int height;
	public int[] pixels;
	public final int MAP_SIZE = 16;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	private Random random = new Random();
	int counter = 0;
	public int xOffset, yOffset;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Screen(int width, int height) {
		setWidth(width);
		setHeight(height);
		pixels = new int[width * height];
		for (int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}

	/*
	 * public void render(int xOffset, int yOffset) { for (int y = 0; y <
	 * height; y++) { int yp = y + yOffset; for (int x = 0; x < width; x++) {
	 * int xp = x + xOffset; int index = xp + yp * width; if (index >= 0 &&
	 * index < pixels.length) { pixels[xp + yp * width] = Sprite.grass.pixels[(x
	 * & MAP_SIZE_MASK) + (y & MAP_SIZE_MASK) * Sprite.grass.SIZE]; } } } }
	 */
	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if (fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for (int y = 0; y < sprite.getHeight(); y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.getWidth(); x++) {
				int xa = x + xp;
				if (xa < 0 || xa >= width || ya < 0 || ya >= height) {
					continue;
				}
				pixels[xa + ya * width] = sprite.pixels[x + y
						* sprite.getWidth()];
			}
		}
	}

	public void renderTile(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -sprite.SIZE || xa >= width || ya < 0 || ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.SIZE];
			}
		}
	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0
						|| ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y
						* tile.sprite.SIZE];
			}
		}
	}

	public void renderProjectile(int xp, int yp, Projectile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < tile.getSprite().SIZE; y++) {
			int ya = y + yp;
			for (int x = 0; x < tile.getSprite().SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.getSprite().SIZE || xa >= width || ya < 0
						|| ya >= height)
					break;
				if (xa < 0)
					xa = 0;
				int color = tile.getSprite().pixels[x + y
						* tile.getSprite().SIZE];
				if (color != 0xffff00ff) {
					pixels[xa + ya * width] = color;
				}
			}
		}
	}

	public void renderPlayer(int xp, int yp, Sprite player) {
		xp -= xOffset;
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = y + yp;
			for (int x = 0; x < 32; x++) {
				int xa = x + xp;
				if (xa < -32 || xa >= width || ya < 0 || ya >= height) {
					break;
				}
				if (xa < 0) {
					xa = 0;
				}
				int col = player.pixels[x + y * 32];
				if (col != 0xffff00ff) {
					pixels[xa + ya * width] = col;

				}
			}
		}
	}

	public void setOffset(int xOff, int yOff) {
		xOffset = xOff;
		yOffset = yOff;
	}
}
