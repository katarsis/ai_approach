package chess;

import java.util.ArrayList;

import piton.tree.IState;
import TicTacToe.IGameState;

public class StateChess implements IGameState{

	public ChessBoard chessBoard;
	public int utility;
	public Player currentPlayer;
	
	public StateChess (ChessBoard currentChessBoard,Player player)
	{
		this.chessBoard = currentChessBoard;
		this.currentPlayer = player;
	}
	
	//FIXME this must by private and not used 
	public StateChess ()
	{
	}
	
	@Override
	public int getCurrentGamer() {
		// TODO Auto-generated method stub
		/*
		 * @return the currrent player
		 */
		return 0;
	}
	@Override
	public boolean IsPossibleState() {
		// TODO Auto-generated method stub
		/*
		 * all state is possible then all childs state creates by rule
		 */
		return true;
	}
	@Override
	public boolean IsFinState() {
		// TODO Auto-generated method stub
		/*
		 * if king is passed then is't fin state 
		 * 
		 */
		return false;
	}
	@Override
	public void Print() {
		/*
		 * print  all square from chess board 
		 */
		chessBoard.print();
	}
	@Override
	public ArrayList<IState> getAllChild(IState input) {
		// TODO calculate the utility
		/*
		 * for each piece who player is invert current player 
		 * call function get allChild
		 * calculate the utility
		 * it's all! =) 
		 */
		ArrayList<IState> childsState = new ArrayList<>();
		for(int xPosition = 0; xPosition < ChessBoard.DIMENSION; xPosition++)
			for(int yPosition =0 ; yPosition < ChessBoard.DIMENSION; yPosition++)
			{
				Square currentSquare = chessBoard.getChessFeilds(xPosition, yPosition);
				if(currentSquare.piece!=null && currentSquare.piece.player.color!= currentPlayer.color)
				{
					ArrayList<Square> possibleState = currentSquare.piece.getAllMovies(chessBoard);
					if(possibleState!=null)
					for(Square newSquare: possibleState){
					 StateChess newState = new StateChess();
					 ChessBoard newChessBoardState  =  chessBoard.clone();
					 newSquare.piece = (Piece)currentSquare.piece.copy();
					 newChessBoardState.setChessAt(newSquare,currentSquare);
					 Square oldSquare = new Square(xPosition, yPosition);
					 newChessBoardState.setChessAt(oldSquare,currentSquare);					 
					 newState.chessBoard = newChessBoardState;
					 newState.currentPlayer =  newSquare.piece.player;
					 //newState.utility =  getHeuristicValue();
					 childsState.add(newState);
					}
				}
			}
		return childsState;
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
