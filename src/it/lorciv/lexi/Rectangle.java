package it.lorciv.lexi;

import java.awt.Color;
import java.awt.Graphics;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Rectangle implements Glyph {
	
	private int width, height;
	
	public Rectangle(int width, int height) {
		System.out.println("creating Rectangle " + width + "x" + height);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g, Point loc) {
		g.setColor(Color.BLACK);
		g.drawRect(loc.getX(), loc.getY(), width, height);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX()+width, loc.getY()+height));
	}
	
	@Override
	public void add(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}

}
