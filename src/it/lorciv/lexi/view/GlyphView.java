package it.lorciv.lexi.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import it.lorciv.lexi.Glyph;
import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class GlyphView extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private Glyph glyph;
	
	public GlyphView(Glyph glyph) {
		this.glyph = glyph;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		glyph.draw(g, new Point(0, 0));
	}
	
	@Override
	public Dimension getPreferredSize() {
		Rect b = glyph.bounds(new Point(0, 0));
		return new Dimension(b.getWidth(), b.getHeight());
	}

}
