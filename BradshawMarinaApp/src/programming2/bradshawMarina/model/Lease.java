/**
 * Declare an Abstract class named Lease
 */
package programming2.bradshawMarina.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author valeriy hohin
 */
public abstract class Lease {
	// declare variables
	private final double DISCOUNT_RATE = 0.0;
	protected double amount;
	protected Date startDate;
	protected Date endDate;
	protected int idLease;
	protected String idCustomer;
	protected String idSlip;
	protected Slip slip;

	/**
	 * Default constructor
	 */
	public Lease() {
		this.amount = 0;
		this.startDate = new Date();
		this.endDate = new Date();
		this.idLease = 0;
		this.idCustomer = "";
		this.idSlip = "";
		this.slip = new Slip();
	}// end default constructo

	/**
	 * CONSTRUCTOR with parameters used to store the object in database
	 * 
	 * @param aStartDate
	 * @param aIdLease
	 * @param aIdCustomer
	 * @param aIdSlip
	 */
	public Lease(Date aStartDate, int aIdLease, String aIdCustomer,
			String aIdSlip, Slip slip) {
		this.startDate = aStartDate;
		this.idLease = aIdLease;
		this.idCustomer = aIdCustomer;
		this.idSlip = aIdSlip;
		this.slip = slip;
	}// end contructor with parameters

	/**
	 * construtor used to create object to be retrieved from database
	 * 
	 * @param aStartDate
	 * @param aIdLease
	 * @param aIdCustomer
	 * @param aIdSlip
	 */
	public Lease(Date aStartDate, int aIdLease, String aIdCustomer,
			String aIdSlip) {
		this.startDate = aStartDate;
		this.idLease = aIdLease;
		this.idCustomer = aIdCustomer;
		this.idSlip = aIdSlip;
	}// end contructor with parameters

	// SETTERS
	/**
	 * @param aAmount
	 *            the amount to set
	 */
	public void setAmount(double aAmount) {
		this.amount = aAmount;
	}// end setAmount

	/**
	 * @param aStartDate
	 *            the startDate to set
	 */

	/**
	 * @param idLease
	 *            the idLease to set
	 */
	public void setIdLease(int idLease) {
		this.idLease = idLease;
	}// end setIdLease

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @param idCustomer
	 *            the idCustomer to set
	 */
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}// end setIdCustomer

	/**
	 * @param idSlip
	 *            the idSlip to set
	 */
	public void setIdSlip(String idSlip) {
		this.idSlip = idSlip;
	}// end setIdSlip

	// GETTERS
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}// end getAmount

	

	/**
	 * @return the idLease
	 */
	public int getIdLease() {
		return idLease;
	}// end getIdLease

	/**
	 * @return the idCustomer
	 */
	public String getIdCustomer() {
		return idCustomer;
	}// end getIdCustomer

	/**
	 * @return the idSlip
	 */
	public String getIdSlip() {
		return idSlip;
	}// end getIdSlip

	// abstract method calculateFee()
	public abstract double calculateFee();

	public Slip getSlip() {
		return slip;
	}

	public void setSlip(Slip slip) {
		this.slip = slip;
	}
      
	@Override
	public String toString() {
		return "Contract No: " + getIdLease() + "\namount at the due paiement date $" + String.format("%.2f",getAmount())
				+ "\nStart Date: " + getStartDate().toString() + "\nEnd Date: "
				+ getEndDate() + "\nSlip No: " + slip.getSlipId() + "\nSlip Width: " 
                        + slip.getSlipWidth() + "\nSlip Length: " + slip.getSlipLenght();
	}

	public Date getStartDate() {
		return startDate;
	}

}// end class Lease
