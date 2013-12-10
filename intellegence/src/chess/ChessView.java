package chess;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;

import java.lang.*;

public class ChessView extends JPanel {
	Image image;
	
	public ChessView(){
		Dimension size = new Dimension(400,400);
		setSize(size);
		setLayout(null);
	}
	
	private void doDrawing(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            BufferedImage resized = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
            imageGr.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            Toolkit tools =  Toolkit.getDefaultToolkit();
	        String imageLink = "img/images.org/chessboard.png";
	        Image img = null;
	        
	        URL url = null;
	        url = getClass().getResource(imageLink);
	        
	        img = tools.getImage(url);
	        imageGr.drawImage(img, 0, 0, 400, 400, null);
            imageGr.dispose();
             image = resized.getScaledInstance(400, 400, 0);
	        //imageGr.drawImage(img, 0, 0, 200,200,null);
	        g2d.drawImage(image, 0, 0, null);
	        
	        
	  
	        
    }
	 
	@Override
	public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        doDrawing(g);
	}

}
