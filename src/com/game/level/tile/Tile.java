package com.game.level.tile;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.level.tile.spawn_level.SpawnFloorTile;
import com.game.level.tile.spawn_level.SpawnGrassTile;
import com.game.level.tile.spawn_level.SpawnHedgeTile;
import com.game.level.tile.spawn_level.SpawnWallTile;
import com.game.level.tile.spawn_level.SpawnWaterTile;

public class Tile {
	public int x, y;
	public Sprite sprite;
	/* public static Tile grass = new GrassTile(Sprite.grass); */
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	public static Tile spawnFlower = new FlowerTile(Sprite.flower);
	public static Tile spawnRock = new RockTile(Sprite.rock);
	public static Tile spawnGrass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawnHedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawnWater = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawnWall1 = new SpawnWallTile(Sprite.spawn_wall1);
	public static Tile spawnWall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawnFloor = new SpawnFloorTile(Sprite.spawn_floor);

	public static final int grass_color = 0xff00ff00;
	public static final int hedge_color = 0xff808080;
	public static final int water_color = 0xff5E5CE0;
	public static final int wall1_color = 0xffE1D0C5;
	public static final int wall2_color = 0xffE0596B;
	public static final int floor_color = 0xff160900;
	public static final int flower_color = 0xffffff00;
	public static final int rock_color = 0xff7f7f00;
	public static final int spawn_position = 0xff00ffff;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

	public boolean breakable() {
		return false;
	}
}
