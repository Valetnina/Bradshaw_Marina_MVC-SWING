/**
 * Class to contain all make the connection of all Gui components of the application
 */
package programming2.bradshawMarina.gui;

/**
 * @author Valentina, Marilou
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import programming2.bradshawMarina.controller.Controller;
import programming2.bradshawMarina.model.Boat;
import programming2.bradshawMarina.model.Lease;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
    //Declare named constant

    public static final int WIDTH_APP = 1000;
    public static final int HEIGHT_APP = 1000;

    private Toolbar toolbar;
    private HomeFramePanel framePanelHome;
    private JPanel emptyframePanelHome;
    private FormFramePanel framePanelCustomerForm;
    private JPanel framePanelTabbedForm;
    private JFileChooser fileChooser;
    private Controller controller;
    private TablePanel tablePanelCustomer;
    private JSplitPane splitPane;
    private JTabbedPane tabPaneCustomer;
    private JPanel detailsTA;
    private JTextArea detailsBoatTA;
    private JTextArea detailsLeaseTA;
    private BoatForm boatForm;
    protected LeaseForm leaseForm;
    protected PriceReport priceForm;
    protected InfoForm infoForm;
    private final JPanel detailsWrapper;
    private SlipForm slipForm;

    /**
     * constructor to set the default properties of the frame
     */
    public MainFrame() {
        super("Bradshaw Marina");
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not set the look and feel");
        }

        setLayout(new BorderLayout());

        toolbar = new Toolbar();
        framePanelHome = new HomeFramePanel();
        emptyframePanelHome = new JPanel();
        // Marilou method to set the background image for an emppty JPanel

        emptyframePanelHome.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        emptyframePanelHome.add(new JLabel(new ImageIcon(
                new ImageBufferRenderrer().getImg())));

        framePanelTabbedForm = new JPanel();

        framePanelCustomerForm = new FormFramePanel();
        boatForm = new BoatForm();
        leaseForm = new LeaseForm();
        slipForm = new SlipForm();
        tablePanelCustomer = new TablePanel();
        //scrollPane= new JScrollPane(tablePanelCustomer);
        // setPreferredSize(new Dimension(450, 110));
        // prefsDialog = new PrefsDialog(this);
        tabPaneCustomer = new JTabbedPane();
        tabPaneCustomer.addTab("Customer Details", tablePanelCustomer);
        tabPaneCustomer.addTab("Search", emptyframePanelHome);
        framePanelTabbedForm.add(tablePanelCustomer);
        detailsTA = new JPanel();
       detailsTA.setLayout(new BorderLayout());
        detailsBoatTA = new JTextArea(12, 25);
        //Border border = BorderFactory.createLineBorder(Color.BLACK);
        //detailsBoatTA.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        detailsBoatTA.setEditable(false);
       // detailsBoatTA.setEnabled(false);
        detailsLeaseTA = new JTextArea(12, 25);
       // detailsLeaseTA.setEnabled(false);
        detailsTA.add(new JLabel("Select customer in the table and click right to see customer Details"), BorderLayout.NORTH);
        detailsWrapper = new JPanel();
         detailsWrapper.setLayout(new GridLayout(1,2));
         
        detailsWrapper.add(detailsBoatTA);
        detailsWrapper.add(detailsLeaseTA);
        detailsTA.add(detailsWrapper, BorderLayout.CENTER);
        //detailsLeaseTA.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        detailsLeaseTA.setEditable(false);
        priceForm = new PriceReport("Check Prices");
        infoForm = new InfoForm("Information about slips");

        framePanelTabbedForm.add(detailsTA);

        // Set the JSpliPane to the home page layout
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, framePanelHome,
                emptyframePanelHome);

        splitPane.setOneTouchExpandable(true);

        controller = new Controller();

        // Populate the table with data
        tablePanelCustomer.setData(controller.getCustomers());

        tablePanelCustomer.setCustomerTableListener(new CustomerTableListener() {
            public void rowDeleted(int row) {
                controller.removeCustomer(row);
            }

            @Override
            public void showCustomerDetails(String customerId)
                    throws Exception {
                // TODO Auto-generated method stub
                detailsBoatTA.setText("");
                controller.showCustomerdetails();
                List<Boat> boats = controller.getBoat();
                List<Lease> contracts = controller.getLeaseContract();
                for (Boat boat : boats) {
                    String id = boat.getCustomerID();
                    if (id.compareTo(customerId) == 0) {
                        detailsBoatTA.setText(boat.toString());
                        break;

                    } else {
                        detailsBoatTA.setText("This Customer doesn't have a boat");
                    }
                    for (Lease lease : contracts) {
                        String idB = lease.getIdCustomer();
                        if (idB.compareTo(customerId) == 0) {
                            detailsLeaseTA.setText(lease.toString());
                            break;
                        } else {
                            detailsLeaseTA.setText("This Customer doesn't have a Lease Contract");
                            
                        }

                        // tablePanelCustomer.refresh();
                    }
                }
            }
        });
        tabPaneCustomer.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int tabIndex = tabPaneCustomer.getSelectedIndex();

                if (tabIndex == 1) {
                    tablePanelCustomer.refresh();
                }

            }
        });

        fileChooser = new JFileChooser();

        fileChooser.addChoosableFileFilter(new CustomerFileFilter());

        setJMenuBar(createMenuBar());
// Set listeners for all the forms
        toolbar.setToolbarListener(new ToolbarListener() {
            public void saveEventOccured() {
                saveCustomerData();
            }

            public void refreshEventOccured() {

                refresh();
            }
        });

        framePanelHome.setLHomeFrameistener(new HomeFramePanelListener() {

            @Override
            public void addEventOccured() {
                // Do when Add Buttoon is clcked

                emptyframePanelHome = framePanelCustomerForm;
                // splitPane.setRightComponent(emptyframePanelHome);
                populateHomeFrame(emptyframePanelHome);
            }

            @Override
            public void manageEventOccured() {
                // Do when Manage Buttoon is clicked
                emptyframePanelHome = framePanelTabbedForm;
                populateHomeFrame(emptyframePanelHome);
            }

            @Override
            public void noneEventOccured() {
                // when no button is clicked
                emptyframePanelHome = new JPanel();
                populateHomeFrame(emptyframePanelHome);
            }

            @Override
            public void priceEventOccured() {
                emptyframePanelHome = priceForm;
                populateHomeFrame(emptyframePanelHome);

            }

            @Override
            public void slipsEventOccured() {
                emptyframePanelHome = infoForm;
                populateHomeFrame(emptyframePanelHome);

            }

        });
        /*
                 /*Set the listener for formPanelCustomerForm (with customer details) to be sent to controller 
                    to the controller from the MainFrame 
         */
        framePanelCustomerForm.setFormListener(new FormListener() {
            //
            public void formEventOccured(FormEvent e) {
                controller.addCustomers(e);

                tablePanelCustomer.refresh();
            }

            @Override
            public void showBoatForm(FormEvent ev) {
                // pass the Customer Id to the boat form
                boatForm.fillBoat(ev);
                // show the add boat form when the form is completed and the
                // button register is clicked

                emptyframePanelHome = boatForm;
                populateHomeFrame(emptyframePanelHome);

            }
        });

        boatForm.setBoatFormListener(new BoatFormListener() {
            @Override
            public void boatformEventOccured(FormEvent e) {
                // TODO Auto-generated method stub
                controller.addBoat(e);
                //controller.assignSlipToBoat();
                try {
                    controller.saveToBoats();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // tablePanelCustomer.refresh();
            }

            @Override
            public void showLeaseForm(FormEvent ev) {
                // pass the Customer Id and slip id to the lease form
                leaseForm.filllLease(ev);

                try {
                    controller.saveToLease();
                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                // show the add boat form when the form is completed and the
                // button register is clicked

                emptyframePanelHome = leaseForm;
                populateHomeFrame(emptyframePanelHome);

            }
        });
         
        leaseForm.setLeaseFormListener(new LeaseFormListener() {
            @Override
            public void leaseformEventOccured(FormEvent e) {
                // TODO Auto-generated method stub
                controller.addLease(e);
                saveCustomerData();
                //refresh();
                try {
                    controller.saveToLease();
                    emptyframePanelHome = framePanelTabbedForm;
                    // splitPane.setRightComponent(emptyframePanelHome);
                    populateHomeFrame(emptyframePanelHome);

                } catch (Exception e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }

            @Override
            public void showCalcualtedData(FormEvent ev) {
                // TODO Auto-generated method stub

            }
        });

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent arg0) {
                // controller.disconnect();
                dispose();
                System.gc();
            }

        });

        add(toolbar, BorderLayout.PAGE_START);
        add(splitPane, BorderLayout.CENTER);
        refresh();

        setMinimumSize(new Dimension(500, 400));
        setSize(WIDTH_APP, HEIGHT_APP);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    /**
     * method to create a menu bar
     *
     * @return
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportDataItem = new JMenuItem("Export Data...");
        JMenuItem importDataItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        JMenuItem prefsItem = new JMenuItem("Preferences...");

        JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Customer Form");
        showFormItem.setSelected(true);

        showMenu.add(showFormItem);
        windowMenu.add(showMenu);
        windowMenu.add(prefsItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        showFormItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) ev.getSource();

                if (menuItem.isSelected()) {
                    splitPane.setDividerLocation((int) framePanelHome
                            .getMinimumSize().getWidth());
                }

                framePanelHome.setVisible(menuItem.isSelected());
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exitItem.setMnemonic(KeyEvent.VK_X);

        prefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                ActionEvent.CTRL_MASK));

        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
                ActionEvent.CTRL_MASK));

        importDataItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
                ActionEvent.CTRL_MASK));

        importDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanelCustomer.refresh();
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not load data from file.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportDataItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION) {
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(MainFrame.this,
                                "Could not save data to file.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                int action = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit the application?",
                        "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

                if (action == JOptionPane.OK_OPTION) {
                    WindowListener[] listeners = getWindowListeners();

                    for (WindowListener listener : listeners) {
                        listener.windowClosing(new WindowEvent(MainFrame.this,
                                0));
                    }
                }
            }
        });

        return menuBar;
    }

    /**
     * Method to refresh the view by sending the message through the controller
     * to the Database Handler
     */
    private void refresh() {
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "Cannot connect to database.",
                    "Database Connection Problem", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            controller.load();
            controller.loadBoats();
            controller.loadLeases();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "Unable to load from database.",
                    "Database Connection Problem", JOptionPane.ERROR_MESSAGE);
            return;
        }
        tablePanelCustomer.refresh();
    }

    /**
     * Method to allow the right side of the screen to be filled with the
     * appropriate formPanel
     *
     * @param rightSidePanelForm
     */
    public void populateHomeFrame(JPanel rightSidePanelForm) {
        if (rightSidePanelForm != null) {
            splitPane.setRightComponent(rightSidePanelForm);
        } else {
            splitPane.setRightComponent(framePanelHome);
        }
    }

    /**
     * Method to send the message through the controller to the database Handler
     * to save Customer filled information from the form
     */
    protected void saveCustomerData() {
        try {
            controller.connect();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "Cannot connect to database.",
                    "Database Connection Problem", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            controller.saveToCustomers();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(MainFrame.this,
                    "Unable to save to database.",
                    "Database Connection Problem", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }
}
