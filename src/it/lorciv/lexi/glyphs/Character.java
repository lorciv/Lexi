package it.lorciv.lexi.glyphs;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;

import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Rect;

public class Character implements Glyph {

	private char value;

	public Character(char value) {
		this.value = value;
	}

	@Override
	public void draw(Graphics g, Point loc) {
		g.setColor(Color.BLACK);
		g.setFont(new Font("Monospaced", Font.PLAIN, 30));
		g.drawString(""+value, loc.getX(), loc.getY()+30);
	}

	@Override
	public Rect bounds(Point loc) {
		return new Rect(loc, new Point(loc.getX() + 30, loc.getY() + 30));
	}

	@Override
	public void append(Glyph child) {
		throw new UnsupportedOperationException("not a composite");
	}

	@Override
	public void save(Writer out) throws IOException {
		out.write(String.format("{\"type\": \"character\", \"value\": \"%c\"}", value));
	}

}
