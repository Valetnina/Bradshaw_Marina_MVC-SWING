/**
 * Class to handle the export from file and import from file events from the File menu
 */
package programming2.bradshawMarina.gui;

/**
 * @Valentina
 */
import java.io.File;
import javax.swing.filechooser.FileFilter;

public class CustomerFileFilter extends FileFilter {

    @Override
    public boolean accept(File file) {

        if (file.isDirectory()) {
            return true;
        }

        String name = file.getName();

        String extension = Utils.getFileExtension(name);

        if (extension == null) {
            return false;
        }

        if (extension.equals("xml")) {
            return true;
        }

        return false;
    }

    @Override
    public String getDescription() {
        return "Customers database file (*.xml)";
    }

}
