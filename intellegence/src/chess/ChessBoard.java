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
			{
				chessFeilds[xPosition][yPosition]= new Square(xPosition,yPosition);
				chessFeilds[xPosition][yPosition].setPiece(null);
			}
}

public void setDefaultPieces()
{
	/*
	 * for each sqare in 2 line or 7 line write only pawn
	 * for othe use rule set piece
	 */
	Player playerWhite = new Player(Colors.white,PlayerTypes.human);
	Player playerBlack = new Player(Colors.black, PlayerTypes.computer);

	//reset all pieces
	for(int xPosition =0; xPosition<DIMENSION; xPosition++)
		for(int yPosition=0; yPosition < DIMENSION; yPosition++)
		{
			chessFeilds[xPosition][yPosition].piece =  null;
		}
	//set the white pieces
	for(int xPostion = 0; xPostion <DIMENSION; xPostion++)
		{
			chessFeilds[xPostion][1] = new Square(xPostion,1);
			chessFeilds[xPostion][1].setPiece(new Pawn(playerBlack));
		}
	chessFeilds[0][0] = new Square(0,0);
	chessFeilds[1][0] = new Square(1,0);
	chessFeilds[2][0] = new Square(2,0);
	chessFeilds[3][0] = new Square(3,0);
	chessFeilds[4][0] = new Square(4,0);
	chessFeilds[5][0] = new Square(5,0);
	chessFeilds[6][0] = new Square(6,0);
	chessFeilds[7][0] = new Square(7,0);
	chessFeilds[0][0].setPiece(new Rook(playerBlack));
	chessFeilds[1][0].setPiece(new Knight(playerBlack));
	chessFeilds[2][0].setPiece(new Bishop(playerBlack));
	chessFeilds[3][0].setPiece(new Queen(playerBlack));
	chessFeilds[4][0].setPiece(new King(playerBlack));
	chessFeilds[5][0].setPiece(new Bishop(playerBlack));
	chessFeilds[6][0].setPiece(new Knight(playerBlack));
	chessFeilds[7][0].setPiece(new Rook(playerBlack));
	chessFeilds[0][0].piece.currentSquare =	chessFeilds[0][0];
	chessFeilds[1][0].piece.currentSquare =	chessFeilds[1][0];
	chessFeilds[2][0].piece.currentSquare =	chessFeilds[2][0];
	chessFeilds[3][0].piece.currentSquare =	chessFeilds[3][0];
	chessFeilds[4][0].piece.currentSquare =	chessFeilds[4][0];
	chessFeilds[5][0].piece.currentSquare =	chessFeilds[5][0];
	chessFeilds[6][0].piece.currentSquare =	chessFeilds[6][0];
	chessFeilds[7][0].piece.currentSquare =	chessFeilds[7][0];
	blackKing = (King)chessFeilds[4][0].piece;
	//set the black pieces
	for(int xPosition =0;xPosition< DIMENSION;xPosition++)
		{
			chessFeilds[xPosition][6] = new Square(xPosition, 6);
			chessFeilds[xPosition][6].setPiece( new Pawn(playerWhite));
		}
	chessFeilds[0][7] = new Square(0,7);
	chessFeilds[1][7] = new Square(1,7);
	chessFeilds[2][7] = new Square(2,7);
	chessFeilds[3][7] = new Square(3,7);
	chessFeilds[4][7] = new Square(4,7);
	chessFeilds[5][7] = new Square(5,7);
	chessFeilds[6][7] = new Square(6,7);
	chessFeilds[7][7] = new Square(7,7);
	chessFeilds[0][7].setPiece(new Rook(playerWhite));
	chessFeilds[1][7].setPiece(new Knight(playerWhite));
	chessFeilds[2][7].setPiece(new Bishop(playerWhite));
	chessFeilds[3][7].setPiece(new Queen(playerWhite));
	chessFeilds[4][7].setPiece(new King(playerWhite));
	chessFeilds[5][7].setPiece(new Bishop(playerWhite));
	chessFeilds[6][7].setPiece(new Knight(playerWhite));
	chessFeilds[7][7].setPiece(new Rook(playerWhite));
	chessFeilds[0][7].piece.currentSquare =	chessFeilds[0][7];
	chessFeilds[1][7].piece.currentSquare =	chessFeilds[1][7];
	chessFeilds[2][7].piece.currentSquare =	chessFeilds[2][7];
	chessFeilds[3][7].piece.currentSquare =	chessFeilds[3][7];
	chessFeilds[4][7].piece.currentSquare =	chessFeilds[4][7];
	chessFeilds[5][7].piece.currentSquare =	chessFeilds[5][7];
	chessFeilds[6][7].piece.currentSquare =	chessFeilds[6][7];
	chessFeilds[7][7].piece.currentSquare =	chessFeilds[7][7];
	whiteKing = (King)chessFeilds[4][7].piece;
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
		outLine ="";
	}
}



public Square getChessFeilds(int x, int y) {
	return chessFeilds[x][y].clone();
}

public Square getChessFeildsNoCopy(int x, int y) {
	return chessFeilds[x][y];
}
public ChessBoard clone()
{
	ChessBoard returnedChess = new ChessBoard();
	returnedChess.chessFeilds =  new Square[DIMENSION][DIMENSION];
	for(int xPosition =0 ; xPosition<DIMENSION;xPosition++)
		for(int yPosition=0;yPosition<DIMENSION;yPosition++)
			returnedChess.chessFeilds[xPosition][yPosition] = this.chessFeilds[xPosition][yPosition].clone();
	returnedChess.blackKing = this.blackKing;
	returnedChess.whiteKing = this.whiteKing;
	return returnedChess;
}

public void setChessAt(Square setSquare, Square setterSquare){
	this.chessFeilds[setSquare.xPosition][setSquare.yPosition] = setterSquare.clone();
	this.chessFeilds[setterSquare.xPosition][setterSquare.yPosition].piece = null;
}

@Override
public String toString() {
	String outLine="";
	for(int yPosition=0; yPosition<DIMENSION;yPosition++)
	{
		outLine+="|";
		for(int xPosition =0;xPosition<DIMENSION;xPosition++)
		{
			outLine+=chessFeilds[xPosition][yPosition].print()+"|";
		}
		outLine+=System.lineSeparator();
		
	}
	return outLine;
}
}
