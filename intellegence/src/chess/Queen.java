package chess;

import java.util.ArrayList;

import chess.Player.Colors;

public class Queen extends Piece{

	public Queen(Player player){
		super(player);
		this.symbol = "Q ";
	}
	@Override
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		// include metods for bishop and rook
		ArrayList<Square> possibleMove = new ArrayList<>();
		ArrayList<Square> answerMovies = new ArrayList<>();
		
		for(int x=this.currentSquare.xPosition-1, y=this.currentSquare.yPosition+1;!isOut(x, y);x--,y++)
		{
			if(currentChessBoardState.getChessFeilds(x, y).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
			}
			else if(this.isOtherGamer(x, y, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
				break;
			}
			else
			{
				break;
			}
		}
		
		for(int x=this.currentSquare.xPosition+1, y=this.currentSquare.yPosition+1;!isOut(x, y);x++,y++)
		{
			if(currentChessBoardState.getChessFeilds(x, y).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
			}
			else if(this.isOtherGamer(x, y, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
				break;
			}
			else
			{
				break;
			}
		}
		
		for(int x=this.currentSquare.xPosition-1, y=this.currentSquare.yPosition-1;!isOut(x, y);x--,y--)
		{
			if(currentChessBoardState.getChessFeilds(x, y).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
			}
			else if(this.isOtherGamer(x, y, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
				break;
			}
			else
			{
				break;
			}
		}
		
		for(int x=this.currentSquare.xPosition+1, y=this.currentSquare.yPosition-1;!isOut(x, y);x++,y--)
		{
			if(currentChessBoardState.getChessFeilds(x, y).isEmpty())
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
			}
			else if(this.isOtherGamer(x, y, currentChessBoardState))
			{
				possibleMove.add(currentChessBoardState.getChessFeilds(x, y));
				break;
			}
			else
			{
				break;
			}
		}
		
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
				if(!temporaryChess.whiteKing.isCheked())answerMovies.add(newSquare);
			}
			if (this.color == Colors.black)
			{
				ChessBoard temporaryChess= currentChessBoardState.clone();
				temporaryChess.setChessAt(newSquare);
				if(!temporaryChess.blackKing.isCheked())answerMovies.add(newSquare);
			}
				
		}
		return answerMovies;
	}

}
