/**
 * Class to create the view of the FrmFramePanel
 */
package programming2.bradshawMarina.gui;

/**
 * @author Valentina
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.UUID;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import programming2.bradshawMarina.model.AnnualLease;
import programming2.bradshawMarina.model.Boat;
import programming2.bradshawMarina.model.Lease;
import programming2.bradshawMarina.model.Sailboat;

public class FormFramePanel extends JPanel {

    private JLabel fNameLabel;
    private JLabel lNameLabel;
    private JTextField fNameField;
    private JTextField lNameField;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JTextField phoneField;
    private JTextField addressField;
    private JButton okBtn;
    private FormListener formListener;
    private JCheckBox isActive;
    private JTextField boatField;
    private JLabel boatLabel;
    private JButton clearBtn;
    int id;

    public FormFramePanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        setMinimumSize(dim);

        fNameLabel = new JLabel("First Name: ");
        lNameLabel = new JLabel("Last Name: ");
        fNameField = new JTextField(10);
        lNameField = new JTextField(10);
        phoneLabel = new JLabel("Phone No: ");
        addressLabel = new JLabel("Address: ");
        phoneField = new JTextField(10);
        addressField = new JTextField(10);
        isActive = new JCheckBox();
        boatField = new JTextField(10);
        boatLabel = new JLabel("Boat Reg No: ");
        // Set up boatField;

        boatLabel.setEnabled(false);
        boatField.setEnabled(false);

        isActive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isTicked = isActive.isSelected();
                boatField.setEnabled(isTicked);
                boatLabel.setEnabled(isTicked);
            }

        });

        okBtn = new JButton("Register");
        clearBtn = new JButton("Clear");

        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = "" + UUID.randomUUID();
                String fName = fNameField.getText();
                String lName = lNameField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                Boat boat = new Sailboat();
                Lease lease = new AnnualLease();

                boolean active = isActive.isSelected();
                /*Create an FormEvent object(customer details) to be sent trough formListener 
                    to the controller from the MainFrame */
                FormEvent ev = new FormEvent(this, id, fName, lName, phone,
                        address, boat, lease, active);

                if (formListener != null) {
                    formListener.formEventOccured(ev);
                    formListener.showBoatForm(ev);

                }

            }

        });
        clearBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Clear all the fields
                fNameField.setText("");
                lNameField.setText("");
                phoneField.setText("");
                addressField.setText("");
                isActive.setSelected(false);
            }
        });
        okBtn.setMnemonic(KeyEvent.VK_O);
        fNameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        fNameLabel.setLabelFor(fNameField);

        Border outerBorder = BorderFactory.createTitledBorder("Add Customer");
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }

    public void layoutComponents() {
        setLayout(new GridLayout(8, 2));

        add(fNameLabel);
        add(fNameField);
        add(lNameLabel);
        add(lNameField);
        add(phoneLabel);
        add(phoneField);
        add(new JLabel("Address: "));
        add(addressField);
        add(new JLabel("Is Active: "));
        add(isActive);
        add(okBtn);
        add(clearBtn);

    }

}
