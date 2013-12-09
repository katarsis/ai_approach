package chess;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.swing.JPanel;

import java.lang.*;

public class ChessView extends JPanel {
	
	private static void doDrawing(Graphics g) {
	        
	        Graphics2D g2d = (Graphics2D) g;
	        
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            BufferedImage resized = new BufferedImage(200, 300, BufferedImage.TYPE_INT_ARGB_PRE);
            Graphics2D imageGr = (Graphics2D) resized.createGraphics();
	       /* float[] dash1 = {2f, 0f, 2f};
	        float[] dash2 = {1f, 1f, 1f};
	        float[] dash3 = {4f, 0f, 2f};
	        float[] dash4 = {4f, 4f, 1f};

	        g2d.drawLine(20, 40, 250, 40);

	        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);

	        BasicStroke bs2 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);

	        BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);

	        BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT,
	                BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);

	        g2d.setStroke(bs1);
	        g2d.drawLine(20, 80, 250, 80);

	        g2d.setStroke(bs2);
	        g2d.drawLine(20, 120, 250, 120);

	        g2d.setStroke(bs3);
	        g2d.drawLine(20, 160, 250, 160);

	        g2d.setStroke(bs4);
	        g2d.drawLine(20, 200, 250, 200);*/
	        Toolkit tools =  Toolkit.getDefaultToolkit();
	        String imageLink = "/img/chessboard.png";
	        Image img = null;
	        URL url = null;
	        url = imageLink.getClass().getResource(imageLink);
	        img = tools.getImage(url);
	        imageGr.drawImage(img, 0, 0, null);

    }
	    
	 
	@Override
	    public void paintComponent(Graphics g) {
	        
	        super.paintComponent(g);
	        doDrawing(g);
	    }

}
