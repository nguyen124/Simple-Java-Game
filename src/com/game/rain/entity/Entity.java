package com.game.rain.entity;

import java.util.Random;

import com.game.graphic.Screen;
import com.game.level.Level;

public abstract class Entity {
	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected final Random random = new Random();

	public void update() {

	}

	public void render(Screen sc) {

	}

	public void remove() {
		setRemoved(true);
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}

	public void init(Level level) {
		this.level = level;
	}
}
