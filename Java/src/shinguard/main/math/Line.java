package shinguard.main.math;

public class Line {
	double m;
	double b;
	
	public Line() {
		this.m = 0;
		this.b = 0;
	}
	
	public Line(double m, double b) {
		this.m = m;
		this.b = b;
	}
	
	public Line(Point a, Point b) {
		this.m = (b.getY() - a.getY()) / (b.getX() - a.getX());
		this.b = -((this.m * a.getX()) - a.getY());
	}
	
	public double getM() {
		return m;
	}
	
	public double getB() {
		return b;
	}
	
	public void setM(double m) {
		this.m = m;
	}
	
	public void setB(double b) {
		this.b = b;
	}
	
	public Line getPerpendicular(Point intersected) {
		double newM;
		double newB;
		
		newM = -(1/this.m);
		newB = -((newM * intersected.getX()) - intersected.getY());
		
		return new Line(newM, newB);
	}
	
	public Point getIntersection(Line line) {
		double pointX;
		double pointY;
		
		pointX = (this.getB() - line.getB()) / (line.getM() - this.getM());
		pointY = (line.getM() * pointX) + line.getB();
		
		return new Point(pointX, pointY);
	}
}
