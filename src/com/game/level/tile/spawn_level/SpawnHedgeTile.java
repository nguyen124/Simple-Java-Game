package com.game.level.tile.spawn_level;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
		// TODO Auto-generated constructor stub
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

	public boolean solid() {
		return false;
	}

	public boolean breakble() {
		return true;
	}
}
