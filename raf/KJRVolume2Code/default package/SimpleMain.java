
import java.io.IOException;

import com.jbergin.robot.World;

public class SimpleMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		World world = new World();
		world.readWorld("stairworld.kwld");
		world.showWorld(1, 1, 7, 7);

	}

}
