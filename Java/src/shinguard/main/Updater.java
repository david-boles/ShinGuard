package shinguard.main;

public class Updater {

	public static void main(String[] args) {
		Process p;
		try {
			p = Runtime.getRuntime().exec("git pull");
	        p.waitFor();
	        
	        p = Runtime.getRuntime().exec("java -jar Start.jar");
	        p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
