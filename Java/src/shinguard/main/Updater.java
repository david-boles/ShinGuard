package shinguard.main;

public class Updater {

	public static void main(String[] args) {
		Process p;
		try {
			p = Runtime.getRuntime().exec("git reset --hard origin/master");
	        p.waitFor();
	        p = Runtime.getRuntime().exec("java -jar Start.jar");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
