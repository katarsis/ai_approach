package chess;

import java.util.ArrayList;

import chess.Player.Colors;

public class Rook extends Piece{

	public Rook(Player player)
	{
		super(player);
		this.symbol ="R ";
	}

	@Override
	/*
	 * Function represent all possible move for the pawn on current chess board
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		//Represents the rook possible moves 
		//for each square at horizontal if this square is empty or first filling by other player add it
		//for each square at vertical if this square is empty or first filling by other player add it
		ArrayList<Square> possibleMove = new ArrayList<>();
		ArrayList<Square> answerMove =  new ArrayList<>();
		
		for(int yPosition = this.currentSquare.yPosition+1;!isOut(this.currentSquare.xPosition, yPosition);yPosition++)
		{
			if(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition));
			}
			else if(this.isOtherGamer(this.currentSquare.xPosition, yPosition, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition));
				break;
			}
			else {
				break;
			}
		}
		
		for(int yPosition= this.currentSquare.yPosition-1;!isOut(this.currentSquare.xPosition, yPosition);yPosition--)
		{
			if(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition));
			}
			else if(this.isOtherGamer(this.currentSquare.xPosition, yPosition, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, yPosition));
				break;
			}
			else {
				break;
			}
		}
		
		for(int xPosition = this.currentSquare.xPosition+1;!isOut(xPosition, this.currentSquare.yPosition);xPosition++)
		{
			if(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition));
			}
			else if(this.isOtherGamer(xPosition, this.currentSquare.yPosition, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition));
				break;
			}
			else {
				break;
			}
		}
		
		for(int xPosition = this.currentSquare.xPosition-1;!isOut(xPosition, this.currentSquare.yPosition);xPosition--)
		{
			if(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition));
			}
			else if(this.isOtherGamer(xPosition, this.currentSquare.yPosition, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(xPosition, this.currentSquare.yPosition));
				break;
			}
			else {
				break;
			}
		}
		
		
		for(Square newSquare: possibleMove)
		{
			if (this.color == Colors.white)
			{
				ChessBoard temporaryChess= currentChessBoardState.clone();
				temporaryChess.setChessAt(newSquare);
				if(!temporaryChess.whiteKing.isCheked())answerMove.add(newSquare);
			}
			if (this.color == Colors.black)
			{
				ChessBoard temporaryChess= currentChessBoardState.clone();
				temporaryChess.setChessAt(newSquare);
				if(!temporaryChess.blackKing.isCheked())answerMove.add(newSquare);
			}
				
		}
		return answerMove;
	}

	@Override
	public Piece copy() {
		return new Rook(player);
	}
}
