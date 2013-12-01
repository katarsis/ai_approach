package chess;

import java.util.ArrayList;

import chess.Player.Colors;

public class Knight extends Piece{

	public Knight(Player player){
		super(player);
		this.symbol ="Kg";
	}
	@Override
	/*
	 * return all possible move for knight 
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		// return all possible move for this 
		ArrayList<Square> possibleMove = new ArrayList<>();
		ArrayList<Square> answerMoves = new ArrayList<>();
		
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+2, this.currentSquare.yPosition+1));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+2, this.currentSquare.yPosition-1));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-2, this.currentSquare.yPosition+1));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-2, this.currentSquare.yPosition-1));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition+2));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition-2));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition+2));
		possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition-2));
		
		for(Square newSquare: possibleMove)
		{
			if(this.color == Colors.white)
			{
				if(newSquare.isEmpty())
				{
					answerMoves.add(newSquare);
				}
				else if(this.isOtherGamer(newSquare.xPosition, newSquare.yPosition, currentChessBoardState))
				{
					answerMoves.add(newSquare);
				}
			}
			
			if(this.color == Colors.black)
			{
				if(newSquare.isEmpty())
				{
					answerMoves.add(newSquare);
				}
				else if(this.isOtherGamer(newSquare.xPosition, newSquare.yPosition, currentChessBoardState))
				{
					answerMoves.add(newSquare);
				}
			}
		}
			
		return null;
	}

}
