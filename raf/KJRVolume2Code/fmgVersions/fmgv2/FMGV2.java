package fmgv2;

import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Display{
	
	private int theFox = 5;

	public Display(int theFox){
		this.theFox  = theFox;
		mapper.put(0, new Point(3, 1));
		mapper.put(1, new Point(0, 1));
		mapper.put(2, new Point(3, 3));
		mapper.put(3, new Point(6, 1));
		mapper.put(4, new Point(0, 3));
		mapper.put(5, new Point(3, 5));
		mapper.put(6, new Point(6, 3));
		mapper.put(7, new Point(0, 5));
		mapper.put(8, new Point(3, 7));
		mapper.put(9, new Point(6, 5));
		mapper.put(10, new Point(3, 9));
		Point where = mapper.get(theFox);
		display[where.x][where.y] = "F";
	}
	
	private String[][] display = { // a list of lists. It will be modified
			// during a game to show the Fox. Warning: NOT rectangular
			{ "     ","1","--", "4", "--", "7"},
			{ "    /|\\ | /|\\"},
			{ "   / | \\|/ | \\"},
			{ "  ", "0", "--", "2", "--", "5", "--", "8", "--", "10" },
			{ "   \\ | /|\\ | /" },
			{ "    \\|/ | \\|/" },
			{ "     ", "3", "--", "6", "--", "9"} 
			}; // seven rows and various length columns
	
	private Map<Integer, Point> mapper = new HashMap<Integer, Point>();


	public void show() {
		for (int i = 0; i < display.length; ++i) {
			for (int j = 0; j < display[i].length; ++j) { // handles various length columns
				System.out.print(display[i][j]);
			}
			System.out.println();
		}
	}
	
	public void moveFox(Fox fox){
		Point where = mapper.get(theFox);
		display[where.x][where.y] = "" + theFox;
		theFox = fox.position();
		where = mapper.get(theFox);
		display[where.x][where.y] = "F";
	}
}

class MemoryManager{
	private String filename;
//	private int[][] history = new int[165][11];
	private Map<Point, Integer> history = new HashMap<Point, Integer>();
//	private int[][] thisGame;
	private List<Point> thisGame = new ArrayList<Point>();

	public MemoryManager(String filename, int maxMoves){
		this.filename = filename;
//		this.thisGame = new int[maxMoves][2];
	}
	
	public boolean smaller(int row, int current, int trial){ // rename row, it is the police position
//		return history[row][current] < history[row][trial];
//		Integer first = history.get(new Point(row, current));
//		if (first == null){
//			first = 0;
//		}
//		Integer second = history.get(new Point(row, trial));
//		if(second == null){
//			second = 0;
//		}
//		return first < second;
		return getHistory(new Point(row, current)) < getHistory(new Point(row, trial));
	}
	
	public void init(){
		thisGame.clear();
	}
	
	// A helper function to transform null from the history into 0 would help in a couple of places. 
	
	public int getHistory(Point where){
		Integer value = history.get(where);
		if(value == null){
			return 0;
		}
		return value;
	}

	public void summarize(int outcome) { // don't need moves. The list knows its size.
//		for (int i = 0; i < moves; ++i) {
//			int police = thisGame[i][0];
//			int fox = thisGame[i][1];
//			Point where = new Point(police, fox);
//			Point where = thisGame.get(i);
		for(Point where: thisGame){
			Integer value = history.get(where);
			if(value == null){
				history.put(where, outcome);
			}
			else {
				history.put(where, value + outcome);
			}
//			history[police][fox] += outcome;
		}
	}
	
	public void record(int moves, Fox fox, Police police){ // don't need moves. List is dynamic. 
//		thisGame[moves][0] = police.computeValue();
//		thisGame[moves][1] = fox.position();
		thisGame.add(new Point(police.computeValue(), fox.position()));
	}

	public void getMemory(boolean smart){
		try{
			readFile(smart);
		}
		catch(Exception e){ // nothing to do here. An empty map is fine. 
			System.out.println("Couldn't read file. Working with blank memory.");
//			for (int i = 0; i < history.length; ++i) {
//				for (int j = 0; j < history[i].length; ++j) {
//					history[i][j] = 0;
//				}
//			}
		}
	}
	
	private void readFile(boolean smart) throws Exception {		
		Scanner memoryFile = null; 
		if(smart){
			memoryFile = new Scanner(new File(filename));
		}
//		for (int i = 0; i < history.length; ++i) {
//			for (int j = 0; j < history[i].length; ++j) {
//				if (smart) {
//					// System.out.println("i: " + i + " j: " +j);
//					history[i][j] = memoryFile.nextInt();
//				} else {
//					history[i][j] = 0;
//				}
//			}
//		}
		while(memoryFile.hasNext()){
			int police = memoryFile.nextInt();
			int fox = memoryFile.nextInt();
			int weight = memoryFile.nextInt();
			history.put(new Point(police,fox), weight);
		}
	}

	public void saveMemory() {
		String all = "";
//		for (int i = 0; i < history.length; ++i) {
//			for (int j = 0; j < history[i].length; ++j) {
//				all += history[i][j] + " ";
//			}
//		}
		for(Point p: history.keySet()){
			int weight = history.get(p);
			all += p.x + " " + p.y + " " + weight + " "; 
		}
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(filename));
			out.write(all);
			out.close();
		} 
		catch (IOException e) {
			System.out.println("Could not write the memory file.");
			e.printStackTrace();
		}
	}
}

class Police{
	public Police(){
		init();
		// Compute all police position values and save them. Never changed again. 
//		int i = 0;
//		for (int L = 0; L < 9; ++L) {
//			for (int M = L + 1; M < 10; ++M) {
//				for (int R = M + 1; R < 11; R++)
//					allMoves[i++] = (int) (pwr(L) + pwr(M) + pwr(R));
//			}
//		}
	}
	
	public boolean holding(int position){
//		for(int i = 0; i < policePosition.length; ++i){
//			if(policePosition[i] == position)
//				return true;
//		}
//		return false;
		
//		int police = computeValue();
//		int where = (int)pwr(position);
//		return (police & where) != 0;
		return policePosition.contains(position);
	}
	
//	private int[] policePosition = new int[3]; // current position
	private Set<Integer> policePosition = new HashSet<Integer>();
	// invariant: The set contains exactly three elements. 
//	private int[] allMoves = new int[165]; // records the possible positions as integers
	
//	public void dumpAllMoves(){
//		for(int i = 0; i < allMoves.length; ++i){
//			System.out.println(allMoves[i]);
//		}			
//	}

	private long pwr(int x){ // Computes 2 to the (x).
		long result = 1;
		for (int i = 0; i < x; i++){
			result *= 2;
		}
		return result;
	}
	
	public void showPosition(){
		String display = "Police at ";
		for(int value: policePosition){
			display += value + " ";
		}
		System.out.println(display);
//		System.out.println("Police at " + policePosition[0] + ", "
//				+ policePosition[1] + ", " + policePosition[2]);
	}

//	private int [] position(){ // returns a copy
//		int [] where = new int[3];
//		where[0] = policePosition[0];
//		where[1] = policePosition[1];
//		where[2] = policePosition[2];
//		return where;
//	}
	
	public final void init(){ // for a new game
//		policePosition[0] = 0;
//		policePosition[1] = 1;
//		policePosition[2] = 3;
		policePosition.clear();
		policePosition.add(0);
		policePosition.add(1);
		policePosition.add(3);
	}

	public boolean legalMove(int from, int to, Fox fox) { // rename moveTo
		if (! MoveRules.legalPoliceMove(from, to)) {
			return false; // No such move for the police.
		}
		if (fox.position() == to){
			return false; // Already occupied by theFox.
		}
//		int here = -1; //Try to find one police piece at location from
//		int i;
//		for (i = 0; i < policePosition.length; ++i) {
//			if (policePosition[i] == from) {
//				here = i;
//				break; // found one
//			}
//		}
//		if (here < 0) {
//			return false; // Police not at from location now.
//		}
//		for (i = 0; i < policePosition.length; ++i) {
//			if (policePosition[i] == to) {
//				return false; // Location to is already occupied by Police.
//			}
//		}
//		policePosition[here] = to;
		if(policePosition.contains(to)){
			return false; // Location to is already occupied by Police.
		}
		if(! policePosition.contains(from)){
			return false; // Police not at from location now.
		}
		policePosition.remove(from);
		policePosition.add(to);
		return true;
	}

	public int computeValue() { // actually the array cell number that contains the value
//		int a = (int) (pwr(policePosition[0]) + pwr(policePosition[1]) + pwr(policePosition[2]));
		int a = 0;
		for(int value: policePosition){
			a += (int)pwr(value);
		}
//		for (int s = 0; s < allMoves.length; ++s)
//			if (allMoves[s] == a)
//				return s;
//		return 0; // Never here. allMoves should contain all possible values
		return a;
	}
	
}

class Fox{
	private int position;

	public Fox(){
		init();
	}

	public final void init() {
		position = 5;	
	}
	
	public int position(){
		return position;
	}
	
	public void optimalMove(Police police, MemoryManager memory) {
		int policeEntry = police.computeValue();
		int best = -1; // will signal that fox is trapped unless replaced
		for (int trial = 0; trial < 11; ++trial){ // Check each position.
			if (MoveRules.legalFoxMove(position, trial) && !police.holding(trial)) { // Legal  move.
				if (best < 0) {
					best = trial; // Prime the search. There is at least one legal move.
				} else {
					if (memory.smaller(policeEntry, best, trial)) { // search for biggest value = best move
						best = trial;// New best move is at location trial.
					}
				}
			}
		}
		position = best;
	}

	public void showPosition() {
		System.out.println("Fox at " + position);		
	}

}

class MoveRules{
	private static final int[][] LAYOUT = { // fixed array: 11 by 11, rectangular
			{ 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 2, 0, 2, 2, 0, 0, 0, 0, 0 },
			{ 1, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0 },
			{ 1, 0, 2, 0, 0, 2, 2, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0 },
			{ 0, 1, 1, 1, 2, 0, 2, 2, 2, 2, 0 },
			{ 0, 0, 0, 1, 0, 2, 0, 0, 0, 2, 0 },
			{ 0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2 },
			{ 0, 0, 0, 0, 0, 1, 0, 2, 0, 2, 2 },
			{ 0, 0, 0, 0, 0, 1, 1, 0, 2, 0, 2 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 } 
	};

	public static boolean legalPoliceMove(int from, int to){
		return LAYOUT[from][to] == 2;
	}
	
	public static boolean legalFoxMove(int from, int to){
		return LAYOUT[from][to] > 0;
	}
}

public class FMGV2 {
	private static final int MAX_MOVES = 20;
	private String filename = "./src/fmg2.memory";
	private MemoryManager memory = new MemoryManager(filename, MAX_MOVES);
	private Police police = new Police();
	private Fox fox = new Fox();	
	private Display display = new Display(fox.position());

	private final int WON = 1;
	private final int LOST = -1; // weights for recording a game
	
	public FMGV2(boolean smart){
		memory.getMemory(smart);
	}

	public void play() {// many games
		while (true) {
			oneGame();
			System.out.println("Play again?[no]");
			Scanner in = new Scanner(System.in);
			if (!in.hasNext()) {
				break;
			}
			String raw = in.next();
			char reply = raw.charAt(0);
			if (reply != 'y' && reply != 'Y') {
				break;
			}
		}
		memory.saveMemory();
	}

	private void showPositions() {
		police.showPosition();
		fox.showPosition();
	}

	private Point getMove() {
		showPositions();
		System.out.println("Your move: from to  ( 0 0 to resign)");
		Scanner in = new Scanner(System.in);
		return new Point(in.nextInt(), in.nextInt());
	}

	public void init() {
		fox.init();
		police.init();
		memory.init(); // new
	}

	public void oneGame() {
		init();
		int moves = 0;
		System.out.println("Playing");
		int outcome = 0;
		while (true) {
			if (moves >= MAX_MOVES) {
				System.out.println("Fox wins = timeout");
				outcome = WON;
				break;
			}
			display.show();
			Point move = getMove();
			int from = move.x;
			int to = move.y;
			if (from == 0 && to == 0) {
				System.out.println("Fox wins = resign");
				outcome = WON;
				break;
			}
			if (police.legalMove(from, to, fox)) { // police move if legal
				fox.optimalMove(police, memory); // fox responds
				int position = fox.position();
				if (position > 0) {
					memory.record(moves, fox, police);
					moves++;
				} else if (position == 0) {
					System.out.println("Fox wins - home");
					outcome = WON;
					break;
				} else if (position < 0) { // no legal move
					System.out.println("Fox loses - trapped");
					outcome = LOST;
					break;
				}
				display.moveFox(fox);
				showPositions();
			} // else ignored
		}
		memory.summarize(outcome);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		FMGV2 game = new FMGV2(true);
		game.play();
		
//		Police p = new Police();
//		p.dumpAllMoves();
		// game.readFile();
		// game.showDisplay();
	}

}
