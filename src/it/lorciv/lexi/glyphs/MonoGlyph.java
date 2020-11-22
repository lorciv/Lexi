package it.lorciv.lexi.glyphs;

import java.awt.Graphics;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public abstract class MonoGlyph implements Glyph {
	
	protected Glyph component;
	
	protected MonoGlyph(Glyph component) {
		this.component = component;
	}
	
	public void draw(Graphics g, Point loc) {
		component.draw(g, loc);
	}

	public Rect bounds(Point loc) {
		return component.bounds(loc);
	}

	// boolean intersects(Point target);

	// void position(Point target);

	public void append(Glyph child) {
		component.append(child);
	}

	// void remove(Glyph child);

}
