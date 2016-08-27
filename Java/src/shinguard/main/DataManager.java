package shinguard.main;

import java.util.ArrayList;

import shinguard.main.math.Point;

public class DataManager {
	static PositionMapper mapper;
	public static ArrayList<Integer> ids = new ArrayList<Integer>();
	public static ArrayList<ArrayList<Point>> points = new ArrayList<ArrayList<Point>>();
	
	public static void calibrateMapper(Point cal0, Point cal1, Point cal2) {
		ids = new ArrayList<Integer>();
		points = new ArrayList<ArrayList<Point>>();
		mapper = new PositionMapper(cal0, cal1, cal2);
	}
	
	public static void registerPosition(int idVal, double latiVal, double longVal) {
		if(mapper != null) {
			Point raw = new Point(longVal, latiVal);
			Point mapped = mapper.map(raw);
			addPoint(idVal, mapped);
			System.out.println(mapped.getX());
			System.out.println("Position added");
		}
	}
	
	static void addPoint(int id, Point point) {
		int idLoc = findID(id);
		if(idLoc == -1) {
			ids.add(id);
			points.add(new ArrayList<Point>());
			idLoc = ids.size()-1;
		}
		points.get(idLoc).add(point);
	}
	
	public static int findID(int id) {
		for(int i = 0; i < ids.size(); i++) {
			if(ids.get(i).equals(id)) return i;
		}
		return -1;
	}
}
