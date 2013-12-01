package chess;

import java.util.ArrayList;

import chess.Player.Colors;

public class Bishop extends Piece{

	public Bishop(Player player){
		super(player);
		this.symbol ="B ";
	}
	@Override
	/*
	 * Function represent all possible move for the pawn on current chess board
	 * @param currentChessBoard	the current state of chess boards
	 */
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		/*
		 * for each square on the diagonal right-up 
		 * if it's empty field or field other player add to possible move
		 * for each square on the diagonal left-down 
		 * if it's empty field or field other player add to possible move
		 * for each possible move if after move the king will attacked remove it move
		 */
		
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
