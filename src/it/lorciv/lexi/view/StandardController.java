package it.lorciv.lexi.view;

import it.lorciv.lexi.Document;
import it.lorciv.lexi.glyphs.Character;
import it.lorciv.lexi.util.Point;

public class StandardController implements Controller {

	private Document doc;
	
	public StandardController(Document doc) {
		this.doc = doc;
	}
	
	@Override
	public void handleKey(char c) {
		System.out.println("adding char '" + c + "'");
		doc.add(new Character(c));
	}

	@Override
	public void handleMouse(Point loc) {
		System.out.println("click at " + loc);
	}

	@Override
	public void handleMove(String dir) {
		switch (dir) {
		case "left":
			doc.cursorLeft();
			break;
		case "right":
			doc.cursorRight();
			break;
		}
	}

	@Override
	public void handleBack() {
		doc.del();
	}

}
