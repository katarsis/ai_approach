package chess;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import chess.Player.Colors;
import chess.Player.PlayerTypes;

public class moves_test {

	@Test
	public void test() {
		ChessBoard testChessBoard = new ChessBoard();
		Rook rook = new Rook(new Player(Colors.black,PlayerTypes.computer));
		rook.currentSquare = new Square(0, 0);
		/*ArrayList<Square> moves = rook.getAllMovies(testChessBoard);
		if(moves.size()>0)
		{
			
		}
		else
		{
		fail("Not yet implemented");
		}*/
	}

}
