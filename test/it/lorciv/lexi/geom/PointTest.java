package it.lorciv.lexi.geom;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class PointTest {
	
	private int[][] coords;
	
	@Before
	void initialize() {
		
		coords = new int[][] {
			{ 2, 3 },
			{ 4, 5 },
			{ 9, 4 }
		};
		
	}

	@Test
	void testGetters() {
		
		for (int[] coord : coords) {
			Point p = new Point(coord[0], coord[1]);
			assertEquals(p.getX(), coord[0]);
			assertEquals(p.getY(), coord[1]);
		}

	}

}
