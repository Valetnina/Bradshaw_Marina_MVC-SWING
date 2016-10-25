/*
 * Class to create GUI components for the Slip Form
 */
package programming2.bradshawMarina.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.Border;
import programming2.bradshawMarina.controller.Controller;
import programming2.bradshawMarina.model.Slip;

/**
 *
 * @author nazarholyanskyy
 */
@SuppressWarnings("serial")
public class SlipForm extends JPanel {

    // Variables declaration                     
    //private JButton jButton1;
    private JCheckBox jCheckBox1;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private SlipFormListenerOne slipFormListenerOne;
    private Controller controller;
    private List<Slip> availableSlipsByWidth;
    private List<Slip> availableSlipsByTypeCovered;
    private String[] availableSlipsByType;
    private String[] availableCoveredSlipsByType;

    private String slipId;
    private boolean isSlipCovered;
    private double slipWidth;
    private boolean isSlipAvailable;
    private Boolean isCovered = true;
    
    public SlipForm() {
        
    }
    
    public SlipForm(boolean isVisible, boolean isCovered, double slipWidth) {
        initComponents(isCovered, slipWidth);
    }

    //@SuppressWarnings("unchecked")
    private void initComponents(Boolean isCovered, double boatWidth) {
        controller = new Controller();
        availableSlipsByWidth = new ArrayList<Slip>();
        availableSlipsByTypeCovered = new ArrayList<Slip>();

        jMenuItem1 = new JMenuItem();
        jMenuItem2 = new JMenuItem();
        jComboBox1 = new JComboBox<>();
        jLabel1 = new JLabel();
        jCheckBox1 = new JCheckBox();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        try {
            availableSlipsByWidth.clear();
            availableSlipsByWidth = controller.getAvailableSlipsByWidth(boatWidth, false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        availableSlipsByType = new String[availableSlipsByWidth.size()];

        int index = 0;
        for (Slip slip : availableSlipsByWidth) {
            slipId = slip.getSlipId();
            slipWidth = slip.getSlipWidth();
            isSlipAvailable = slip.isIsAvailable();
            availableSlipsByType[index] = slipId + " " + (isSlipCovered ? "covered" : "uncovered") + " slip width: " + slipWidth;
            index++;
        }

        jComboBox1.setModel(new DefaultComboBoxModel<>(availableSlipsByType));
        jComboBox1.setEditable(true);
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(jComboBox1);
        jLabel1.setText("Slip info:");

        jCheckBox1.setText("Slip is covered");
        jCheckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        //.addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jCheckBox1)
                                .addComponent(jLabel1)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        //.addGap(43, 43, 43)
                        .addContainerGap(3, Short.MAX_VALUE))
        );

        Border outerBorder = BorderFactory
                .createTitledBorder("Choose the right slip ");
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    }

    public void jCheckBox1ActionPerformed(ActionEvent evt) {
        try {

            availableSlipsByWidth.clear();
            availableSlipsByTypeCovered.clear();
            availableSlipsByTypeCovered = controller.getAvailableSlipsByWidth(15, true);
            availableCoveredSlipsByType = new String[availableSlipsByTypeCovered.size()];

            int index1 = 0;
            for (Slip slip : availableSlipsByTypeCovered) {
                slipId = slip.getSlipId();
                slipWidth = slip.getSlipWidth();
                isSlipAvailable = slip.isIsAvailable();
                availableCoveredSlipsByType[index1] = slipId + " " + (isSlipCovered ? "covered" : "uncovered") + " slip width: " + slipWidth;
                index1++;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        jComboBox1.setModel(new DefaultComboBoxModel<>(availableCoveredSlipsByType));

    }

    public void jComboBox1ActionPerformed(ActionEvent evt) {
        FormEvent ev = new FormEvent(this, jComboBox1.getSelectedObjects()[0].toString().split(" ")[0]);
         if (slipFormListenerOne != null) {
            slipFormListenerOne.slipChosenEventOccured(ev);
        } else {
         }
      // slipFormListenerOne.slipChosenEventOccured(ev);
    }

    public void setSlipFormListenerOne(SlipFormListenerOne slipFormListener) {
        this.slipFormListenerOne = slipFormListener;

    }
    

}
