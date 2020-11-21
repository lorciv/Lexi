package it.lorciv.lexi;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Composition implements Glyph, Subject {
	
	private Observer observer;
	
	private Compositor compositor;
	private List<Glyph> glyphs;
	private Glyph root;
	
	public Composition(Compositor compositor) {
		this.compositor = compositor;
		this.glyphs = new ArrayList<Glyph>();
		this.root = compositor.compose(glyphs);
	}

	@Override
	public void draw(Graphics g, Point loc) {
		root.draw(g, loc);
	}

	@Override
	public Rect bounds(Point loc) {
		return root.bounds(loc);
	}

	@Override
	public void add(Glyph child) {
		glyphs.add(child);
		root = compositor.compose(glyphs);
		notifyObservers();
	}

	@Override
	public void attach(Observer o) {
		this.observer = o;
	}

	@Override
	public void detach(Observer o) {
		this.observer = null;
	}

	@Override
	public void notifyObservers() {
		if (this.observer == null) {
			return;
		}
		observer.update();
	}

}
