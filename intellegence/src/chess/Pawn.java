package chess;

import java.awt.Color;
import java.util.ArrayList;

import chess.Player.Colors;

/*
 * represents the pawn piece 
 */

public class Pawn extends Piece {

	/*
	 * represents the pawn piece
	 */
	
	/*
	 * Constructor
	 * @param player	the initial player for this piece
	 */
	public Pawn(Player player)
	{
		super(player);
		this.symbol = "P ";
	}

	@Override
	/*
	 * Function represent all possible move for the pawn on current chess board
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		/*
		 * if after move king will be attacked delete it from the possible move
		 */
		 ArrayList<Square> possibleMovies = new  ArrayList<>();
		 ArrayList<Square> answerMoves = new ArrayList<>();
		// if player is white then 
		if(this.color == Colors.white){
			//if field on [x][y+2] or [x][y+1] is empty put it on possible move
			for(int i=1; i<3; i++ )
			{
				if( currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition+i).isEmpty())
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition+i));
				}
				else
				{
					break;
				}
			}
			//if field on [x+1][y+1] or [x-1][y+1] is other owner put it on possible move
			{
				if(!isOut( this.currentSquare.xPosition+1, this.currentSquare.yPosition+1)&&this.isOtherGamer(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1, currentChessBoardState))
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1));
				}
				if( !isOut( this.currentSquare.xPosition-1, this.currentSquare.yPosition+1)&& this.isOtherGamer(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1, currentChessBoardState))
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1));
				}
			}
		}
		// if player is black then 
		else if(this.color == Colors.black)
		{
			//if field on [x][y-2] or [x][y-1] is empty put it on possible move
			for(int i=1; i<3; i++ )
			{
				if( currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition-i).isEmpty())
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition-i));
				}
				else
				{
					break;
				}
			}
			//if field on [x+1][y-1] or [x-1][y-1] is other owner put it on possible move
			{
				if( !isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1) && this.isOtherGamer(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1, currentChessBoardState))
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1));
				}
				if( !isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1) && this.isOtherGamer(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1, currentChessBoardState))
				{
					possibleMovies.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1));
				}
			}
		}
		//if after move king will be attacked delete it from the possible move
		for(Square newSquare: possibleMovies){
			if (this.color == Colors.white)
			{
				ChessBoard temporaryChess= currentChessBoardState.clone();
				temporaryChess.setChessAt(newSquare);
				if(!temporaryChess.whiteKing.isCheked())answerMoves.add(newSquare);
			}
			if (this.color == Colors.black)
			{
				ChessBoard temporaryChess= currentChessBoardState.clone();
				temporaryChess.setChessAt(newSquare);
				if(!temporaryChess.blackKing.isCheked())answerMoves.add(newSquare);
			}
		}
		return answerMoves;
	}
}
