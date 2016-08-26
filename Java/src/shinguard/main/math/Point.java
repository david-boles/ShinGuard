package shinguard.main.math;

public class Point {
	double x;
	double y;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getDistanceToPoint(Point point) {
		return Math.sqrt(Math.pow(point.getX() - this.getX(), 2) + Math.pow(point.getY() - this.getY(), 2));
	}
	
	public double getDistanceToLine(Line line) {
		Line perpLine = line.getPerpendicular(this);
		Point intersection = line.getIntersection(perpLine);
		return this.getDistanceToPoint(intersection);
	}
}
