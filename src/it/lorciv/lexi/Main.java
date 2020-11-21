package it.lorciv.lexi;

import java.awt.EventQueue;

import it.lorciv.lexi.contr.StandardController;
import it.lorciv.lexi.view.Window;

public class Main {
	
	public static void main(String[] args) {
		
		Composition doc = new Composition();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window win = new Window(doc);
					win.setController(new StandardController(doc));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
