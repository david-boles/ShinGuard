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
	
	public Line getIntersectingLine(double slope) {
		double newM;
		double newB;
		
		newM = slope;
		newB = -((newM * this.getX()) - this.getY());
		
		return new Line(newM, newB);
	}
	
	public double getDistanceToLineAlongSlope(Line line, double slope) {
		Line intLine = this.getIntersectingLine(slope);
		Point intersection = line.getIntersection(intLine);
		return this.getDistanceToPoint(intersection);
	}
}
