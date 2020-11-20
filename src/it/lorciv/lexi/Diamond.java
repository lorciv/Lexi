package it.lorciv.lexi;

import java.awt.Color;
import java.awt.Graphics;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Diamond implements Glyph {

	private int width, height;

	public Diamond(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g, Point loc) {
		Rect bounds = bounds(loc);
		g.setColor(Color.RED);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
		
		int x = loc.getX();
		int y = loc.getY();
		int[] xPoints = {x+width/2, x+width, x+width/2, x};
		int[] yPoints = {y, y+height/2, y+height, y+height/2};
		
		g.setColor(Color.BLACK);
		g.drawPolygon(xPoints, yPoints, 4);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX() + width, loc.getY() + height));
	}

	@Override
	public void add(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}

}
