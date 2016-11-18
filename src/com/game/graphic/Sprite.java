package com.game.graphic;

public class Sprite {
	public int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);

	// spawn sprite
	public static Sprite spawn_grass = new Sprite(16, 0, 2, SpriteSheet.tiles);
	public static Sprite spawn_hedge = new Sprite(16, 2, 1, SpriteSheet.tiles);
	public static Sprite spawn_water = new Sprite(16, 5, 2, SpriteSheet.tiles);
	public static Sprite spawn_wall1 = new Sprite(16, 2, 2, SpriteSheet.tiles);
	public static Sprite spawn_wall2 = new Sprite(16, 2, 3, SpriteSheet.tiles);
	public static Sprite spawn_floor = new Sprite(16, 4, 2, SpriteSheet.tiles);
	// end spawn sprite
	public static Sprite projectile_wizard = new Sprite(16, 3, 0,
			SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x1B87E0);

	// player sprite
	public static Sprite player_forward = new Sprite(32, 0, 5,
			SpriteSheet.tiles);
	public static Sprite player_forward1 = new Sprite(32, 0, 6,
			SpriteSheet.tiles);
	public static Sprite player_forward2 = new Sprite(32, 0, 7,
			SpriteSheet.tiles);
	public static Sprite player_back = new Sprite(32, 2, 5, SpriteSheet.tiles);
	public static Sprite player_back1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	public static Sprite player_back2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	// end player sprite
	public static Sprite player_left = new Sprite(32, 3, 5, SpriteSheet.tiles);
	public static Sprite player_left1 = new Sprite(32, 3, 6, SpriteSheet.tiles);
	public static Sprite player_left2 = new Sprite(32, 3, 7, SpriteSheet.tiles);

	public static Sprite player_right = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite player_right1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite player_right2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	private int width, height;
	// Particles
	public static Sprite particle_normal = new Sprite(3, 0xAAAAAA);

	public Sprite(int size, int colour) {
		SIZE = size;
		this.setWidth(size);
		this.setHeight(size);
		pixels = new int[size * size];
		setColour(colour);
	}

	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.setWidth(width);
		this.setHeight(height);
		pixels = new int[width * height];
		setColour(colour);
	}

	private void setColour(int colour) {
		// TODO Auto-generated method stub
		for (int i = 0; i < width * height; i++) {
			pixels[i] = colour;
		}
	}

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.setWidth(size);
		this.setHeight(size);
		this.sheet = sheet;
		load();

	}

	private void load() {
		// TODO Auto-generated method stub
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y)
						* sheet.SIZE];
			}
		}
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
