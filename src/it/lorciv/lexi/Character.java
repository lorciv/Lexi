package it.lorciv.lexi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Character implements Glyph {

	private char value;

	public Character(char value) {
		this.value = value;
	}

	@Override
	public void draw(Graphics g, Point loc) {
		Rect bounds = bounds(loc);
		g.setColor(Color.RED);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.PLAIN, 30));
		g.drawString(""+value, loc.getX(), loc.getY()+30);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX() + 30, loc.getY() + 30));
	}

	@Override
	public void add(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}

}
