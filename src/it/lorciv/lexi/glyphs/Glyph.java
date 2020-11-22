package it.lorciv.lexi.glyphs;

import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public interface Glyph {

	void draw(Graphics g, Point loc);

	Rect bounds(Point loc);

	//boolean intersects(Point target);

	//void position(Point target);

	void append(Glyph child);

	//void remove(Glyph child);
	
	void save(Writer out) throws IOException;

}
