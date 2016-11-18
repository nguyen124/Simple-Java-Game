package com.game.rain.entity.particle.spawner;

import java.util.ArrayList;

import com.game.level.Level;
import com.game.rain.entity.Entity;
import com.game.rain.entity.particle.Particle;

public class Spawner extends Entity {
	private ArrayList<Entity> entities = new ArrayList<Entity>();

	public enum Type {
		MOB, PARTICLE;
	}

	private Type type;

	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}
}
