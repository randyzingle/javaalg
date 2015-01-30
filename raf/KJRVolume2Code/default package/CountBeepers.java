import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import static com.jbergin.robot.Direction.*;

public class CountBeepers {

	/**
	 * @param args
	 */

//	BlockWalker [] foo = {new BlockWalker(1, 1, North, 0), new BlockWalker(2, 2, East, 0)};
	
	public static int countBeepers(String filename) throws IOException {
		int result = 0;
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String oneLine;
		while ((oneLine = input.readLine()) != null) {
			StringTokenizer tokens = new StringTokenizer(oneLine);
			if (tokens.nextToken().equalsIgnoreCase("beepers")) {
				String street = tokens.nextToken();
				String avenue = tokens.nextToken();
				String beepers = tokens.nextToken();
				result += Integer.parseInt(beepers);
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		System.out.println("Beepers = " + countBeepers("stairworld.kwld"));
	}

}
