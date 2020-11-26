package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Cursor implements Glyph {
	
	private int height = 30;
	
	@Override
	public void draw(Graphics g, Point loc) {
		g.setColor(Color.BLACK);
		g.drawLine(loc.getX(), loc.getY(), loc.getX(), loc.getY() + height);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX(), loc.getY() + height));
	}

	@Override
	public void append(Glyph child) {
		throw new UnsupportedOperationException("not a composite"); 
	}
	
	@Override
	public void save(Writer out) throws IOException {
		// noop
	}

}
