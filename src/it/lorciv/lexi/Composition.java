package it.lorciv.lexi;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Composition implements Glyph, Subject {
	
	private Observer observer;
	
	private List<Glyph> glyphs = new ArrayList<Glyph>();
	private Glyph root = new Column();

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
		
		root = new Column();
		Row curRow = null;
		
		for (int i = 0; i < glyphs.size(); i++) {
			if (i % 40 == 0) {
				curRow = new Row();
				root.add(curRow);
			}
			curRow.add(glyphs.get(i));
		}
		
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
