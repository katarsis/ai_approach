package chess;

import java.util.ArrayList;

import chess.Player.PlayerTypes;

public abstract class Piece {
public Player player;
String symbol;

public Piece() {
	player.playerType = PlayerTypes.undefined;
	
}

public Piece(Player player)
{
	this.player =player;
}

abstract public ArrayList getAllMovies();

public String getSymbol(){
return this.symbol;	
}

}
