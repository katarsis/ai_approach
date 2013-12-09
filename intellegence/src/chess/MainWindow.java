package chess;

import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class MainWindow extends JFrame {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainWindow(Composite parent, int style) {
		//super(parent, SWT.NONE);
		this.setSize(448, 414);

	}

	@Override
/*	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}*/
	
	 public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D)g;
		    double x = 15, y = 50, w = 70, h = 70;
		    Ellipse2D e = new Ellipse2D.Double(x, y, w, h);
		    GradientPaint gp = new GradientPaint(75, 75, Color.white,
		        95, 95, Color.gray, true);
		    // Fill with a gradient.
		    g2.setPaint(gp);
		    g2.fill(e);
		    // Stroke with a solid color.
		    e.setFrame(x + 100, y, w, h);
		    g2.setPaint(Color.black);
		    g2.setStroke(new BasicStroke(8));
		    g2.draw(e);
		    // Stroke with a gradient.
		    e.setFrame(x + 200, y, w, h);
		    g2.setPaint(gp);
		    g2.draw(e);
		  }
}


