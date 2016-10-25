/**
 * Class to create Gui components for Information about Slips
 */
package programming2.bradshawMarina.gui;
/**
 * @author Nazar
 */
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import programming2.bradshawMarina.controller.Controller;
import programming2.bradshawMarina.model.Slip;
import programming2.bradshawMarina.model.SlipDAo;

public class InfoForm extends JPanel {

    private JTextArea infoTA;
    private Controller controller;
    private SlipDAo slipDao;
    private String slipInfo;
    private List<Slip> slips;
    private JScrollPane scrollP;

    public InfoForm(String name) {
        controller = new Controller();
        slipDao = new SlipDAo();
        slips = new ArrayList<Slip>();
        infoTA = new JTextArea(40, 50);
        infoTA.setText("Available Slips are :\n");
        //add(infoTA, BorderLayout.CENTER);
        scrollP = new JScrollPane(infoTA);
        setPreferredSize(new Dimension(450, 110));

        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollP);
        setVisible(true);

        slips = controller.getAvailableSlips();
        for (Slip slip : slips) {
            infoTA.setText(infoTA.getText() + "\n" + slip.toString());
        }
        //scrollP.add(infoTA);
        // set the Border for the form
        Border outerBorder = BorderFactory.createTitledBorder("Information about Slips");
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    }

}
