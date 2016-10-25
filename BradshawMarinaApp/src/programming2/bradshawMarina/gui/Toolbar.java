/**
 * Class to create the GUI components of the top Toolbar Menu
 */
package programming2.bradshawMarina.gui;

/**
 * @Valentina
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Toolbar extends JToolBar implements ActionListener {

    private JButton saveButton;
    private JButton refreshButton;

    private ToolbarListener toolbarListener;

    public Toolbar() {
        // Get rid off the border if you want the toolbar draggable;
        setBorder(BorderFactory.createEtchedBorder());

        saveButton = new JButton();
        saveButton.setToolTipText("Save");
        saveButton.setIcon(Utils.createIcon("/images/Save16.gif"));
        refreshButton = new JButton();
        refreshButton.setIcon(Utils.createIcon("/images/Refresh16.gif"));
        refreshButton.setToolTipText("Refresh");

        saveButton.addActionListener(this);
        refreshButton.addActionListener(this);

        add(saveButton);
        addSeparator();
        add(refreshButton);

    }

    public void setToolbarListener(ToolbarListener listener) {
        this.toolbarListener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();
        if (clicked == saveButton) {
            if (toolbarListener != null) {
                toolbarListener.saveEventOccured();
            }
        } else if (clicked == refreshButton) {
            if (toolbarListener != null) {
                toolbarListener.refreshEventOccured();
            }

        }
    }
}
