package chess;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Utilits {
	 public static Image loadImage(String name)
	    {
	        Image img = null;
	        URL url = null;
	        Toolkit tk = Toolkit.getDefaultToolkit();
	        String imageLink = "img/images.org/" + name;
	        url = MainWindow.class.getResource(imageLink);
	        img = tk.getImage(url);
	        return img;
	    }/*--endOf-loadImage--*/

}
