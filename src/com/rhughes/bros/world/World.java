package com.rhughes.bros.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.rhughes.bros.entities.Entity;
import com.rhughes.bros.entities.Player;
import com.rhughes.bros.libs.BlockLib;
import com.rhughes.bros.libs.Reference;

public class World {
	
	ArrayList<Entity> entities = new ArrayList<Entity>();
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	private int width;
	private int height;
	private int[] pixels;
	
	public World(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(Reference.SPRITE_LOCATION + path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		width = image.getWidth();
		height = image.getHeight();
		pixels = image.getRGB(0, 0, width, height, pixels, 0, width);
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				if(BlockLib.getFromId(pixels[x + y *width], x, y) != null) {
					blocks.add(BlockLib.getFromId(pixels[x + y * width], x, y));
					//System.out.println("block");
				}
			}
		}
		for(int i = 500; i > 500 - 128; i -= 64) {
			for(int j = 0; j < 25; j++) {
				if(BlockLib.getFromId(10, j*32, 250) != null) {
					blocks.add(BlockLib.getFromId(10, j*32 + i, i));
				}
			}
		}
	}
	
	public void render(Graphics g) {
		for(Block block : blocks)
			block.render(g);
		for(Entity ent : entities)
			ent.render(g);
	}
	
	public void tick() {
		for(Entity ent : entities)
			ent.tick();
	}
	
	public void addEntity (Entity ent) {
		entities.add(ent);
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public ArrayList<Block> getBlocks() {
		return blocks;
	}
	
	public void removeEntity(int index) {
		entities.remove(index);
	}
	
	public Player getPlayer() {
		for (Entity ent : entities)
			if(ent instanceof Player)
				return (Player)ent;
		return null;
	}
	public Block find(int x, int y){
		for (int i = 0; i < blocks.size(); i++){
			int x2 = blocks.get(i).getX();
			int y2 = blocks.get(i).getY();
			if (x > x2 && x < x2 + 32)
				if(y > y2 && y < y2 + 32)
					return blocks.get(i);
		}
		return null;
	}

}
