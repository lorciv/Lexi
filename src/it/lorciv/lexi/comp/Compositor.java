package it.lorciv.lexi.comp;

import java.util.List;

import it.lorciv.lexi.glyphs.Glyph;

public interface Compositor {
	
	Glyph compose(List<Glyph> glyphs, int position);

}
