package chess;

import java.util.ArrayList;

public class ChessBoard {
public static final int DIMENSION=8;
private Square chessFeilds[][];

public ChessBoard(){
	chessFeilds = new Square[DIMENSION][DIMENSION];
	for(int xPosition=0;xPosition<DIMENSION;xPosition++)
		for(int yPosition=0;yPosition<DIMENSION;yPosition++)
			chessFeilds[xPosition][yPosition]= new Square(xPosition,yPosition,new Piece());
}

}
