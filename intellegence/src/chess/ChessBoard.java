package chess;

import java.util.ArrayList;

import chess.Player.Colors;
import chess.Player.PlayerTypes;

public class ChessBoard {
public static final int DIMENSION=8;
private Square chessFeilds[][];
public King whiteKing;
public King blackKing;

public ChessBoard(){
	chessFeilds = new Square[DIMENSION][DIMENSION];
	for(int xPosition=0;xPosition<DIMENSION;xPosition++)
		for(int yPosition=0;yPosition<DIMENSION;yPosition++)
			chessFeilds[xPosition][yPosition]= new Square(xPosition,yPosition,null);
}

public void setDefaultPieces()
{
	/*
	 * for each sqare in 2 line or 7 line write only pawn
	 * for othe use rule set piece
	 */
	Player playerWhite = new Player(Colors.white,PlayerTypes.human);
	Player playerBlack = new Player(Colors.black, PlayerTypes.computer);

	//set the white pieces
	for(int xPostion = 0; xPostion <DIMENSION; xPostion++)
		chessFeilds[xPostion][1] = new Square(xPostion,1,new Pawn(playerWhite));
	chessFeilds[0][0] =  new Square(0,0, new Rook(playerWhite));
	chessFeilds[1][0] =  new Square(1,0, new King(playerWhite));
	chessFeilds[2][0] =  new Square(2,0, new Bishop(playerWhite));
	chessFeilds[3][0] =  new Square(3,0, new Queen(playerWhite));
	chessFeilds[4][0] = new Square(4,0,new Knight(playerWhite));
	chessFeilds[5][0] = new Square(5,0,new Bishop(playerWhite));
	chessFeilds[6][0] = new Square(6,0,new King(playerWhite));
	chessFeilds[7][0] = new Square(7,0,new Rook(playerWhite));
	chessFeilds[0][0].piece.currentSquare =	chessFeilds[0][0];
	chessFeilds[1][0].piece.currentSquare =	chessFeilds[1][0];
	chessFeilds[2][0].piece.currentSquare =	chessFeilds[2][0];
	chessFeilds[3][0].piece.currentSquare =	chessFeilds[3][0];
	chessFeilds[4][0].piece.currentSquare =	chessFeilds[4][0];
	chessFeilds[5][0].piece.currentSquare =	chessFeilds[5][0];
	chessFeilds[6][0].piece.currentSquare =	chessFeilds[6][0];
	chessFeilds[7][0].piece.currentSquare =	chessFeilds[7][0];
	//set the black pieces
	for(int xPosition =0;xPosition< DIMENSION;xPosition++)
		chessFeilds[xPosition][6] = new Square(xPosition, 6, new Pawn(playerBlack));
	chessFeilds[0][7] =  new Square(0,7, new Rook(playerWhite));
	chessFeilds[1][7] =  new Square(1,7, new King(playerBlack));
	chessFeilds[2][7] =  new Square(2,7, new Bishop(playerBlack));
	chessFeilds[3][7] =  new Square(3,7, new Queen(playerBlack));
	chessFeilds[4][7] = new Square(4,7,new Knight(playerBlack));
	chessFeilds[5][7] = new Square(5,7,new Bishop(playerBlack));
	chessFeilds[6][7] = new Square(6,7,new King(playerBlack));
	chessFeilds[7][7] = new Square(7,7,new Rook(playerBlack));
	chessFeilds[0][7].piece.currentSquare =	chessFeilds[0][7];
	chessFeilds[1][7].piece.currentSquare =	chessFeilds[1][7];
	chessFeilds[2][7].piece.currentSquare =	chessFeilds[2][7];
	chessFeilds[3][7].piece.currentSquare =	chessFeilds[3][7];
	chessFeilds[4][7].piece.currentSquare =	chessFeilds[4][7];
	chessFeilds[5][7].piece.currentSquare =	chessFeilds[5][7];
	chessFeilds[6][7].piece.currentSquare =	chessFeilds[6][7];
	chessFeilds[7][7].piece.currentSquare =	chessFeilds[7][7];
	
}

public void print(){
	String outLine="";
	for(int yPosition=0; yPosition<DIMENSION;yPosition++)
	{
		outLine+="|";
		for(int xPosition =0;xPosition<DIMENSION;xPosition++)
		{
			outLine+=chessFeilds[xPosition][yPosition].print()+"|";
		}
		System.out.println(outLine);
		//System.out.println("-------------------------");
		outLine ="";
	}
}

public Square getChessFeilds(int x, int y) {
	return chessFeilds[x][y];
}

public ChessBoard clone()
{
	ChessBoard returnedChess = new ChessBoard();
	returnedChess.chessFeilds =  new Square[DIMENSION][DIMENSION];
	for(int xPosition =0 ; xPosition<DIMENSION;xPosition++)
		for(int yPosition=0;yPosition<DIMENSION;yPosition++)
			returnedChess.chessFeilds[xPosition][yPosition] = this.chessFeilds[xPosition][yPosition];
	returnedChess.blackKing = this.blackKing;
	returnedChess.whiteKing = this.whiteKing;
	return returnedChess;
}

public void setChessAt(Square setSquare){
	this.chessFeilds[setSquare.xPosition][setSquare.yPosition] = setSquare;
}

}
