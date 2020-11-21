package it.lorciv.lexi.view;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import it.lorciv.lexi.Composition;
import it.lorciv.lexi.Glyph;
import it.lorciv.lexi.Observer;
import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class GlyphPanel extends JPanel implements Observer {
	
	private static final long serialVersionUID = 1L;
	
	private Composition glyph;
	
	public GlyphPanel(Composition glyph) {
		this.glyph = glyph;
		this.glyph.attach(this);
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

	@Override
	public void update() {
		this.repaint();
	}

}
