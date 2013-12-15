package chess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.JPanel;

import chess.Player.Colors;

import java.lang.*;

public class ChessView extends JPanel {
	Image image;

	Image img  = Utilits.loadImage("chessboard.png");
	Image imageAbleSquare = Utilits.loadImage("able_square.png");
	Image imageSelectedSquare = Utilits.loadImage("sel_square.png");
	final int size = 305;
	ChessBoard gameChess; 
	final int height =38;
	Piece selectedPiece=null; 
	Square selectedSquare =  null;

	public ChessView(){

		Dimension size = new Dimension(300,300);
		gameChess =  new ChessBoard();
		gameChess.setDefaultPieces();

		this.setOpaque(true);
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// represent the man moves 
				//if man select the piece then can move at the possible square
				//if man select the empty square then if selected piece non empty and this square in possible square then move at this
				//if man selected square and this square non empty and exists selected piece then this check piece
				Point pt = e.getPoint();
				Square currentSquare = getSquareByPoint(pt);
				if(currentSquare.piece!=null && selectedPiece==null)
				{
					selectedPiece = currentSquare.piece.copy();
					//selectedPiece.currentSquare = currentSquare.clone();
					selectedPiece.currentSquare = currentSquare;
					selectedSquare =  currentSquare;
					
				}
				else if(currentSquare.piece!=null && selectedPiece!=null )
				{
					if(selectedPiece.color != currentSquare.piece.color)
					{
						selectedPiece.currentSquare.piece =null;
						currentSquare.piece = selectedPiece;
						selectedPiece.currentSquare = currentSquare;
						selectedPiece =null;
						
					}
					else
					{
						if(selectedSquare.xPosition==currentSquare.xPosition&& selectedSquare.yPosition == currentSquare.yPosition)
						{
							selectedPiece = null;
						}
						else
						{
							selectedPiece = currentSquare.piece.copy();
							//selectedPiece.currentSquare = currentSquare.clone();
							selectedPiece.currentSquare = currentSquare;
							selectedSquare =  currentSquare;
						}
					}
					
				}
				else if(selectedPiece!=null)
				{
					selectedPiece.currentSquare.piece =null;
					currentSquare.piece = selectedPiece;
					selectedPiece.currentSquare = currentSquare;
					selectedPiece =null;
					refreshKingSquare(currentSquare);
					//.copy();
					//selectedPiece =null;
				}
				if(gameChess.blackKing.isStalemate(gameChess) || gameChess.whiteKing.isStalemate(gameChess))
					gameChess.setDefaultPieces();
				repaint();
			}
		});
		setSize(size);
	}
	
	public void refreshKingSquare(Square newSquare)
	{
		if(newSquare.piece instanceof King)
		{
			boolean isBlack =(newSquare.piece.color==Colors.black);
			if(isBlack){
				gameChess.blackKing.currentSquare = newSquare;
			}
			else {
				gameChess.whiteKing.currentSquare = newSquare;
			}
		}
	}
	public void drawSelectedSquare(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Point topLeft = new Point(-1, 0);
        int height = 38;
        int x = (selectedSquare.xPosition * height) + topLeft.x;
        int y = (selectedSquare.yPosition * height) + topLeft.y;
        float addX = (height - imageSelectedSquare.getWidth(null)) / 2;
        float addY = (height - imageSelectedSquare.getHeight(null)) / 2;
        if (imageSelectedSquare != null && g != null)
        {
            Image tempImage = imageSelectedSquare;
            Image resizedImage = null;
            BufferedImage resized = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            imageGr.drawImage(tempImage, 0, 0, height, height, null);
            imageGr.dispose();
            resizedImage = resized.getScaledInstance(height, height, 0);
            g2d.drawImage(resizedImage, x, y, this);
         }
	}
	
	public void darwPossibleSquare(Graphics g)
	{
		ArrayList<Square> possibleSquares = selectedPiece.getAllMovies(gameChess);
		for(Square newSquare:possibleSquares)
		{
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	        Point topLeft = new Point(-1, 0);
	        int height = 38;
	        int x = (newSquare.xPosition * height) + topLeft.x;
	        int y = (newSquare.yPosition * height) + topLeft.y;
	        float addX = (height - imageAbleSquare.getWidth(null)) / 2;
	        float addY = (height - imageAbleSquare.getHeight(null)) / 2;
	        if (imageAbleSquare != null && g != null)
	        {
	            Image tempImage = imageAbleSquare;
	            Image resizedImage = null;
	            BufferedImage resized = new BufferedImage(height, height, BufferedImage.TYPE_INT_ARGB_PRE);
	            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
	            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	            imageGr.drawImage(tempImage, 0, 0, height, height, null);
	            imageGr.dispose();
	            resizedImage = resized.getScaledInstance(height, height, 0);
	            g2d.drawImage(resizedImage, x, y, this);
	         }
		}
	}
	
	public Square getSquareByPoint(Point point)
	{
		Square result = null;
		int xPosition = 0;
		int yPosition = 0;
		xPosition = point.x/height;
		yPosition = point.y/height;
		result  = gameChess.getChessFeildsNoCopy(xPosition, yPosition);
		return result;
	}
	
	private void doDrawing(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            BufferedImage resized = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            imageGr.drawImage(img, 0, 0, 348, 348, null);
            imageGr.dispose();
            image = resized.getScaledInstance(348, 348, 0);
	        //imageGr.drawImage(img, 0, 0, 200,200,null);
	        g2d.drawImage(image, 0, 0, this);
	        //g2d.dispose();
    }
	 
	private void drawAllPieces(Graphics g,ImageObserver observer)
	{
		/*
		 * draw all square 
		 * */
		
		for(int xPosition = 0; xPosition<gameChess.DIMENSION; xPosition++)
			for(int yPosition =0; yPosition< gameChess.DIMENSION;yPosition++)
			{
				Square chessSqare = gameChess.getChessFeilds(xPosition, yPosition);
				if(chessSqare.piece != null)
				{
					chessSqare.piece.draw(g,this);
				}
			}
	}
	

	@Override
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        
	        doDrawing(g);
	        drawAllPieces(g, this);
	        if(selectedPiece!=null)
	        {
	        	drawSelectedSquare(g);
	        	darwPossibleSquare(g);
	        }
	        //g.dispose();
	}

}
