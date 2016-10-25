/**
 * Class to start Bradshaw Marina app
 */
package programming2;
import javax.swing.SwingUtilities;

import programming2.bradshawMarina.gui.MainFrame;


/**
 * 
 * @author Valentina
 *
 */
public class BradshawMarinaApp {
public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				new MainFrame();
				
				
			}
			
		});
		
		
	}

}
