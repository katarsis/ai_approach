package chess;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;

import java.lang.*;

public class ChessView extends JPanel {
	Image image;
	Image img  = Utilits.loadImage("chessboard.png");
	final int size = 300;
	ChessBoard gameChess; 
	 
	public ChessView(){
		Dimension size = new Dimension(300,300);
		gameChess =  new ChessBoard();
		this.setOpaque(true);
		setSize(size);
	}
	
	private void doDrawing(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            BufferedImage resized = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            imageGr.drawImage(img, 0, 0, size, size, null);
            imageGr.dispose();
            image = resized.getScaledInstance(size, size, 0);
	        //imageGr.drawImage(img, 0, 0, 200,200,null);
	        g2d.drawImage(image, 0, 0, this);
	        g2d.dispose();
    }
	 
	private void drawAllPieces(Graphics g)
	{
		/*
		 * draw all square 
		 * */
		
		for(int xPosition = 0; xPosition<gameChess.DIMENSION; xPosition++)
			for(int yPosition =0; yPosition< gameChess.DIMENSION;yPosition++)
			{
				Square chessSqare = gameChess.getChessFeilds(xPosition, yPosition);
				//chessSqare.piece.Image
			}
	}
	
	@Override
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        doDrawing(g);
	}

}
