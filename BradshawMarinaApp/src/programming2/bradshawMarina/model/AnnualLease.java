/**
 * Declare a class named AnnualLease extends Lease
 */
package programming2.bradshawMarina.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author valeriy hohin
 */
public class AnnualLease extends Lease {
	// declare variables
	private final double DISCOUNT_RATE = 0.05;
	private double daylyRate;
	private boolean payMonthly;
	private double balanceDue;

	/**
	 * Default constructor
	 */
	public AnnualLease() {
		super();
		this.daylyRate = 0;
		this.payMonthly = false;
		this.balanceDue = 0;
                setAmount(calculateFee());
                setDaylyRate(slip.leaseSlip());

	}// end default constructor

	public double getDISCOUNT_RATE() {
		return DISCOUNT_RATE;
	}

	/**
	 * CONSTRUCTOR with parameters to generate AnnualLease object to be retrieved from the database
	 *  
	 * @param aPayYearly
	 * @param aDaylyRate
	 * @param aBalanceDue
	 * @param aStartDate
	 * @param aIdLease
	 * @param aIdCustomer
	 * @param aIdSlip
	 */
	public AnnualLease(boolean aPayMonthly, Date aStartDate, int aIdLease,
			String aIdCustomer, String aIdSlip, Slip slip) {
		super(aStartDate, aIdLease, aIdCustomer, aIdSlip, slip);
                setSlip(slip);
		//setDaylyRate(slip.getLeasefee());
		setEndDate(aStartDate);
                setDaylyRate(slip.leaseSlip());
		// invoke superclass setAmount method after getting
		// fee amount from calculateFee mehod
		setAmount(calculateFee());
		// invoke AnnualLease methods
		setPayMonthly(aPayMonthly);
		if (payMonthly)
			setBalanceDue(getAmount() / 12);
		else
			setBalanceDue(0);

	}// end constructor with parameters
	
	/**
	 * //Constructor to generate AnnualLease object to be stored in the database
	 * @param aPayMonthly
	 * @param aStartDate
	 * @param aIdLease
	 * @param aIdCustomer
	 * @param aIdSlip
	 */
	public AnnualLease(boolean aPayMonthly, Date aStartDate, int aIdLease,
			String aIdCustomer, String aIdSlip) {
		super(aStartDate, aIdLease, aIdCustomer, aIdSlip);
		this.payMonthly = payMonthly;
                //setDaylyRate(slip.leaseSlip());
                setAmount(calculateFee());

	}// end constructor with parameters

	// SETTERS
	
	/**
	 * return the Balance due
	 * 
	 * @param balanceDue
	 */
	public void setBalanceDue(double balanceDue) {
		this.balanceDue = balanceDue;
	}

	@Override
	public void setEndDate(Date startDate) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		cal.add(Calendar.YEAR, 1);

		endDate = cal.getTime();

	}

	/**
	 * @param aDaylyRate
	 *            the daylyRate to set
	 */
	public void setDaylyRate(double aDaylyRate) {
		this.daylyRate = aDaylyRate;
	}// end setDaylyRate

	/**
	 * @param aPayYearly
	 *            the aPayYearly to set
	 */
	public void setPayYearly(boolean aPayYearly) {
		this.payMonthly = aPayYearly;
	}// end aPayYearly

	/**
	 * 
	 * @param payMonthly
	 */
	public void setPayMonthly(boolean payMonthly) {
		this.payMonthly = payMonthly;
	}

	// GETTERS
	/**
	 * @return the daylyRate
	 */
	public double getDaylyRate() {
		return daylyRate;
	}// end getDaylyRate

	/**
	 * @return the payYearly
	 */
	public boolean getPayYearly() {
		return payMonthly;
	}// end getPayYearly

	/**
	 * 
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}// end setNumberOfDays

	/**
	 * @return the balanceDue
	 */
	public double getBalanceDue() {
		return balanceDue;
	}// end getBalanceDue
	
	/**
	 * 
	 * @return payMonthly
	 */
	public boolean isPayMonthly() {
		return payMonthly;
	}
	
	/**
	 * override method toString()
	 */
	@Override
	public String toString() {
		String typeOfPayement = isPayMonthly() ? "Monthly" : "Annual";
		return super.toString() + "\nType Of Lease: AnnualLease "
				+ "\nDISCOUNT RATE: " + DISCOUNT_RATE + "\nDayly Rate: $"
				+ getDaylyRate() + "\nPayements periodicity: " + typeOfPayement
				+ "\nPayement at the end of the month: $ " + String.format("%.2f",getBalanceDue());
	}

	/**
	 * method to return the calculated amount according to the appropriate
	 * leasefee
	 */

	@Override
	public double calculateFee() {
		if (payMonthly) {
			if (balanceDue > 0) {
				amount = daylyRate * 30 + balanceDue;
			} else {
				amount = daylyRate * 30;
			}
		} else {
			amount = daylyRate * 365  - (daylyRate * 365 * DISCOUNT_RATE);
		}
		return amount;
	}

}// end class AnnualLease
