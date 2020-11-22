package it.lorciv.lexi.comp;

import java.util.List;

import it.lorciv.lexi.glyphs.Column;
import it.lorciv.lexi.glyphs.Cursor;
import it.lorciv.lexi.glyphs.Glyph;
import it.lorciv.lexi.glyphs.Pilcrow;
import it.lorciv.lexi.glyphs.Row;
import it.lorciv.lexi.util.Point;

public class WidthCompositor implements Compositor {

	private int limit;
	
	public WidthCompositor(int width) {
		this.limit = width;
	}
	
	@Override
	public Glyph compose(List<Glyph> glyphs, int position) {
		Glyph root = new Column();
		Glyph row = new Row();
		
		for (int i = 0; i < glyphs.size(); i++) {
			Glyph g = glyphs.get(i);
			
			int rowWidth = row.bounds(new Point(0, 0)).getWidth();
			int glyphWidth = g.bounds(new Point(0, 0)).getWidth();
			if (rowWidth + glyphWidth > limit) {
				root.append(row);
				row = new Row();
			}
			
			if (i == position) {
				g = new Cursor(g);
			}
			
			row.append(g);
		}
		
		Glyph last = new Pilcrow();
		if (position == glyphs.size()) {
			last = new Cursor(last);
		}
		row.append(last);
		root.append(row);
		return root;
	}

}
