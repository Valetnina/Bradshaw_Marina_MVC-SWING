/**
 * This Class handles the Gui Components of the left side of the mainframe
 */
package programming2.bradshawMarina.gui;

/**
 * @author Valentina
 */

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class HomeFramePanel extends JPanel implements ActionListener {

    private JButton addBtn;
    private JButton manageBtn;
    private JButton availableSlipsBtn;
    private JButton priceListsBtn;
    private HomeFramePanelListener homeFramelistener;

    public void setLHomeFrameistener(HomeFramePanelListener listener) {
        this.homeFramelistener = listener;
    }

    public HomeFramePanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setMinimumSize(dim);

        addBtn = new JButton("ADD A NEW CUSTOMER");
        addBtn.setPreferredSize(new Dimension(200, 200));

        addBtn.addActionListener(this);

        manageBtn = new JButton("MANAGE CUSTOMERS");
        manageBtn.addActionListener(this);

        availableSlipsBtn = new JButton("SLIPS INFO");
        availableSlipsBtn.addActionListener(this);
        priceListsBtn = new JButton("CHECK PRICE");
        priceListsBtn.addActionListener(this);
        availableSlipsBtn.setActionCommand("slipsReport");
        priceListsBtn.setActionCommand("priceLists");

        addBtn.setMnemonic(KeyEvent.VK_O);

        Border outerBorder = BorderFactory.createTitledBorder("Main Menu");
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractButton clicked = (AbstractButton) e.getSource();
        if (clicked == null) {
            if (homeFramelistener != null) {
                homeFramelistener.noneEventOccured();
            }
        } else if (clicked == addBtn) {
            if (homeFramelistener != null) {
                homeFramelistener.addEventOccured();
            }
        } else if (clicked == manageBtn) {
            if (homeFramelistener != null) {
                homeFramelistener.manageEventOccured();
            }

        } else if (clicked == availableSlipsBtn) {
            if (homeFramelistener != null) {
                homeFramelistener.slipsEventOccured();
            }

        } else if (clicked == priceListsBtn) {
            if (homeFramelistener != null) {
                homeFramelistener.priceEventOccured();
            }

        }
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        ///// First row///
        gc.gridy = 0;
        gc.gridx = 0;

        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.BOTH;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(manageBtn, gc);

        ///// Second row///
        gc.gridy++;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(addBtn, gc);

        ///// NExt row///
        gc.gridy++;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(availableSlipsBtn, gc);
        ///// NExt row///

        gc.gridy++;
        gc.gridx = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        add(priceListsBtn, gc);

    }
}
