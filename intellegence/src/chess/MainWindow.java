package chess;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class MainWindow extends JFrame {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	static Image img;
	public MainWindow() {
		super();
		
	}
	
	public final void initUI(){
		ChessView pnl = new ChessView();
		pnl.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pnl.repaint();
		pnl.setVisible(true);
		this.setSize(310, 340);
		this.getContentPane().add(pnl);
		this.validate();
		setTitle("Chess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }    
	
	
	 public static void main(String[] args) {
	       SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	new MainWindow().initUI();
	            }
	        });

	    }

	
}


