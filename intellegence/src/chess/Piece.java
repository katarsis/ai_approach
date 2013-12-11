package chess;

import java.awt.Color;
import java.util.ArrayList;

import chess.Player.Colors;
import chess.Player.PlayerTypes;

public abstract class Piece implements Cloneable{
public Player player;
public Colors color;
public Square currentSquare;
String symbol;

public Piece() {
	player.playerType = PlayerTypes.undefined;
	
}

public Piece(Player player)
{
	this.player =player;
	this.color = player.color;
}

abstract public ArrayList getAllMovies(ChessBoard currentChessBoardState);

public String getSymbol(){
return this.symbol;	
}

public boolean isOut(int x, int y){
	if(x>7||x<0||y>7||y<0)
		return true;
	return false;
}

public boolean isOtherGamer(int x, int y, ChessBoard currentChessBoardState){
	Square chekedFeild = currentChessBoardState.getChessFeilds(x, y);
	if(chekedFeild.piece!=null&&this.player != chekedFeild.piece.player)
		return true;
	return false;
}
public abstract Piece copy();

}
