package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

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
		g.setColor(Color.BLACK);
		g.drawOval(loc.getX(), loc.getY(), rad, rad);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX()+rad, loc.getY()+rad));
	}
	
	@Override
	public void append(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}
	
	@Override
	public void save(Writer out) throws IOException {
		out.write("{");
		out.write("\"type\":\"circle\",");
		out.write("\"value\":");
		out.write(String.format("{\"rad\":%d}", rad));
		out.write("}");
	}

}
