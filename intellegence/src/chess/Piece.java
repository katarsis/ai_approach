package chess;

import chess.Player.PlayerTypes;

public class Piece {
public Player player;
String symbol;
public Piece() {
	player.playerType = PlayerTypes.undefined;
}

public String getSymbol(){
return this.symbol;	
}

}
