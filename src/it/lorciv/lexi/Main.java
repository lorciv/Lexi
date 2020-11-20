package it.lorciv.lexi;

import it.lorciv.lexi.geom.Point;
import it.lorciv.lexi.geom.Rect;

public class Main {
	
	public static void main(String[] args) {
		
		Point p1 = new Point(2, 3);
		Point p2 = new Point(5, 8);
		
		Rect r = new Rect(p1, p2);
		
		System.out.println(r);
		System.out.println(r.getWidth());
		System.out.println(r.getHeight());
		System.out.println(r.intersects(new Point(4, 4)));
		System.out.println(r.intersects(new Point(4, 12)));
		
		Rect r2 = new Rect(p2, p1);
		System.out.println(r2);
		
	}

}
