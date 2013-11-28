package chess;

import java.util.ArrayList;

import piton.tree.IState;
import TicTacToe.IGameState;

public class State implements IGameState{

	public ChessBoard chessBoard;
	public int utility;
	public Player currentPlayer;
	
	@Override
	public int getCurrentGamer() {
		// TODO Auto-generated method stub
		
		return 0;
	}
	@Override
	public boolean IsPossibleState() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean IsFinState() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void Print() {
		chessBoard.print();
	}
	@Override
	public ArrayList<IState> getAllChild(IState input) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getMinMaxValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getHeuristicValue(int gamerID) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Object getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean setPiecesIn(int xPos, int yPos, int pieces) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void changeGamer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setGamer(int inGamer) {
		// TODO Auto-generated method stub
		
	}
}
