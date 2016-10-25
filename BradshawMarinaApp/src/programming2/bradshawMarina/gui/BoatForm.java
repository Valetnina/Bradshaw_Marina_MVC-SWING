/*
 * Create class BoatGUI
 */
package programming2.bradshawMarina.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import programming2.bradshawMarina.model.SlipDAo;

/**
 *
 * @author Olga
 */
@SuppressWarnings("serial")
public class BoatForm extends JPanel {

    private JLabel customerIDL;
    private JTextField customerIDTF;

    private JLabel manufacturerL;
    private JTextField manufacturerTF;

    private JLabel lengthL;
    private JTextField lengthTF;

    private JLabel widthL;
    private JTextField widthTF;

    private JLabel yearL;
    private JTextField yearTF;

    private JLabel registrationNumberL;
    private JTextField registrationNumberTF;

    private ButtonGroup typeBoatBG;
    private JRadioButton sailRB;
    private JRadioButton powerRB;

    private JButton addB;
    private JButton clearB;
    private JButton closeB;

    // panel sailboatPanel
    private JLabel numberSailsL;
    private JTextField numberSailsTF;
    private JLabel depthL;
    private JTextField depthTF;

    private ButtonGroup typeEngineBG;
    private JRadioButton noEngineRB;
    private JRadioButton inboardEngineRB;
    private JRadioButton outboardEngineRB;

    // variables class PowerboatGUI
    private JLabel numberEnginesL;
    private JTextField numberEnginesTF;

    private ButtonGroup typeFuelBG;
    private JRadioButton gasolineRB;
    private JRadioButton dieselRB;

    // declaration for panels
    private JPanel upperPanel;
    private JPanel centerPanel;
    private JPanel boatPanel;
    private JPanel sailboatPanelLeft;
    private JPanel sailboatPanelRight;
    private JPanel powerboatPanel;
    private JPanel lowerPanel;
    // private JPanel lowestPanel;

    // Declare variables to store data from customer form
    private String customerName;

    private BoatFormListener boatformListener;
    private SlipForm slipForm;
    private JButton registerBtn;
    private Boolean isCovered;
    private String chosenSlipId;
    private String slipId;
    private SlipDAo slipDAo = new SlipDAo();

    public BoatForm() {

        customerIDL = new JLabel("Customer ID");
        customerIDTF = new JTextField(20);
        customerIDTF.setEditable(false);
        customerIDTF.setEnabled(false);

        manufacturerL = new JLabel("Manufacturer");
        manufacturerTF = new JTextField(20);

        lengthL = new JLabel("Length");
        lengthTF = new JTextField(20);

        widthL = new JLabel("Width");
        widthTF = new JTextField(20);

        depthL = new JLabel("Keel Depth");
        depthTF = new JTextField(8);

        yearL = new JLabel("Year");
        yearTF = new JTextField(20);

        registrationNumberL = new JLabel("State Registration No");
        registrationNumberTF = new JTextField(20);

        typeBoatBG = new ButtonGroup();
        sailRB = new JRadioButton("Sailboat", true);
        powerRB = new JRadioButton("Powerboat");
        typeBoatBG.add(sailRB);
        typeBoatBG.add(powerRB);

        addB = new JButton("Choose Slip");
        clearB = new JButton("Clear");
        closeB = new JButton("Close");
        registerBtn = new JButton("Add");

        // variables class SailboatGUI
        numberSailsL = new JLabel("Number of Sails");
        numberSailsTF = new JTextField(8);

        typeEngineBG = new ButtonGroup();
        noEngineRB = new JRadioButton("No Engine", true);
        inboardEngineRB = new JRadioButton("Inboard Engine");
        outboardEngineRB = new JRadioButton("Outboard Engine");
        typeEngineBG.add(noEngineRB);
        typeEngineBG.add(inboardEngineRB);
        typeEngineBG.add(outboardEngineRB);

        // variables class PowerboatGUI
        numberEnginesL = new JLabel("Number of Engines");
        numberEnginesTF = new JTextField(20);

        typeFuelBG = new ButtonGroup();
        gasolineRB = new JRadioButton("Gasoline Fuel", true);
        dieselRB = new JRadioButton("Diesel Fuel");
        typeFuelBG.add(gasolineRB);
        typeFuelBG.add(dieselRB);

        // Panels
        upperPanel = new JPanel(new GridLayout(3, 4));
        centerPanel = new JPanel(new FlowLayout());
        boatPanel = new JPanel(new FlowLayout());
        sailboatPanelLeft = new JPanel(new GridLayout(2, 2));
        sailboatPanelRight = new JPanel(new FlowLayout());
        powerboatPanel = new JPanel(new FlowLayout());
        lowerPanel = new JPanel(new FlowLayout());
        // lowestPanel = new JPanel(new FlowLayout());

        slipForm = new SlipForm(false, false, 20);

        addBorder();

        setLayout(new GridLayout(7, 1));

        // add components to upperPanel
        upperPanel.add(customerIDL);
        upperPanel.add(customerIDTF);
        upperPanel.add(registrationNumberL);
        upperPanel.add(registrationNumberTF);
        upperPanel.add(lengthL);
        upperPanel.add(lengthTF);
        upperPanel.add(widthL);
        upperPanel.add(widthTF);
        upperPanel.add(manufacturerL);
        upperPanel.add(manufacturerTF);
        upperPanel.add(yearL);
        upperPanel.add(yearTF);

        // add components to centerPanel
        centerPanel.add(sailRB);
        centerPanel.add(powerRB);

        boatPanel.add(sailboatPanelLeft);
        boatPanel.add(sailboatPanelRight);

        // add components to sailboatPanelLeft
        sailboatPanelLeft.add(numberSailsL);
        sailboatPanelLeft.add(numberSailsTF);
        sailboatPanelLeft.add(depthL);
        sailboatPanelLeft.add(depthTF);

        // add components to sailboatPanelRight
        sailboatPanelRight.add(noEngineRB);
        sailboatPanelRight.add(inboardEngineRB);
        sailboatPanelRight.add(outboardEngineRB);

        // add components to powerboatPanel
        powerboatPanel.add(numberEnginesL);
        powerboatPanel.add(numberEnginesTF);
        powerboatPanel.add(gasolineRB);
        powerboatPanel.add(dieselRB);

        // add components to lowerPanel
        lowerPanel.add(addB);
        lowerPanel.add(clearB);
        // lowerPanel.add(closeB);

        // add all panels to pane
        add(upperPanel);
        add(centerPanel);
        add(boatPanel);
        add(lowerPanel);
        // add(lowestPanel);
        // populateBoatPanel(false, false, slipForm);
        // validate();
        // repaint();

        // add(registerBtn);
        sailRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (sailRB.isSelected()) {
                    boatPanel.removeAll();
                    sailboatPanelLeft.setVisible(true);
                    sailboatPanelRight.setVisible(true);
                    boatPanel.add(sailboatPanelLeft);
                    boatPanel.add(sailboatPanelRight);
                    validate();
                    repaint();
                } else {
                    sailboatPanelLeft.setVisible(false);
                    sailboatPanelRight.setVisible(false);
                }
            }
        });

        powerRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (powerRB.isSelected()) {
                    boatPanel.removeAll();
                    powerboatPanel.setVisible(true);
                    boatPanel.add(powerboatPanel);
                    validate();
                    repaint();
                } else {
                    powerboatPanel.setVisible(false);
                }
            }
        });

        // //////////////////////////////////////////////////////////////////
        registerBtn.addActionListener(new ActionListener() {
            private String customerId = "";
            private String registrationNo = "";
            private double length = 0;
            private double width = 0;
            private String manufacturer = "";
            private int year = 0;
            private String type = "";
            private int numberSails = 0;
            private double depth = 0;
            private String engineType = "";
            private int numberEngines = 0;
            private String fuelType = "";
            // private Boolean isCoveredFromSlip = false;
            private String idSlip = "51";

            @Override
            public void actionPerformed(ActionEvent e) {

                customerId = customerIDTF.getText();
                registrationNo = (registrationNumberTF.getText().length() != 0) ? registrationNumberTF
                        .getText() : "";

                try {
                    length = (lengthTF.getText().length() != 0) ? Double
                            .parseDouble(lengthTF.getText()) : 0;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(
                            null,
                            "please enter decimal number in field:  "
                            + lengthL.getText(),
                            "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }

                try {
                    width = (widthTF.getText().length() != 0) ? Double
                            .parseDouble(widthTF.getText()) : 0;
                } catch (NumberFormatException nfe1) {
                    JOptionPane.showMessageDialog(
                            null,
                            "please enter decimal number in field:  "
                            + widthL.getText(),
                            "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }

                manufacturer = (manufacturerTF.getText().length() != 0) ? manufacturerTF
                        .getText() : "";
                try {
                    year = (yearTF.getText().length() != 0) ? Integer
                            .parseInt(yearTF.getText()) : 0;
                } catch (NumberFormatException nfe2) {
                    JOptionPane.showMessageDialog(
                            null,
                            "please enter correct number in field:  "
                            + yearL.getText(), "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }

                type = sailRB.isSelected() ? "Sailboat" : "PowerBoat";
                try {
                    numberSails = (sailRB.isSelected()) ? ((numberSailsTF
                            .getText().length() != 0) ? Integer
                                    .parseInt(numberSailsTF.getText()) : 0) : 0;
                } catch (NumberFormatException nfe3) {
                    JOptionPane.showMessageDialog(null,
                            "please enter correct number in field:  "
                            + numberSailsL.getText(),
                            "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }
                try {
                    depth = (sailRB.isSelected()) ? ((depthTF.getText()
                            .length() != 0) ? Double.parseDouble(depthTF
                                            .getText()) : 0) : 0;
                    engineType = sailRB.isSelected() ? "noEngine" : "";
                } catch (NumberFormatException nfe3) {
                    JOptionPane.showMessageDialog(
                            null,
                            "please enter correct number in field:  "
                            + depthL.getText(),
                            "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }
                if (sailRB.isSelected() && inboardEngineRB.isSelected()) {
                    engineType = "InboardEngine";
                }
                if (sailRB.isSelected() && outboardEngineRB.isSelected()) {
                    engineType = "outboardEngine";
                }

                try {
                    numberEngines = (powerRB.isSelected()) ? ((numberEnginesTF
                            .getText().length() != 0) ? Integer
                                    .parseInt(numberEnginesTF.getText()) : 0) : 0;
                } catch (NumberFormatException nfe3) {
                    JOptionPane.showMessageDialog(null,
                            "please enter correct number in field:  "
                            + numberEnginesL.getText(),
                            "NumberFormatException",
                            JOptionPane.WARNING_MESSAGE);
                }

                fuelType = (powerRB.isSelected()) ? (gasolineRB.isSelected() ? " gasoline"
                        : "diesel")
                        : "";

                // isCoveredFromSlip = isCovered;
                idSlip = slipId;

                FormEvent ev = new FormEvent(this, customerId, registrationNo,
                        length, width, manufacturer, year, type, numberSails,
                        depth, engineType, numberEngines, fuelType, idSlip,
                        isCovered);

                if (boatformListener != null) {
                    boatformListener.boatformEventOccured(ev);

                    boatformListener.showLeaseForm(ev);

                }
                

            }

        });

        closeB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        addB.addActionListener(new ActionListener() {
            private Object controller;

            @Override
            public void actionPerformed(ActionEvent e) {
                double slipWidth = slipDAo.getSlipWidthChosen((widthTF
                        .getText().length() != 0) ? Double.parseDouble(widthTF
                                        .getText()) : 0);
                //slipForm = new SlipForm(true, false, slipWidth);
                populateBoatPanel(true, false);

            }
        });

        clearB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                manufacturerTF.setText("");
                lengthTF.setText("");
                widthTF.setText("");
                yearTF.setText("");
                registrationNumberTF.setText("");
                numberSailsTF.setText("");
                depthTF.setText("");

            }
        });
        slipForm.setSlipFormListenerOne(new SlipFormListenerOne() {
            @Override
            public void slipChosenEventOccured(FormEvent ev) {
                String slipId = ev.getIdSlip();
            }
        
        });
        
        
    }// end constructor

    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     * Method to pass Values from the CustomerForm to the BoatForm through the
     * listener events
     *
     * @param ev
     */
    public void fillBoat(FormEvent ev) {
        // set the TextField of Customer Id
        customerIDTF.setText("" + ev.getId());
        customerName = ev.getfName() + " " + ev.getlName();
    }

    public void addBorder() {
        // set the Border for the form
        Border outerBorder = BorderFactory
                .createTitledBorder("Add Boat for the Customer " + customerName);
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    }

    public void setBoatFormListener(BoatFormListener boatFormListener) {
        this.boatformListener = boatFormListener;

    }

    public void populateBoatPanel(boolean visible, boolean isCovered) {
        slipForm = new SlipForm(visible, isCovered, ((widthTF.getText().length() != 0) ? Double.parseDouble(widthTF.getText()) : 0));
        add(slipForm);
        add(registerBtn);
        validate();
        repaint();
    }

}// end class
