package it.lorciv.lexi;

import java.awt.Graphics;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import it.lorciv.lexi.comp.Compositor;
import it.lorciv.lexi.glyphs.Glyph;
import it.lorciv.lexi.util.Observer;
import it.lorciv.lexi.util.Point;
import it.lorciv.lexi.util.Subject;

public class Document implements Subject {
	
	private Compositor compositor;
	private List<Glyph> glyphs;
	private int position;
	private Glyph root;
	
	private List<Observer> observers = new ArrayList<Observer>();
	
	public Document(Compositor compositor) {
		this.compositor = compositor;
		this.glyphs = new ArrayList<Glyph>();
		this.position = 0;
		this.root = compositor.compose(glyphs, position);
	}
	
	public void add(Glyph child) {
		glyphs.add(position, child);
		position++;
		root = compositor.compose(glyphs, position);
		notifyObservers();
	}
	
	public void draw(Graphics g, Point loc) {
		root.draw(g, loc);
	}
	
	public int getWidth() {
		return root.bounds(new Point(0, 0)).getWidth();
	}
	
	public int getHeight() {
		return root.bounds(new Point(0, 0)).getHeight();
	}
	
	public void cursorLeft() {
		if (position <= 0) {
			position = 0;
			return;
		}
		position--;
		System.out.println("cursor moved to " + position);
		this.root = compositor.compose(glyphs, position);
		notifyObservers();
	}
	
	public void cursorRight() {
		int max = glyphs.size();
		if (position >= max) {
			position = max;
			return;
		}
		position++;
		System.out.println("cursor moved to " + position);
		this.root = compositor.compose(glyphs, position);
		notifyObservers();
		
	}
	
	public void save(Writer out) throws IOException {
		out.write("{");
		out.write("\"title\":\"" + "Lettera per Babbo Natale" + "\",");
		out.write("\"author\":\"" + "Sempronio Verdi" + "\",");
		
		out.write("\"glyphs\":[");
		String sep = "";
		for (Glyph g : glyphs) {
			out.write(sep);
			g.save(out);
			if (sep.isEmpty()) {
				sep = ",";
			}
		}
		out.write("]");
		out.write("}");
		out.flush();
	}

	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.update();
		}
	}

}
