package com.game.level;

import java.util.ArrayList;

import com.game.graphic.Screen;
import com.game.level.tile.Tile;
import com.game.rain.entity.Entity;
import com.game.rain.entity.particle.Particle;
import com.game.rain.entity.particle.spawner.Spawner;

public class Level {
	protected int width;
	protected int height;
	protected int[] intTiles;
	protected int[] tiles;
	public static Level spawn = new Level("/textures/spawn_level.png");
	private ArrayList<Entity> entities = new ArrayList<Entity>();

	// protected Tile[] tiles;

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();

	}

	public void add(Entity e) {
		e.init(this);
		entities.add(e);

	}

	protected void loadLevel(String path) {
	}

	public void time() {

	}

	public boolean tileCollision(int x, int y, int size, int xOffset,
			int yOffset) {
		boolean solid = false;

		for (int corner = 0; corner < 4; corner++) {
			double xt = (x + corner % 2 * size + xOffset) >> 4;
			double yt = (y + corner / 2 * size + yOffset) >> 4;
			if (getTile((int) xt, (int) yt).solid()) {
				solid = true;
			}
		}

		return solid;
	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved()) {
				entities.remove(i);
			}
		}
	}

	public void render(int xScroll, int yScroll, Screen sc) {
		sc.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + sc.getWidth() + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + sc.getHeight() + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, sc);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(sc);
		}
	}

	// Grass 0xff00ff00
	// Flower 0xffffff00
	// Rock 0xff7f7f00
	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.voidTile;
		switch (tiles[x + y * width]) {
		case Tile.grass_color:
			return Tile.spawnGrass;
		case Tile.floor_color:
			return Tile.spawnFloor;
		case Tile.hedge_color:
			return Tile.spawnHedge;
		case Tile.wall1_color:
			return Tile.spawnWall1;
		case Tile.wall2_color:
			return Tile.spawnWall2;
		case Tile.water_color:
			return Tile.spawnWater;
		case Tile.flower_color:
			return Tile.spawnFlower;
		case Tile.rock_color:
			return Tile.spawnRock;

		}

		/*
		 * if (tiles[x + y * width] == Tile.) return Tile.flower; if (tiles[x +
		 * y * width] == 0xff7f7f00) return Tile.rock;
		 */
		return Tile.voidTile;
	}

	protected void generateLevel() {

	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
