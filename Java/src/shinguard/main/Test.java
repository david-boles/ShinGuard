package shinguard.main;

import shinguard.main.math.Point;

public class Test {
	public static void main(String[] args) {
		Point c0 = new Point(600, 400);
		Point c1 = new Point(575, 500);
		Point c2 = new Point(400, 275);
		Point p = new Point(550, 450);
		
		PositionMapper map = new PositionMapper(c0, c1, c2);
		Point pMapped = map.map(p);
		System.out.println("X: " + pMapped.getX());
		System.out.println("Y: " + pMapped.getY());
	}
}
