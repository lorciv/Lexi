package it.lorciv.lexi.contr;

import it.lorciv.lexi.Character;
import it.lorciv.lexi.Glyph;

public class StandardController implements Controller {

	private Glyph doc;
	
	public StandardController(Glyph doc) {
		this.doc = doc;
	}
	
	@Override
	public void handleKey(char c) {
		System.out.println("adding char '" + c + "'");
		doc.add(new Character(c));
	}

}
