package chess;

import java.util.ArrayList;

import chess.Player.Colors;
import chess.Player.PlayerTypes;

public class ChessBoard {
public static final int DIMENSION=8;
private Square chessFeilds[][];

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
	chessFeilds[0][1] =  new Square(0,0, new Rook(playerWhite));
	chessFeilds[1][1] =  new Square(1,0, new King(playerWhite));
	chessFeilds[2][1] =  new Square(2,0, new Bishop(playerWhite));
	chessFeilds[3][1] =  new Square(3,0, new Queen(playerWhite));
	chessFeilds[4][1] = new Square(4,0,new Knight(playerWhite));
	chessFeilds[5][1] = new Square(5,0,new Bishop(playerWhite));
	chessFeilds[6][1] = new Square(6,0,new King(playerWhite));
	chessFeilds[7][1] = new Square(7,0,new Rook(playerWhite));
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
		System.out.println("--------------------------------");
		outLine ="";
	}
}

}
