/**
 * class to create the GUI components for the general table panel
 */
package programming2.bradshawMarina.gui;

/**
 * @author Valentina
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import programming2.bradshawMarina.model.Customer;

public class TablePanel extends JPanel {

    private JTable table;
    private CustomerTableModel tableModel;
    private JPopupMenu popUp;
    private CustomerTableListener customerTableLister;

    public TablePanel() {

        tableModel = new CustomerTableModel();
        table = new JTable(tableModel);
        popUp = new JPopupMenu();

        table.setRowHeight(30);

        JMenuItem removeItem = new JMenuItem("Delete row");
        JMenuItem detailsItem = new JMenuItem("Show Details");

        popUp.add(removeItem);
        popUp.add(detailsItem);

        table.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().addSelectionInterval(row, row);
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popUp.show(table, e.getX(), e.getY());
                    popUp.show(table, e.getX(), e.getY());
                }
            }

        });
        removeItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (customerTableLister != null) {
                    customerTableLister.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
        });
        detailsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                String customerId = table.getValueAt(row, 0).toString();

                if (customerTableLister != null) {
                    try {
                        customerTableLister.showCustomerDetails(customerId);
                    } catch (Exception e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }

            }
        });
        setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(table);
        setPreferredSize(new Dimension(600, 300));
        add(scrollPane, BorderLayout.CENTER);
    }

    public void setData(List<Customer> db) {
        tableModel.setCustomerData(db);
    }

    public void refresh() {
        tableModel.fireTableDataChanged();

    }

    public void setCustomerTableListener(CustomerTableListener customerTableListener) {
        this.customerTableLister = customerTableListener;

    }
}
