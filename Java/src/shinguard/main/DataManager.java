package shinguard.main;

import java.util.ArrayList;

import shinguard.main.math.Point;

public class DataManager {
	static PositionMapper mapper;
	public static ArrayList<Integer> ids = new ArrayList<Integer>();
	public static ArrayList<ArrayList<Point>> points = new ArrayList<ArrayList<Point>>();
	
	public static void registerPosition(int idVal, double longVal, double latiVal) {
		if(mapper != null) {
			Point raw = new Point(longVal, latiVal);
			Point mapped = mapper.map(raw);
			addPoint(idVal, mapped);
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
