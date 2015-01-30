package fmg;

// Joseph Bergin
// Pace University
// April, 1996
// Updated for Java 2 events April 2002

// French Military Game
// The board looks like this
//
//			1----4----7					// Looks correct in Geneva font
//		    /	 |  \    |    /  |   \
//		  /     |     \ |  /    |     \
//		0----2----5----8----10
//		  \     |    /  |  \    |     /
//		    \   |  /    |    \  |   /
//			 3----6----9

//		   1--4--7		// looks correct in a Fixed font(monaco). 
//		  /|\ | /|\
//		 / | \|/ | \
//		0--2--5--8--10
//		 \ | /|\ | /
//		  \|/ | \|/
//		   3--6--9

//
//  Initially "The Fox" has a piece at 5.  It may move along the arcs.
// Initially "The Police" have pieces at 0,1,3.  
// The Police plays first and may move only to the right or vertically along arcs. 
// The fox wants to get to cell 0 (Escaped with the secrets).  The Police wants to trap
// the fox by denying it a move.  The Police accomplishes this if it completely hems in
// the fox, say at 3,5,9 with the fox at 6.  The Fox wins, however, if the game exceeds
//  20 moves.  
// The person plays the Police and moves first.  The computer plays the fox.  It initially
// plays quite badly, but learns from its mistakes.  

// There are two files required.  "fmg2.memory" is initially 165 rows of 11 zeros each.
// "fmg.board" is always as follows.  2 means a legal move for the police. Non-zero means
//  a legal move for theFox. 

//	0 2 2 2 0 0 0 0 0 0 0
//	1 0 2 0 2 2 0 0 0 0 0
//	1 2 0 2 0 2 0 0 0 0 0
//	1 0 2 0 0 2 2 0 0 0 0
//	0 1 0 0 0 2 0 2 0 0 0
//	0 1 1 1 2 0 2 2 2 2 0
//	0 0 0 1 0 2 0 0 0 2 0
//	0 0 0 0 1 1 0 0 2 0 2
//	0 0 0 0 0 1 0 2 0 2 2
//	0 0 0 0 0 1 1 0 2 0 2
//	0 0 0 0 0 0 0 1 1 1 0


//  The game has exactly 165 legal positions for the Police. 

// The user may resign a game by typing 0 0 for a move.  

import java.util.Random;
import java.lang.Math;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class FMGApplet extends Applet
{	private static final int maxMoves = 20;
	private int [][]  layout = 
	{	{0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0},
		{1, 0, 2, 0, 2, 2, 0, 0, 0, 0, 0},
		{1, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0},
		{1, 0, 2, 0, 0, 2, 2, 0, 0, 0, 0},
		{0, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0},
		{0, 1, 1, 1, 2, 0, 2, 2, 2, 2, 0},
		{0, 0, 0, 1, 0, 2, 0, 0, 0, 2, 0},
		{0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2},
		{0, 0, 0, 0, 0, 1, 0, 2, 0, 2, 2},
		{0, 0, 0, 0, 0, 1, 1, 0, 2, 0, 2},
		{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0}
	};
	private int [] allMoves = new int [165];
	private int [][] thisGame = new int [maxMoves][2];
	private int [][] board = new int [165][11];
	private int [] policePosition = new int[3];
	private int theFox;
	private int moves = 0;
	private int gameState = 0; // 0 = firstClick, 1 = secondClick
	private char [] boardCells = new char [11];
	private TextField fromField, toField;
	private TextField messages;
	private FMGCanvas drawArea;
	
	private long pwr(int x)  // Computes 2 to the (x).  
	{	long result = 1;
		for (int i = 0; i < x; i++)
			result *=2;
		return result;	
	}

	void readFiles(Boolean smart) 
	//throws IOException// more here for safety
	{	//File memoryFile = ("http:./fmg.memory");
		//FileInputStream memoryFileStream = new  FileInputStream(memoryFile);
		int i;
		for (i = 0; i<165; ++i)
		for (int j = 0; j<11; ++j)
		{	//if(smart)memoryFile.readInt(board(i,j));
			//else 
				board[i][j] = 0;
		}
		//try memoryFileStream.close(); catch (IOException e);
	}
	
	boolean legalWhite(int x, int y)
	{	if (theFox == y) return false; // Already occupied by theFox.
		int here = -1;
		int i;
		for(i = 0; i<3; ++i)
			if(policePosition[i] == x) here = i;
		if(here<0) return false; // Police not at x now.
		for (i = 0; i<3; ++i)
			if(policePosition[i] == y) return false; // Already Police.
		if (layout[x][y] != 2) return false; // No such move for the police.
		policePosition[here] = y;
		return true;
	}
	
	int genWhiteValue()
	{	int a = (int)(pwr(policePosition[0]) 
				+ pwr(policePosition[1]) 
				+ pwr(policePosition[2]));
		for(int s = 0; s<165; ++s)
			if (allMoves[s] == a) return s;
		return 0; // Never here.
	}
	
	void summarize(int moves, int outcome)
	{ 	for(int i = 0; i<moves; ++i)
		{	int s = thisGame[i][0];
			int m = thisGame[i][1];
			board[s][m] = board[s][m] + outcome;	
		}
	}
	
	int optimalBlack(int policeEntry)
	{	int result = -1;
		int i,j;
		for (i = 0; i<11; ++i) // Check each position.
		{	if(layout[theFox][i] != 0) // Legal move.
			{	boolean occupied = false;
				for(j = 0; j<3; ++j) // See if policeEntry is already there.
					if(policePosition[j] == i) occupied = true; 
				if(!occupied)
				{	if (result < 0) result = i; // Prime the search.
					else if(board[policeEntry][result] < board[policeEntry][i])
								result = i;// New best move.
				}
			}
		}
		return result;
	}
	
	class Mouser extends MouseAdapter
	{	public void mouseReleased(MouseEvent e)
		{	Point p = drawArea.getLocation();
			e.translatePoint(p.x,p.y);
			int x = e.getX();
			int y = e.getY();	
		//	System.out.println("x "+x+" y "+y);
			if(getComponentAt(x,y)==(drawArea))
			{	int which = drawArea.pollCells(x,y);
		//	System.out.println(gameState+" "+which+" " + x + " " + y);
		//	System.out.println(e.toString());
				if(which < 0) return;
				if (gameState == 0)
				{	fromField.setText(String.valueOf(which));
					gameState = 1 - gameState; 
				}
				else
				{	toField.setText(String.valueOf(which));
					oneMove(moves++);
				}
			}
		}
	}
	
	int getFromMove()
	{	String ans = fromField.getText();
		int result = Integer.parseInt(ans.trim());
		return result;
	}
	
	int getToMove()
	{	String ans = toField.getText();
		int result = Integer.parseInt(ans.trim());
		return result;
	}
	
	int oneMove(int moves)
	{//	paint(this.getGraphics());
		int x,y;
		int result = 0;
		boolean resigned = false, won = false, lost = false;
		x = getFromMove ();
		y = getToMove();
		messages.setText(x + " " + y);
		if(x == 0 && y == 0) resigned = true; // User resigns.  
		if(moves >= maxMoves) 
		{	resigned = true;
			messages.setText( maxMoves + " move limit exceeded.");
		}
		if(!resigned)
			if(legalWhite(x,y))
			{	int oldFox = theFox;
				int policeMove = genWhiteValue();
				int theFoxMove = optimalBlack(policeMove);
				if(theFoxMove>0)
					drawArea.movePieces(x, y, theFox, theFoxMove);
				else
					drawArea.movePieces(x, y, theFox, theFox);
				drawArea.draw();
				if(theFoxMove < 0) lost = true; // Machine loses.
				else
				{	thisGame[moves][0] = policeMove;
					thisGame[moves][1] = theFoxMove;
					theFox = theFoxMove;
					moves++;
				}
			}
			else
			{ 	messages.setText( "Illegal.");
			}
			if(theFox == 0) won = true; // Machine wins. 
			if(resigned || won)
			{	result = 1;
				messages.setText("Machine wins.");
				summarize(moves-1, 1);
			}
			else if (lost)
			{	result = -1;
				messages.setText("You win.");
				summarize(moves-1,-1);
			}
			gameState = 0;
			return result;
	}
	
	public void init()
	{  	int i = 0;
		int L;
		for ( L = 0; L<9; ++L)
		{	int L1 = (int) pwr(L);
			for (int M = L+1; M<10; ++M)
			{	int M1 =(int) pwr(M);
				for (int R = M+1; R<11; R++)
					allMoves[i++] = L1 + M1 + (int) pwr(R);
			}
		}
		for(L = 0; L<maxMoves; ++L)
		for(int M = 0; M<2; ++M)
			thisGame[L][M] = 0;
		theFox = 5;
		policePosition[0] = 0;
		policePosition[1] = 1;
		policePosition[2] = 3;
		
		setLayout(new BorderLayout());
		setBackground(Color.lightGray);
		messages = new TextField("Welcome",30);
		add("North", messages);

		drawArea = new FMGCanvas();
		drawArea.init();
		drawArea.addMouseListener(new Mouser());
		add("Center", drawArea);
	
		Panel P = new Panel();
		P.setLayout(new FlowLayout());
		
		fromField = new TextField("0", 3);
		toField = new TextField("2", 3);
		P.add(fromField);
		P.add(toField);
		Button moveButton = new Button("Move");
		moveButton.addActionListener(new MoveListener());
		P.add(moveButton);
		
		Button resignButton = new Button("Resign");
		resignButton.addActionListener(new ResignListener());
		P.add(resignButton);
		
		Button newGame = new Button("New Game");
		newGame.addActionListener(new NewGameListener());
		P.add(newGame);
		
		add("South", P);
		
	}

	
	class ResignListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	messages.setText("Machine wins.");
			summarize(moves-1, 1);
		}
	}
	
	class MoveListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	 int result = oneMove(moves++);
		}
	}
	
	class NewGameListener implements ActionListener
	{	public void actionPerformed(ActionEvent e)
		{	drawArea.reset();
			messages.setText("OK");
			fromField.setText("0");
			toField.setText("2");
			theFox = 5;
			policePosition[0] = 0;
			policePosition[1] = 1;
			policePosition[2] = 3;
			moves = 0;
			for(int L = 0; L<maxMoves; ++L)
				for(int M = 0; M<2; ++M)
					thisGame[L][M] = 0;
			gameState = 0;		
		}
	}
		
	public void paint(Graphics g)
	{//	drawArea.paint(g);
	}
	
}

class cell
{	int x, y;
	int ht, wt;
	boolean hasWhitePiece = false;
	boolean hasBlackPiece = false;
	cell [] nbrs = new cell[4];
	int nbrCount = 0;
	cell(int left, int top, int width, int height)
	{	x = left; y = top; ht = height; wt = width; 
		
	}
	void addNeighbor(cell c)
	{	nbrs[nbrCount++] = c;
	}
	
	void drawConnections(Graphics g)
	{	Color oldColor = g.getColor();
		g.setColor(Color.black);
		for(int i = 0; i < nbrCount; ++i)
			g.drawLine(x,y, nbrs[i].x, nbrs[i].y);
		g.setColor(oldColor);
	}
	
	void draw(Graphics g)
	{	Color oldColor = g.getColor();		
		if(hasWhitePiece) g.setColor(Color.white);
		else if(hasBlackPiece)g.setColor(Color.red);
		else g.setColor(Color.black);
		g.fillRect(x - ht/2, y - wt/2, wt, ht);
		g.setColor(oldColor);
	}
	
}

class FMGCanvas extends Canvas
{	private int [] policePosition = new int[3];
	private int theFox;
	private static final int xv = 600;
	private static final int yv = 400;
	private static final int bw = 30;
	private static final int bh = 30;
	private cell [] s =
		{ 	new cell(xv*3/20, yv*9/20, bw, bh),
		 	new cell(xv*3/10, yv/4, bw, bh),
			new cell(xv*3/10, yv*9/20, bw, bh),
			new cell(xv*3/10, yv*13/20, bw, bh),
			new cell(xv*9/20, yv/4, bw, bh),
			new cell(xv*9/20, yv*9/20, bw, bh),
			new cell(xv*9/20, yv*13/20, bw, bh),
			new cell(xv*3/5, yv/4, bw, bh),
			new cell(xv*3/5, yv*9/20, bw, bh),
			new cell(xv*3/5, yv*13/20, bw, bh),
			new cell(xv*3/4, yv*9/20, bw, bh)
		};
		
	void draw()
	{	paint(getGraphics());
	}
	
	int pollCells(int x, int y)
	{	int result = -1;
		Point p = getLocation();
		for(int i = 0; i < 11; ++i)
		{	int left = p.x + s[i].x - s[i].wt/2;
			int top = p.y + s[i].y - s[i].ht/2;
			if (x > left && x < left + s[i].wt && y > top && y < top + s[i].ht)
				return i;
		}
		return result;
	}
	
	public void reset()
	{	theFox = 5;
		policePosition[0] = 0;
		policePosition[1] = 1;
		policePosition[2] = 3;
		for(int i = 0; i< 11; ++i)
		{	s[i].hasWhitePiece = false;
			s[i].hasBlackPiece = false;
		}
		s[0].hasWhitePiece = true;
		s[1].hasWhitePiece = true;
		s[3].hasWhitePiece = true;
		s[5].hasBlackPiece = true;
		paint(getGraphics());
	}
	
	public void init()
	{	theFox = 5;
		policePosition[0] = 0;
		policePosition[1] = 1;
		policePosition[2] = 3;
		
		s[0].addNeighbor(s[1]);
		s[0].addNeighbor(s[2]);
		s[0].addNeighbor(s[3]);
		s[0].hasWhitePiece = true;
		
		s[1].addNeighbor(s[2]);
		s[1].addNeighbor(s[4]);
		s[1].addNeighbor(s[5]);
		s[1].hasWhitePiece = true;
	
		s[2].addNeighbor(s[1]);
		s[2].addNeighbor(s[3]);
		s[2].addNeighbor(s[5]);
	
		s[3].addNeighbor(s[5]);
		s[3].addNeighbor(s[6]);
		s[3].hasWhitePiece = true;
	
		s[4].addNeighbor(s[5]);
		s[4].addNeighbor(s[7]);
	
		s[5].addNeighbor(s[6]);
		s[5].addNeighbor(s[7]);
		s[5].addNeighbor(s[8]);
		s[5].addNeighbor(s[9]);
		s[5].hasBlackPiece = true;
	
		s[6].addNeighbor(s[9]);
	
		s[7].addNeighbor(s[8]);
		s[7].addNeighbor(s[10]);
	
		s[8].addNeighbor(s[9]);
		s[8].addNeighbor(s[10]);
	
		s[9].addNeighbor(s[10]);

}
	
	void movePieces(int policeFrom, int policeTo, int foxFrom, int foxTo)
	{	theFox = foxTo;
		int i = 0;
		while(policePosition[i] != policeFrom) 
		{	i++; if(i == 3) break;
		}
		policePosition[i] = policeTo;
		s[policeFrom].hasWhitePiece = false;
		s[policeTo].hasWhitePiece = true;
		s[foxFrom].hasBlackPiece = false;
		s[foxTo].hasBlackPiece = true;
	}
	
	public void paint(Graphics g)
	{	int i;
		for(i = 0; i < 10; ++i) // sic. 10 has no connections.
			s[i].drawConnections(g);
		for(i = 0; i < 11; ++i)
			s[i].draw(g);
	}
}
