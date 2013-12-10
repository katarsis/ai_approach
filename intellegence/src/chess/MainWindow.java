package chess;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

import javax.swing.JPanel;

public class MainWindow extends JFrame {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainWindow() {
		super();
		initUI();
	}
	
	public final void initUI(){
		ChessView pnl = new ChessView();
		Container con =  getContentPane();
		con.setLayout(null);
		con.add(pnl);
		setSize(400, 400);
        setTitle("Lines");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
	}    
	
	
	 public static void main(String[] args) {
	       SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	            	MainWindow ex = new MainWindow();
	            }
	        });

	    }

	
}


