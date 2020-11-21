package it.lorciv.lexi;

import java.util.List;

public class CountCompositor implements Compositor {
	
	private int cols;
	
	public CountCompositor(int cols) {
		this.cols = cols;
	}

	@Override
	public Glyph compose(List<Glyph> glyphs) {
		Glyph root = new Column();
		Glyph row = null;
		
		for (int i = 0; i < glyphs.size(); i++) {
			if (i % cols == 0) {
				row = new Row();
				root.add(row);
			}
			row.add(glyphs.get(i));
		}
		
		return root;
	}

}
