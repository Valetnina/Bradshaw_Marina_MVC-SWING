/**
 * Interface to handle listener events from the form to the Mainframe
 */
package programming2.bradshawMarina.gui;
/**
 * @author Valentina
 */
import java.util.EventListener;

public interface FormListener extends EventListener {

    public void formEventOccured(FormEvent e);

    public void showBoatForm(FormEvent ev);
}
