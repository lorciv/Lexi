package it.lorciv.lexi.view;

import it.lorciv.lexi.util.Point;

public interface Controller {

	void handleKey(char c);
	
	void handleMove(String dir);
	
	void handleMouse(Point loc);
	
}
