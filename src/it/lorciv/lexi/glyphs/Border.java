package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Border extends MonoGlyph {
	
	private Color color;

	public Border(Glyph component) {
		this(component, Color.RED);
	}
	
	public Border(Glyph component, Color color) {
		super(component);
		this.color = color;
	}
	
	@Override
	public void draw(Graphics g, Point loc) {
		super.draw(g, loc);
		
		Rect bounds = this.component.bounds(loc);
		g.setColor(this.color);
		g.drawRect(bounds.getOrigin().getX(), bounds.getOrigin().getY(), bounds.getWidth(), bounds.getHeight());
	}
	
	@Override
	public void save(Writer out) throws IOException {
		out.write("{");
		out.write("{\"type\": \"border\", value: \"");
		this.component.save(out);
		out.write("\"");
		out.write("}");
	}

}
