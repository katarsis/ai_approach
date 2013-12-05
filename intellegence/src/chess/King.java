package chess;

import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class King extends Piece {

	public King(Player player){
		super(player);
		this.symbol = "K ";
	}
	@Override
	public ArrayList getAllMovies(ChessBoard currentChessBoardState) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 * function represent the control on attacked king or not
	 *  
	 */
	public boolean isCheked(){
		/*
		 * first step get all pieses how may attaked the current square 
		 * second step get all possible move for king
		 * if all second square is attacked then it's mat
		 * else it's sah
		 */
		
		ArrayList<Square> possibleMoves = new ArrayList<>();
		if(!isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1))possibleMoves.add(new Square(this.currentSquare.xPosition+1, this.currentSquare.yPosition+1));
		if(!isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition))possibleMoves.add(new Square(this.currentSquare.xPosition+1, this.currentSquare.yPosition));
		if(!isOut(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1))possibleMoves.add(new Square(this.currentSquare.xPosition+1, this.currentSquare.yPosition-1));
		if(!isOut(this.currentSquare.xPosition, this.currentSquare.yPosition-1))possibleMoves.add(new Square(this.currentSquare.xPosition, this.currentSquare.yPosition-1));
		if(!isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1))possibleMoves.add(new Square(this.currentSquare.xPosition-1, this.currentSquare.yPosition-1));
		if(!isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition))possibleMoves.add(new Square(this.currentSquare.xPosition-1, this.currentSquare.yPosition));
		if(!isOut(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1))possibleMoves.add(new Square(this.currentSquare.xPosition-1, this.currentSquare.yPosition+1));
		if(!isOut(this.currentSquare.xPosition, this.currentSquare.yPosition+1))possibleMoves.add(new Square(this.currentSquare.xPosition, this.currentSquare.yPosition+1));

		
		return false;
	}
	
	@Override
	public Piece copy() {
		return new King(player);
	}

}
