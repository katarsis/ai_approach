package chess;

public class Square implements Cloneable{
public int xPosition;
public int yPosition;
public Piece piece=null;

public Square(int xPos, int yPos )
{
	this.xPosition = xPos;
	this.yPosition = yPos;
	//this.piece = piece;
}

public Square(Square square){
	this.xPosition = square.xPosition;
	this.yPosition = square.yPosition;
	this.piece 	   = square.piece;
}

public Square clone(){
	return new Square(this);
}

public void setPiece(Piece piece){
	this.piece=piece;
	if(this.piece!=null)
	this.piece.currentSquare = this;
}

public String print(){
	if(piece!=null)
	return piece.getSymbol();
	else
		return "__";
}

public boolean isEmpty(){
	if(this.piece!=null)
		return false;
	return true;
}

}
