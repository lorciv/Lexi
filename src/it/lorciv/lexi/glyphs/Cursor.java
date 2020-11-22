package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Cursor extends MonoGlyph {

	public Cursor(Glyph component) {
		super(component);
	}
	
	@Override
	public void draw(Graphics g, Point loc) {
		super.draw(g, loc);
		
		Rect bounds = this.component.bounds(loc);
		g.setColor(Color.BLACK);
		g.drawLine(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getOrigin().getX(), bounds.getExtent().getY());
	}
	
	@Override
	public void save(Writer out) throws IOException {
		// noop
	}

}
