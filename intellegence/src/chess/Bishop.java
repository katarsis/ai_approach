package chess;

import java.awt.Image;
import java.util.ArrayList;

import chess.Player.Colors;

public class Bishop extends Piece{

	protected static final Image imageWhite = Utilits.loadImage("Bishop-W.png");
	protected static final Image imageBlack = Utilits.loadImage("Bishop-B.png");


	public Bishop(Player player){
		super(player);
		this.symbol ="B ";
		this.utility =7;
		if(player.color == Colors.black)
		{
			imagePiece = imageBlack;
		}
		else if(player.color ==  Colors.white)
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
		
		ArrayList<Square> possibleMove = new ArrayList<>();
		possibleMove = getAllPossibleMoves(currentChessBoardState);
		return getSafetyState(currentChessBoardState, possibleMove, currentSquare);
	}
	@Override
	public Piece copy() {
		return new Bishop(this.player);
	}
	
	@Override
	public ArrayList getAllPossibleMoves(ChessBoard currentChessBoardState) {
		/*
		 * for each square on the diagonal right-up 
		 * if it's empty field or field other player add to possible move
		 * for each square on the diagonal left-down 
		 * if it's empty field or field other player add to possible move
		 * for each possible move if after move the king will attacked remove it move
		 */
		ArrayList<Square> possibleMove = new ArrayList<>();
			
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
		return possibleMove;
	}

}
