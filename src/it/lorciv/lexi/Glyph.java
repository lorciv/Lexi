package it.lorciv.lexi;

import java.awt.Graphics;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public interface Glyph {

	public abstract void draw(Graphics g, Point loc);

	public abstract Rect bounds(Point loc);

	//boolean intersects(Point target);

	//void position(Point target);

	public abstract void add(Glyph child);

	//void remove(Glyph child);

}
