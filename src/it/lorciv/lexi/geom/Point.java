package it.lorciv.lexi.geom;

public class Point {
	
	private int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point)) {
			return false;
		}
		Point that = (Point) obj;
		return x == that.x && y == that.y;
	}

	@Override
	public int hashCode() {
		return x + y;
	}
	
	@Override
	public String toString() {
		return String.format("(%d, %d)", x, y);
	}

}
