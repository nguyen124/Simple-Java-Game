package com.game.level;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.game.level.tile.Tile;

public class SpawnLevel extends Level {

	public SpawnLevel(String path) {
		super(path);
		// TODO Auto-generated constructor stub
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class
					.getResource(path));
			int w = image.getWidth();
			width = w;
			int h = image.getHeight();
			height = h;
			// tiles = new Tile[w * h];
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generateLevel() {
		/*
		 * for (int i = 0; i < tiles.length; i++) { Color color = new
		 * Color(tiles[i]); int red = color.getRed(); int green =
		 * color.getGreen(); int blue = color.getBlue(); if (red == 0 && green
		 * == 255 & blue == 0) { // tiles[i] = Tile.grass; } else if (red == 255
		 * && green == 255 & blue == 0) { // tiles[i] = Tile.flower; } else if
		 * (red == 127 && green == 127 & blue == 0) { // tiles[i] = Tile.rock; }
		 * }
		 */}
}
