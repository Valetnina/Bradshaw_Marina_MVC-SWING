/**
 * Class to create Gui componnets for the check prices form
 */
package programming2.bradshawMarina.gui;

/**
 * @author Marilou
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import programming2.bradshawMarina.controller.Controller;

public class PriceReport extends JPanel {

    // declaration of the JLabels
    private JLabel widthOfBoatLabel,
            annualOrDailyLabel,
            coveredSlipLabel;

    // declaration of the JTextField
    private JTextField widthOfBoatTextField,
            pricetextField;

    // declaration of the JComboBox
    private JComboBox annualOrDailyComboBox;

    // declaration of the JCheckBox
    private JCheckBox coveredSlipCheckBox;

    // declaration of the JButton
    private JButton priceButton;
    private Controller controller;

    public PriceReport(String name) {
        controller = new Controller();
        // construction of the JLabel
        widthOfBoatLabel = new JLabel("Enter the width of the boat (in feet)");
        annualOrDailyLabel = new JLabel("Is this an annual or daily lease?");
        coveredSlipLabel = new JLabel("Check this box if you would like a covered slip");

        // construction of the JTextField
        widthOfBoatTextField = new JTextField(3);
        pricetextField = new JTextField(5);

        // construction of the JcomboBox
        // string array to declare the values
        String[] annualOrDailyStrings = {"Select Below", "Annual", "Daily"};
        // assign the array to the combo box and assign this combo box to the previously declared value
        annualOrDailyComboBox = new JComboBox(annualOrDailyStrings);

        // construction of the JCheckBox
        coveredSlipCheckBox = new JCheckBox();
        coveredSlipCheckBox.setSelected(false);

        // construction of the JButton
        priceButton = new JButton("GET PRICE");

        // reset the layout of the pane
        setLayout(null);

        // set the location of the GUI component
        widthOfBoatLabel.setLocation(88, 20);
        widthOfBoatTextField.setLocation(300, 23);
        annualOrDailyLabel.setLocation(105, 100);
        annualOrDailyComboBox.setLocation(300, 95);
        coveredSlipLabel.setLocation(20, 180);
        coveredSlipCheckBox.setLocation(300, 180);
        priceButton.setLocation(80, 250);
        pricetextField.setLocation(300, 250);

        // set the size of GUI component
        widthOfBoatLabel.setSize(200, 30);
        widthOfBoatTextField.setSize(100, 30);
        annualOrDailyLabel.setSize(200, 30);
        annualOrDailyComboBox.setSize(150, 40);
        coveredSlipLabel.setSize(300, 30);
        coveredSlipCheckBox.setSize(200, 30);
        priceButton.setSize(200, 30);
        pricetextField.setSize(100, 30);

        // add reference variable to the container
        add(widthOfBoatLabel);
        add(widthOfBoatTextField);
        add(annualOrDailyLabel);
        add(annualOrDailyComboBox);
        add(coveredSlipLabel);
        add(coveredSlipCheckBox);
        add(priceButton);
        add(pricetextField);
        widthOfBoatTextField.setText("");
        Border outerBorder = BorderFactory.createTitledBorder("Check the Price " );
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //Register listeners for the button
        priceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double boatWidth = 0;
                try {
                    boatWidth = (widthOfBoatTextField.getText().length() != 0) ? Double.parseDouble(widthOfBoatTextField.getText()) : 0;
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid decimal number in field " + widthOfBoatLabel.getText(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                String typeOfPayement = (annualOrDailyComboBox.getSelectedItem().toString().length() != 0) ? annualOrDailyComboBox.getSelectedItem().toString() : "Daily";
                Boolean isCovered = coveredSlipCheckBox.isSelected();
                double price = controller.getPrices(boatWidth, typeOfPayement, isCovered);
                pricetextField.setText("" + String.format("$%.2f", price));
            }
        });

        // make the pane container visible
    } // end of PriceReportV2 constructor

} // end of PriceReportV2 class

