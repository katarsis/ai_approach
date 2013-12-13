package chess;

import java.awt.Image;
import java.util.ArrayList;

import javax.security.auth.x500.X500Principal;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.ietf.jgss.Oid;

import chess.Player.Colors;

public class King extends Piece {

	protected static final Image imageWhite = Utilits.loadImage("King-W.png");
	protected static final Image imageBlack = Utilits.loadImage("King-B.png");

	public King(Player player){
		super(player);
		this.symbol = "K ";
		if(player.color == Colors.black)
		{
			imagePiece = imageBlack;
		}
		else if(player.color == Colors.white)
		{
			imagePiece = imageWhite;
		}
		originImage = imagePiece;
	}
	@Override
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		// TODO Auto-generated method stub
		
		return getAllPossibleMoves(currentChessBoardState);
	}
	
	
	/*
	 * function wich contorl stalemate situation 
	 */
	public boolean isStalemate()
	{
		/*
		 * frist get all enemy square
		 * if king in possible square then shah
		 * if shah then get all possible king square 
		 * if all possible player square is attacked it's mate 
		 */
		return false;
	}
	
	/*
	 * function represent the control on attacked king or not
	 *  
	 */
	public boolean isCheked(ChessBoard currentChessBoardState){
		//first step get all pieses how may attaked the current square
		ArrayList<Square> enemyPossibleSquare =  new ArrayList<>();
		try{
		for(int xPosition  =0 ; xPosition < currentChessBoardState.DIMENSION; xPosition++)
			for(int yPosition =0; yPosition< currentChessBoardState.DIMENSION; yPosition++)
			{
				Square tempSquare = currentChessBoardState.getChessFeilds(xPosition, yPosition);
				if(tempSquare.piece!=null && tempSquare.piece.color!= this.color)
				{
					enemyPossibleSquare.addAll(tempSquare.piece.getAllPossibleMoves(currentChessBoardState));
				}
			}
		//if in this square current square the it's shah
		for(Square enemySquare: enemyPossibleSquare)
		{
			if(enemySquare.xPosition == this.currentSquare.xPosition && enemySquare.yPosition == this.currentSquare.yPosition)
				return true;
		}
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return false;
	}
	
	@Override
	public Piece copy() {
		return new King(player);
	}
	@Override
	public ArrayList getAllPossibleMoves(ChessBoard currentChessBoardState) {
		// TODO Auto-generated method stub
		ArrayList<Square> possibleMove = new ArrayList<>();
		ArrayList<Square> answerMoves = new ArrayList<>();
		
		if(!this.isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1));
		if(!this.isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition));
		if(!this.isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1));
		if(!this.isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1));
		if(!this.isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition));
		if(!this.isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1));
		if(!this.isOut(this.currentSquare.xPosition, this.currentSquare.yPosition+1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition+1));
		if(!this.isOut(this.currentSquare.xPosition, this.currentSquare.yPosition-1))possibleMove.add(currentChessBoardState.getChessFeilds(this.currentSquare.xPosition, this.currentSquare.yPosition-1));
		
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

