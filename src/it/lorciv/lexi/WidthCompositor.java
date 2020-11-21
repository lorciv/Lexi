package it.lorciv.lexi;

import java.util.List;

import it.lorciv.lexi.geom.Point;

public class WidthCompositor implements Compositor {

	private int limit;
	
	public WidthCompositor(int width) {
		this.limit = width;
	}
	
	@Override
	public Glyph compose(List<Glyph> glyphs) {
		Glyph root = new Column();
		Glyph row = new Row();
		
		for (Glyph g : glyphs) {
			int rowWidth = row.bounds(new Point(0, 0)).getWidth();
			int glyphWidth = g.bounds(new Point(0, 0)).getWidth();
			if (rowWidth + glyphWidth > limit) {
				root.add(row);
				row = new Row();
			}
			row.add(g);
		}
		
		root.add(row);
		return root;
	}

}
