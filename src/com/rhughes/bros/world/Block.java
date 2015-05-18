package com.rhughes.bros.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.rhughes.bros.gfx.Sprite;

public class Block {
	
	private int x, y;
	private Sprite sprite;

	public Block(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		sprite.render(g, x, y);
	}
	
	public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getTop() {
        return new Rectangle(x + 4, y, 24, 4);
    }

    public Rectangle getBottom() {
        return new Rectangle(x + 4, y + 28, 24, 4);
    }

    public Rectangle getRight() {
        return new Rectangle(x, y, 4, 32);
    }

    public Rectangle getLeft() {
        return new Rectangle(x + 28, y, 4, 32);
    }
    
    public int getX()
    {return x;}
    
    public int getY()
    {return y;}

}
