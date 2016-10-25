/**
 * Class to allow creation of the image for the background
 */
package programming2.bradshawMarina.gui;

import java.awt.image.BufferedImage;
/*
 * @author Marilou Riberdy
 */
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class ImageBufferRenderrer {

    private BufferedImage img;

    public BufferedImage getImg() {
        try {

            // Load the background image
            img = ImageIO.read(new File("../images/background.jpg")); //for Netbeans
            //img = ImageIO.read(new File("images/background.jpg")); //for eclipse
        } // end of try
        catch (IOException exp) {
            JOptionPane.showMessageDialog(null, "The image could not be load", "Error loading image", JOptionPane.INFORMATION_MESSAGE);

        } // end of catch

        return img;
    }

} // end of class

