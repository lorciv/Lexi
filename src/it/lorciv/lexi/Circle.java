package it.lorciv.lexi;

import java.awt.Color;
import java.awt.Graphics;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Circle implements Glyph {

	private int rad;
	
	public Circle(int rad) {
		if (rad < 0) {
			throw new IllegalArgumentException("negative radius");
		}
		this.rad = rad;
	}

	@Override
	public void draw(Graphics g, Point loc) {
		Rect bounds = bounds(loc);
		g.setColor(Color.RED);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
		
		g.setColor(Color.BLACK);
		g.drawOval(loc.getX(), loc.getY(), rad, rad);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX()+rad, loc.getY()+rad));
	}
	
	@Override
	public void add(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}

}
