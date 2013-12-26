package chess;

import java.awt.Image;
import java.util.ArrayList;

import chess.Player.Colors;

public class Knight extends Piece{

	protected static final Image imageWhite = Utilits.loadImage("Knight-W.png");
	protected static final Image imageBlack = Utilits.loadImage("Knight-B.png");


	public Knight(Player player){
		super(player);
		this.utility =2;
		this.symbol ="Kg";
		if(player.color == Colors.white)
		{
			imagePiece = imageWhite;
		}
		else if(player.color == Colors.black)
		{
			imagePiece = imageBlack;
		}
		originImage = imagePiece;
	}
	@Override
	/*
	 * return all possible move for knight 
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		// return all possible move for this 
		ArrayList<Square> possibleMove = new ArrayList<>();
		possibleMove = getAllPossibleMoves(currentChessBoardState);
		return getSafetyState(currentChessBoardState, possibleMove, currentSquare);
	}
	@Override
	public Piece copy() {
		return new Knight(player);
	}
	@Override
	public ArrayList getAllPossibleMoves(ChessBoard currentChessBoardState) {
		ArrayList<Square> possibleMove = new ArrayList<>();
		ArrayList<Square> answerMoves = new ArrayList<>();
		
		if(!this.isOut(this.currentSquare.xPosition+2, this.currentSquare.yPosition+1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+2, this.currentSquare.yPosition+1));
		if(!this.isOut(this.currentSquare.xPosition+2, this.currentSquare.yPosition-1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+2, this.currentSquare.yPosition-1));
		if(!this.isOut(this.currentSquare.xPosition-2, this.currentSquare.yPosition+1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-2, this.currentSquare.yPosition+1));
		if(!this.isOut(this.currentSquare.xPosition-2, this.currentSquare.yPosition-1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-2, this.currentSquare.yPosition-1));
		if(!this.isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition+2))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition+2));
		if(!this.isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition-2))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition-2));
		if(!this.isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition+2))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition+2));
		if(!this.isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition-2))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition-2));
		
		
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
		return answerMoves;
	}

}
