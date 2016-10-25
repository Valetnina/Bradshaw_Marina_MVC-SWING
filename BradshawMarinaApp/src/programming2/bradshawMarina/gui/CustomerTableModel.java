/**
 * Class to set up the model for the Customer information table
 */
package programming2.bradshawMarina.gui;
/**
 * @Author Valentina
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;
import programming2.bradshawMarina.model.Customer;

public class CustomerTableModel extends AbstractTableModel {
    private List<Customer> dbCustomer;
    
	
	private String[] colNames = {"ID", "FName", "LName", "PhoneNo", "Address", "Active"};
	
	public CustomerTableModel() {
	}
	
	
	
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colNames[column];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {

		switch(col) {
		case 0:
			return false;
		default:
			return true;
		}
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		
		if(dbCustomer == null) return;
		
		Customer customer = dbCustomer.get(row);
		
		
		switch(col) {
		case 1:
			customer.setFirstName((String)value);
			break;
		case 2:
			customer.setLastName((String)value);
			break;
		case 3:
			customer.setPhoneNo((String)value);
			break;
		case 4:
			customer.setAddress((String)value);
			break;
		case 5:
			customer.setActive((Boolean)value);
			break;
		default:
			return;
		}
	}

	@Override
	public Class<?> getColumnClass(int col) {
		
		switch(col) {
		case 0:
			return Integer.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return Boolean.class;
				default:
			return null;
		}
	}



	public void setCustomerData(List<Customer> db) {
		this.dbCustomer = db;
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}

	 @Override
	public int getRowCount() {
		if(dbCustomer == null) return 0;
		return dbCustomer.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		if(dbCustomer == null) return null;
		Customer customer = dbCustomer.get(row);
		
		switch(col) {
		case 0:
			return customer.getId();
		case 1:
			return customer.getFirstName();
		case 2:
			return customer.getLastName();
		case 3:
			return customer.getPhoneNo();
		case 4:
			return customer.getAddress();
		case 5:
			return customer.isActive();
			
		}
		
		return null;
	}

}
