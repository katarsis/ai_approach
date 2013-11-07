package TicTacToe;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;

public class MainWindow extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public MainWindow(Composite parent, int style) {
		super(parent, SWT.NONE);
		this.setSize(254, 203);
		
		Button button = new Button(this, SWT.NONE);
		button.setText("New Button");
		button.setBounds(100, 29, 42, 37);
		
		Button button_1 = new Button(this, SWT.NONE);
		button_1.setText("New Button");
		button_1.setBounds(148, 29, 42, 37);
		
		Button button_2 = new Button(this, SWT.NONE);
		button_2.setText("New Button");
		button_2.setBounds(52, 72, 42, 37);
		
		Button button_3 = new Button(this, SWT.NONE);
		button_3.setText("New Button");
		button_3.setBounds(100, 72, 42, 37);
		
		Button button_4 = new Button(this, SWT.NONE);
		button_4.setText("New Button");
		button_4.setBounds(148, 72, 42, 37);
		
		Button button_5 = new Button(this, SWT.NONE);
		button_5.setText("New Button");
		button_5.setBounds(52, 115, 42, 37);
		
		Button button_6 = new Button(this, SWT.NONE);
		button_6.setText("New Button");
		button_6.setBounds(100, 115, 42, 37);
		
		Button button_7 = new Button(this, SWT.NONE);
		button_7.setText("New Button");
		button_7.setBounds(148, 115, 42, 37);
		
		Button button_8 = new Button(this, SWT.NONE);
		button_8.setText("New Button");
		button_8.setBounds(52, 29, 42, 37);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
