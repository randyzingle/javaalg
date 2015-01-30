import com.jbergin.robot.*;
import static com.jbergin.robot.Direction.*;
import static com.jbergin.robot.World.*;


/** An illustration of Strategy and Decorator patterns (and the power of delegation). 
 * @author jbergin
 *
 */
public class BlockWalker extends KarelRobot {

	public interface Helper {
		public void doSide(BlockWalker robot);
	}


	public class StepHelper implements Helper {
		
		private int side;

		public StepHelper(int side){
			this.side = side;
		}

		public void doSide(BlockWalker robot) {
			for (int j = 0; j < side; ++j){
				System.out.print("doside ");
				robot.move();
			}
			//robot.swapHelpers(); // for v2
			robot.extendSide(); // for v3
		}
	}
	
	public class StepDecorator implements Helper{ // a decorator -- ISA and HASA

		private Helper decorated = null;

		public StepDecorator(Helper decorated) {
			this.decorated  = decorated;
		}

		public void doSide(BlockWalker robot) {
			System.out.print("before ");
			robot.move();
			decorated.doSide(robot);
			System.out.print("after ");
			robot.move();
		}
	
	}

	public BlockWalker(int street, int avenue, Direction direction, int beepers) {
		super(street, avenue, direction, beepers);
	}

	public void extendSide() {
		helper = new StepDecorator(helper);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BlockWalker karel = new BlockWalker(4, 4, East, INFINITE);
		karel.walkBlock();

	}
	
	private void walkASide(){
		for (int j = 0; j < 8; ++j){
			move();
		}	
	}

	public void walkBlock() {
		for(int i = 0; i < 4; ++i){
			walkASide();
			turnLeft();
			putBeeper();
		}
	}

	private Helper helper = new StepHelper(8);
	private Helper other = new StepDecorator(helper);//new StepHelper(6);
	
	private void swapHelpers(){
		Helper temp = helper;
		helper = other;
		other = temp;
	}

	public void walkBlockV2() {
		for(int i = 0; i < 4; ++i){
			helper.doSide(this); // delegation
			turnLeft();
			putBeeper();
		}
	}

	public void walkBlockV3() {
		for(int i = 0; i < 4; ++i){
			helper.doSide(this); // delegation
			turnLeft();
			putBeeper();
		}
	}

}
