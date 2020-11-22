package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

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
	public void append(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}
	
	@Override
	public void save(Writer out) throws IOException {
		out.write("{\"type\": \"rectangle\"}");
	}

}
