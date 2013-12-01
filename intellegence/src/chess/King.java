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
	
	public boolean isCheked(){
		return false;
	}

}
