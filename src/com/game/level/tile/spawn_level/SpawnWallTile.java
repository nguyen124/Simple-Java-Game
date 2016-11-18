package com.game.level.tile.spawn_level;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.level.tile.Tile;

public class SpawnWallTile extends Tile {

	public SpawnWallTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return true;
	}

	public boolean breakble() {
		return true;
	}
}
