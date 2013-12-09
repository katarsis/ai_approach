package piton.tree;

import java.awt.List;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import chess.*;
import chess.Player.Colors;
import chess.Player.PlayerTypes;
import TicTacToe.IGameState;
import TicTacToe.StateGame;



public class MainTest {

	public static void main(String[] args) throws CloneNotSupportedException, NodeException {
		int menuItem = 0;
		try
		{
			System.out.println("pleas input the task id");
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		    menuItem = Integer.valueOf(bufferRead.readLine());
			
			switch(menuItem){
			case 0: taskAboutThree();
			case 1: taskTicTacToe();break;
			case 2: chessTask();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("Somthing bad");
		}
	}
	
	public static void chessTask() 
	{
		/*ChessBoard chessBoard = new ChessBoard();
		chessBoard.setDefaultPieces();
		chessBoard.print();
		Player startPlayer = new Player(Colors.white ,PlayerTypes.human);
		
		IState initalStateOfGame  =  new StateChess(chessBoard, startPlayer);	
		for(IState currentState: initalStateOfGame.getAllChild(initalStateOfGame))
		{
		//	currentState.Print();
		}*/
		Display display =  new Display();
		Shell shell =  new Shell(display);
		MainWindow game = new MainWindow(shell,0);
		shell.pack();
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
			
		}
		display.dispose ();
	}
	
	public static void taskTicTacToe() throws IOException
	{
		/*
		 * gamer choose the pieces and make first step
		 * creates decision trees in which win state have a 1 value
		 * loose state have -1
		 * standoff state have 0
		 * choose node with max value
		 * and make step 
		 */
		System.out.println("Hello please input the piece (X or O)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String answer = reader.readLine();
		if(answer.equals("x"))
		{
			StateGame.COMP_GAMER = StateGame.GAMER_ZERO;
			StateGame.HUMAN_GAMER = StateGame.GAMER_CROSS;
		}
		else 
		{
			StateGame.COMP_GAMER = StateGame.GAMER_CROSS;
			StateGame.HUMAN_GAMER = StateGame.GAMER_ZERO;
		}
		
		IGameState stateGame =  new StateGame();
		stateGame.setGamer(StateGame.HUMAN_GAMER);
		Node start = new Node<IGameState>(stateGame);
		IGameState currentState =  stateGame;
	
		while (!currentState.IsFinState())
		{
			answer = reader.readLine();
			int xPos = Integer.valueOf(answer);
			answer = reader.readLine();
			int yPos = Integer.valueOf(answer);
			currentState.setPiecesIn(xPos, yPos, currentState.getCurrentGamer());
			//currentState.changeGamer();
			currentState = Tree.getMinMaxStep(currentState,2,StateGame.COMP_GAMER);
			currentState.changeGamer();
			currentState.Print();
		}
		
		//for TicTacToe starter
		/*Display display =  new Display();
		Shell shell =  new Shell(display);
		MainWindow game = new MainWindow(shell,0);
		shell.pack();
		shell.open();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();		
		//create the initial state which all position on the left side*/
	}
	
	public static void taskAboutThree()
	{
		Node<State> initalState = new  Node<State>(new State(true, true, true, "L"));
		Node goalNode = Tree.searchInDepth(initalState);
				// searchInFront(initalState);
		//print the slove
		Tree desizionTree = new Tree(initalState);
		ArrayList<Node> criticalPath = desizionTree.printRedPathTree(goalNode);
		for(int i=criticalPath.size()-1; i>=0;i--)
		{
			State StateNow = (State)criticalPath.get(i).GetContent();
			StateNow.Print();
		}
	}
	


}
