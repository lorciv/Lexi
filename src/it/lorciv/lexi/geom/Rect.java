package it.lorciv.lexi.geom;

public class Rect {

	private Point origin, extent;

	public Rect(Point origin, Point extent) {
		if (extent.getX() < origin.getX()) {
			throw new IllegalArgumentException("extent left to origin");
		}
		if (extent.getY() < origin.getY()) {
			throw new IllegalArgumentException("extent over origin");
		}
		this.origin = origin;
		this.extent = extent;
	}

	public Point getOrigin() {
		return origin;
	}

	public Point getExtent() {
		return extent;
	}

	public int getWidth() {
		return extent.getX() - origin.getX();
	}

	public int getHeight() {
		return extent.getY() - origin.getY();
	}

	public boolean intersects(Point point) {
		return point.getX() >= origin.getX() && point.getX() <= extent.getX() && point.getY() >= origin.getY()
				&& point.getY() <= extent.getY();
	}
	
	@Override
	public int hashCode() {
		return origin.hashCode() + extent.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Rect)) {
			return false;
		}
		Rect that = (Rect) obj;
		return origin.equals(that.origin) && extent.equals(that.extent);
	}

	@Override
	public String toString() {
		return String.format("rect from %s to %s", origin, extent);
	}
}
