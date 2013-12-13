package chess;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import java.util.ArrayList;

import chess.Player.Colors;
import chess.Player.PlayerTypes;

public abstract class Piece implements Cloneable{
public Player player;
public Colors color;
public Square currentSquare;
String symbol;

public Image imagePiece;
protected Image imageWhite;
protected Image imageBlack;
protected Image originImage;

public Piece() {
	player.playerType = PlayerTypes.undefined;
	
}

public Piece(Player player)
{
	this.player =player;
	this.color = player.color;
}

abstract public ArrayList getAllMovies(ChessBoard currentChessBoardState);
abstract public ArrayList getAllPossibleMoves(ChessBoard currentChessBoardState); 

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
/*
 * function draw get from joChess.org
 */
public void draw(Graphics g, ImageObserver obs)
{
	try{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Point topLeft = new Point(5, 0);
        int height = 38;
        int x = (this.currentSquare.xPosition * height) + topLeft.x;
        int y = (this.currentSquare.yPosition * height) + topLeft.y;
        float addX = (height - imagePiece.getWidth(null)) / 2;
        float addY = (height - imagePiece.getHeight(null)) / 2;
        if (imagePiece != null && g != null)
        {
            Image tempImage = originImage;
            BufferedImage resized = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            imageGr.drawImage(tempImage, 0, 0, height, height, null);
            imageGr.dispose();
            imagePiece = resized.getScaledInstance(height-17, height-1, 0);
            g2d.drawImage(imagePiece, x, y, obs);
            
        }
        else
        {
            System.out.println("image is null!");
        }
     }
     catch (java.lang.NullPointerException exc)
     {
       exc.printStackTrace();
    	 //  System.out.println("Something wrong when painting piece: " + exc.getMessage());
     }
}
/*
 * @function  control the possible safety moves
 * @param	currentChessBoard	the current state on the chess board
 * @param	possibleState		the list square wich possible for current piece
 * @param	currentSquare		the selected piece square 
 * @return	list of the square move on wich king is safety
 */
public ArrayList<Square> getSafetyState(ChessBoard currentChessBoard, ArrayList<Square> possibleState, Square currentSquare)
{
	ArrayList<Square> answerMoves = new ArrayList<>();
	for(Square newSquare: possibleState)
	{
		if (this.color == Colors.white)
		{
			ChessBoard temporaryChess= currentChessBoard.clone();
			temporaryChess.setChessAt(newSquare);
			if(!temporaryChess.whiteKing.isCheked(temporaryChess))answerMoves.add(newSquare);
		}
		if (this.color == Colors.black)
		{
			ChessBoard temporaryChess= currentChessBoard.clone();
			temporaryChess.setChessAt(newSquare);
			if(!temporaryChess.blackKing.isCheked(temporaryChess))answerMoves.add(newSquare);
		}
	}
	return answerMoves;	
}

public Piece copy()
{
	return null;	
}

}
