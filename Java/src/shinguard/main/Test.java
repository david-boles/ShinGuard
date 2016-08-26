package shinguard.main;

import shinguard.main.math.Line;
import shinguard.main.math.Point;

public class Test {
	public static void main(String[] args) {
		Point a = new Point(1, 2);
		Point b = new Point(2, 4);
		Point c = new Point(3, 16);
		
		System.out.println(c.getDistanceToLine(new Line(a, b)));
	}
}
