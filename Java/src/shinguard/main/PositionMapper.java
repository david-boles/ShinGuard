package shinguard.main;

import shinguard.main.math.Line;
import shinguard.main.math.Point;

public class PositionMapper {
	Line xAxis;
	Line yAxis;
	boolean xAxisPointHigherPositive;
	boolean yAxisPointHigherPositive;
	double xAxisLength;
	double yAxisLength;
	
	//From center facing opponent, back left = cal0, back right = cal1, front left = cal2, origin = back left, lengthwise = y axis
	public PositionMapper(Point cal0, Point cal1, Point cal2) {
		this.xAxis = new Line(cal0, cal1);
		this.yAxis = new Line(cal0, cal2);
		this.xAxisPointHigherPositive = this.xAxis.getHigherOrIntersecting(cal2);
		this.yAxisPointHigherPositive = this.yAxis.getHigherOrIntersecting(cal1);
		this.xAxisLength = cal0.getDistanceToPoint(cal1);
		this.yAxisLength = cal0.getDistanceToPoint(cal2);
	}
	
	public Point map(Point p) {
		//Distances
		double xDistance = p.getDistanceToLine(this.yAxis);
		double yDistance = p.getDistanceToLine(this.xAxis);
		
		//Inversion
		boolean pointHigherXAxis = this.xAxis.getHigherOrIntersecting(p);
		boolean pointHigherYAxis = this.yAxis.getHigherOrIntersecting(p);
		
		if(this.xAxisPointHigherPositive ^ pointHigherXAxis) {
			yDistance = yDistance * -1;
		}
		
		if(this.yAxisPointHigherPositive ^ pointHigherYAxis) {
			xDistance = xDistance * -1;
		}
		
		//Scaling
		xDistance = xDistance/this.xAxisLength;
		yDistance = yDistance/this.yAxisLength;
		
		return new Point(xDistance, yDistance);
	}
	
}
