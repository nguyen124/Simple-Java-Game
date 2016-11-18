package com.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.game.graphic.Screen;
import com.game.graphic.Sprite;
import com.game.input.Keyboard;
import com.game.input.Mouse;
import com.game.level.Level;
import com.game.level.RandomLevel;
import com.game.level.SpawnLevel;
import com.game.level.TileCoordinate;
import com.game.rain.entity.mob.Player;

public class Game extends Canvas implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = width * 9 / 16;
	public static int scale = 3;
	private Thread thread;
	private boolean running = false;
	private JFrame frame;
	private BufferedImage image = new BufferedImage(width, height,
			BufferedImage.TYPE_INT_RGB);

	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer())
			.getData();

	private Screen screen;
	private Keyboard keyboard;
	private Mouse mouse;
	private Level level;
	private Player player;
	// int xOffset = 0, yOffset = 0;
	public static int TILE_SIZE = 64;

	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		screen = new Screen(width, height);
		keyboard = new Keyboard();
		mouse = new Mouse();
		level = new SpawnLevel("/textures/level.png");
		TileCoordinate coordinate = new TileCoordinate(19, 62);
		player = new Player(coordinate.getX(), coordinate.getY(), keyboard);
		player.init(level);
		frame = new JFrame();
		addKeyListener(keyboard);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
		frame.setResizable(false);
		frame.setTitle("Rain");
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static int getWindowWidth() {
		return width * scale;
	}

	/*
	 * public static void setWidth(int width) { Game.width = width; }
	 */

	public static int getWindowHeight() {
		return height * scale;
	}

	/*
	 * public static void setHeight(int height) { Game.height = height; }
	 */

	public synchronized void start() {
		thread = new Thread(this, "Game");
		thread.start();
		running = true;
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game game = new Game();
		game.start();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		// boolean c = false;
		int frames = 0;
		int updates = 0;
		// requestFocus();
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle("Rain - " + updates + " ups, " + frames + "fps");
				updates = 0;
				frames = 0;
			}

		}
	}

	private void update() {
		// TODO Auto-generated method stub
		keyboard.update();
		/*
		 * if (keyboard.up) yOffset--; if (keyboard.down) yOffset++; if
		 * (keyboard.left) xOffset--; if (keyboard.right) xOffset++;
		 */
		player.update();
		level.update();
	}

	private void render() {
		// TODO Auto-generated method stub
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		screen.clear();
		// screen.render(xOffset, yOffset);
		int xScroll = player.x - screen.getWidth() / 2;
		int yScroll = player.y - screen.getHeight() / 2;
		level.render(xScroll, yScroll, screen);
		player.render(screen);

		Sprite sprite = new Sprite(60, height, 0x000000);
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int xRan = rd.nextInt(20);
			int yRan = rd.nextInt(20);
			screen.renderSprite(width - 60 + xRan, 50 + yRan, sprite, true);
		}
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		// g.fillRect(Mouse.getX(), Mouse.getY(), 64, 64);
		// g.setColor(Color.WHITE);
		// g.setFont(new Font("Verdana", 0, 50));
		// g.drawString("X: " + player.x + ", Y: " + player.y, 200, 300);
		g.dispose();
		bs.show();
	}

}
