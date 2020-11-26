package it.lorciv.lexi.comp;

import java.awt.Color;
import java.util.List;

import it.lorciv.lexi.glyphs.Border;
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
	public Glyph compose(List<Glyph> glyphs, int cursorPos) {
		Glyph root = new Border(new Column(), Color.BLUE);
		Glyph row = new Row();
		
		for (int i = 0; i < glyphs.size(); i++) {
			Glyph g = glyphs.get(i);
			
			int rowWidth = row.bounds(new Point(0, 0)).getWidth();
			int glyphWidth = g.bounds(new Point(0, 0)).getWidth();
			if (rowWidth + glyphWidth > limit) {
				root.append(row);
				row = new Row();
			}
			
			if (i == cursorPos) {
				row.append(new Cursor());
			}
			
			row.append(g);
		}
		
		if (cursorPos == glyphs.size()) {
			row.append(new Cursor());
		}
		
		row.append(new Pilcrow());
		root.append(row);
		return root;
	}

}
