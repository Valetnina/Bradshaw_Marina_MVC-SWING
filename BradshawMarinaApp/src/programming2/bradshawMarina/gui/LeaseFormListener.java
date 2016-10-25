/**
 * Interface to handle listener events for the Lease Form
 */
package programming2.bradshawMarina.gui;

import programming2.bradshawMarina.gui.FormEvent;

import java.util.EventListener;

public interface LeaseFormListener extends EventListener {

    public void leaseformEventOccured(FormEvent e);

    public void showCalcualtedData(FormEvent ev);
}
