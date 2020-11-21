package it.lorciv.lexi;

import java.util.List;

public interface Compositor {
	
	Glyph compose(List<Glyph> glyphs);

}
