package it.lorciv.lexi;

import java.awt.EventQueue;

import it.lorciv.lexi.comp.WidthCompositor;
import it.lorciv.lexi.view.Controller;
import it.lorciv.lexi.view.StandardController;
import it.lorciv.lexi.view.Window;

public class Main {
	
	public static void main(String[] args) {
//		System.setProperty("apple.laf.useScreenMenuBar", "true");
		
		Document doc = new Document(new WidthCompositor(450));
		Controller contr = new StandardController(doc);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Window(doc, contr);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

}
