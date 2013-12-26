package chess;

import java.awt.Color;
import java.awt.Image;
import java.util.ArrayList;

import chess.Player.Colors;

/*
 * represents the pawn piece 
 */

public class Pawn extends Piece {

	/*
	 * represents the pawn piece
	 */
	protected static final Image imageWhite = Utilits.loadImage("Pawn-W.png");
	protected static final Image imageBlack = Utilits.loadImage("Pawn-B.png");
	 
	/*
	 * Constructor
	 * @param player	the initial player for this piece
	 */
	public Pawn(Player player)
	{
		super(player);
		this.utility =1;
		this.symbol = "P ";
		if(player.color == Colors.black){
			imagePiece = imageBlack;
		}
		else if (player.color == Colors.white)
		{
			imagePiece = imageWhite;
		}
		originImage = imagePiece;
	}

	@Override
	/*
	 * Function represent all possible move for the pawn on current chess board
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		
		//if after move king will be attacked delete it from the possible move
		ArrayList<Square> possibleMovies = new  ArrayList<>();
		possibleMovies = getAllPossibleMoves(currentChessBoardState);
		return getSafetyState(currentChessBoardState, possibleMovies, currentSquare);
	}

	@Override
	public Piece copy() {
		return new Pawn(player);
	}



	@Override
	public ArrayList getAllPossibleMoves(ChessBoard currentChessBoardState) {
		/*
		 * if after move king will be attacked delete it from the possible move
		 */
		 ArrayList<Square> possibleMovies = new  ArrayList<>();
		// if player is white then 
		if(this.color == Colors.black){
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
		else if(this.color == Colors.white)
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
		return possibleMovies;
	}
}
