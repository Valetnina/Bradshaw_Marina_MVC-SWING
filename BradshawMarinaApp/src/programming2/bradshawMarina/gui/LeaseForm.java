/**
 * Declare a class named LeaseGui01
 */
package programming2.bradshawMarina.gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author valeriy hohin, Olga
 */
public class LeaseForm extends JPanel {
    // declare named constant and variables

    private static int WIDTH = 550;
    private static int HEIGHT = 350;

    // declare reference variables to GUI components
    // private JTabbedPane tp = new JTabbedPane();
    private JPanel leasePanel = new JPanel();
    private JPanel centerLasePanel = new JPanel();
    private JPanel radioPanel = new JPanel();
    private JPanel changePanel = new JPanel();
    private JPanel dailyLeasePanel = new JPanel();
    private JPanel commonLeasePanel = new JPanel();
    private JPanel annualLeasePanel = new JPanel(new FlowLayout());
    private JPanel buttonPanel = new JPanel();

    private JLabel idCustomerL, idSlipL, startDateL, dailyNumberOfDaysL, annualTypePaymentL;
    private JTextField idCustomerTF, idSlipTF, startDateTF, dailyNumberOfDaysTF;
    private JRadioButton dailyRB, annualRB;
    private ButtonGroup groupB;
    private JButton applyBtn;
    private JButton clearBtn;
    private JComboBox annualCB;
    private JDatePickerImpl datePicker;

    int i = 0;
    private LeaseFormListener leaseFormListener;
    private String customerID;
    private String slipId;

    public LeaseForm() {
// Initiazize refernce variables dailyLeasePanel

        idCustomerL = new JLabel("CUSTOMER ID");
        idCustomerL.setForeground(Color.GRAY);
        idCustomerL.setFont(new Font("Calibri", Font.BOLD, 14));
        idSlipL = new JLabel("SLIP ID");
        idSlipL.setForeground(Color.GRAY);
        idSlipL.setFont(new Font("Calibri", Font.BOLD, 14));
        startDateL = new JLabel("START DATE");
        startDateL.setForeground(Color.DARK_GRAY);
        startDateL.setFont(new Font("Calibri", Font.BOLD, 14));

        idCustomerTF = new JTextField(10);
        idCustomerTF.setEditable(false);
        idCustomerTF.setBackground(Color.LIGHT_GRAY);
        idCustomerTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        idSlipTF = new JTextField(10);
        idSlipTF.setEditable(false);
        idSlipTF.setBackground(Color.LIGHT_GRAY);
        idSlipTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        dailyRB = new JRadioButton("DAILY");
        dailyRB.setFont(new Font("Calibri", Font.BOLD, 14));
        dailyRB.setForeground(Color.DARK_GRAY);
        annualRB = new JRadioButton("ANNUAL");
        annualRB.setForeground(Color.DARK_GRAY);
        annualRB.setFont(new Font("Calibri", Font.BOLD, 14));
        groupB = new ButtonGroup();
        groupB.add(dailyRB);
        groupB.add(annualRB);
        dailyRB.setSelected(true);

        UtilDateModel model = new UtilDateModel();
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        model.setDate(year, month, day);
        model.setDate(year, month, day);
        model.setSelected(true);
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);

        datePicker.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        datePicker.setBackground(Color.WHITE);

        add(datePicker);

        //components of dailyLeasePanel
        dailyNumberOfDaysL = new JLabel("NUMBER OF DAYS");
        dailyNumberOfDaysL.setForeground(Color.DARK_GRAY);
        dailyNumberOfDaysL.setFont(new Font("Calibri", Font.BOLD, 14));
        dailyNumberOfDaysTF = new JTextField(5);
        dailyNumberOfDaysTF.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        dailyNumberOfDaysTF.setFont(new Font("Calibri", Font.BOLD, 18));

        applyBtn = new JButton("APPLY");
        applyBtn.setForeground(Color.BLUE);
        applyBtn.setFont(new Font("Calibri", Font.BOLD, 18));
        applyBtn.setPreferredSize(new Dimension(200, 80));
        // dailyApplyB.addActionListener(this);

        clearBtn = new JButton("CLEAR");
        clearBtn.setFont(new Font("Calibri", Font.BOLD, 18));
        clearBtn.setForeground(Color.RED);

        clearBtn.setPreferredSize(new Dimension(200, 80));

        //components of annualLeasePanel
        annualTypePaymentL = new JLabel("TYPE OF PAYMENT");
        annualTypePaymentL.setForeground(Color.DARK_GRAY);
        annualTypePaymentL.setFont(new Font("Calibri", Font.BOLD, 14));
        String[] payType = {"monthly", "annual"};
        final JComboBox annualCB = new JComboBox(payType);

        setLayout(new GridLayout(4, 1));

        //centerLasePanel.add(leasePanel,BorderLayout.CENTER);
        add(leasePanel);
        add(radioPanel);
        add(changePanel);
        add(buttonPanel);

        commonLeasePanel.add(this);

        buttonPanel.add(clearBtn);
        buttonPanel.add(applyBtn);

        // add reference variables of GUI components 
        leasePanel.setLayout(null);

        idCustomerL.setLocation(5, 10);
        idCustomerL.setSize(220, 30);

        idSlipL.setLocation(230, 10);
        idSlipL.setSize(200, 30);

        startDateL.setLocation(435, 10);
        startDateL.setSize(150, 30);

        idCustomerTF.setLocation(5, 50);
        idCustomerTF.setSize(220, 30);

        idSlipTF.setLocation(230, 50);
        idSlipTF.setSize(200, 30);

        datePicker.setLocation(435, 50);
        datePicker.setSize(150, 30);

        leasePanel.add(idCustomerL);
        leasePanel.add(idSlipL);
        leasePanel.add(startDateL);
        leasePanel.add(idCustomerTF);
        leasePanel.add(idSlipTF);
        leasePanel.add(datePicker);

        radioPanel.add(dailyRB);
        radioPanel.add(annualRB);

        dailyLeasePanel.add(dailyNumberOfDaysL);
        dailyLeasePanel.add(dailyNumberOfDaysTF);

        changePanel.add(dailyLeasePanel);

        annualLeasePanel.add(annualTypePaymentL);
        annualLeasePanel.add(annualCB);

        setSize(WIDTH, HEIGHT);
        setVisible(true);

        applyBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Integer.parseInt(dailyNumberOfDaysTF.getText());
                    int idLease = ++i;
                    String customerId = idCustomerTF.getText();
                    String slipId = idSlipTF.getText();
                    String typeOfLease = dailyRB.isSelected() ? "Daily" : "Annual";
                    Date startDate = (Date) datePicker.getModel().getValue();
                    int daysNo = 0;
                    if(dailyRB.isSelected()) {
                        try {
                         daysNo = (dailyNumberOfDaysTF.getText().length() != 0) ? Integer
                            .parseInt(dailyNumberOfDaysTF.getText()) : daysNo;
                        } catch (NumberFormatException me) {
                    JOptionPane.showMessageDialog(null, "Number Of Days is not number. Write it again.", "ERROR ENTER DATAS", JOptionPane.ERROR_MESSAGE);
                }//end catch 
                    }
                    
                    String typeOfPayement = (dailyRB.isSelected() ? "Not Supported" : annualCB.getSelectedItem().toString());
                    FormEvent ev = new FormEvent(this, customerId, startDate,
                            idLease, typeOfLease, slipId, typeOfPayement, daysNo);

                    if (leaseFormListener != null) {
                        leaseFormListener.leaseformEventOccured(ev);

                        // leaseformListener.showLeaseForm(ev);
                        JOptionPane.showMessageDialog(null, "Customer was successfully added to the database", "Registration Succeded", JOptionPane.INFORMATION_MESSAGE);

                    }// end if statement
                }// end try                                
                
                catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Coould not register customer", "Error Registration", JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                }//end catch   

            }
        });
        clearBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "OK.");
            }
        });

        addBorder();
        setSize(WIDTH, HEIGHT);
        setVisible(true);

        dailyRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (dailyRB.isSelected()) {
                    changePanel.removeAll();
                    dailyLeasePanel.setVisible(true);
                    changePanel.add(dailyLeasePanel);
                    validate();
                    repaint();
                } else {
                    dailyLeasePanel.setVisible(false);
                }
            }
        });

        annualRB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (annualRB.isSelected()) {
                    changePanel.removeAll();
                    annualLeasePanel.setVisible(true);
                    changePanel.add(annualLeasePanel);
                    validate();
                    repaint();
                } else {
                    annualLeasePanel.setVisible(false);
                }
            }
        }
        );

    }//end constructor AdvancedGUIs

    public void filllLease(FormEvent ev) {
        // set the TextField of Customer Id and Slip Id
        idCustomerTF.setText(ev.getId());
       // idSlipTF.setText(ev.getIdSlip());
        idSlipTF.setText("B29");

    }

    public void addBorder() {
        // set the Border for the form  

        Border outerBorder = BorderFactory.createTitledBorder("ADD LEASE CONTRACT");
        // .createTitledBorder(innerBorder , "ADD LEASE CONTRACT", LEFT , BELOW_BOTTOM , new Font("Calibri", Font.BOLD, 12), Color.DARK_GRAY);
        //
        Border innerBorder = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

    }

    public void setLeaseFormListener(LeaseFormListener leaseFormListener) {
        this.leaseFormListener = leaseFormListener;

    }

}// end class LeaseForm
