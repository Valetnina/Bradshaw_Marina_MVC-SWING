/**
 * Declare a class named DailyLease extends Lease
 */
package programming2.bradshawMarina.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author valeriy hohin
 */
public class DailyLease extends Lease{
    // declare variables
    private final double DISCOUNT_RATE = 0.00;
    private double daylyRate;
    private int numberOfDays;

    /**
     * Default constructor
     */
    public DailyLease() {
        super();
        this.daylyRate = 0;
        this.numberOfDays = 0;
        setAmount(calculateFee());

    }// end default constructor    
   
    /**
     * CONSTRUCTOR with parameters to create DailyLease object to retrieved from database
     * @param aDaylyRate
     * @param aStartDate
     * @param aIdLease
     * @param aIdCustomer
     * @param aIdSlip
     * @param aNumberOfDays 
     * @param slip
     */    
    public DailyLease(Date aStartDate, int aIdLease,
            String aIdCustomer, String aIdSlip, int aNumberOfDays, Slip slip) {
        super(aStartDate, aIdLease, aIdCustomer, aIdSlip, slip);
        this.numberOfDays = aNumberOfDays;
        //use calendar to add 1year to start date
        setEndDate(startDate);
        // invoke superclass setAmount method after getting
        //fee amount from calculateFee mehod 
        setSlip(slip);
	setDaylyRate(slip.leaseSlip());
        setAmount(calculateFee());
		
    }// end constructor with parameters
    /**
     * Constructor to create DailyLease object to be stored in database
     * @param aStartDate
     * @param aIdLease
     * @param aIdCustomer
     * @param aIdSlip
     * @param aNumberOfDays
     */
    public DailyLease(Date aStartDate, int aIdLease,
            String aIdCustomer, String aIdSlip, int aNumberOfDays) {
        super(aStartDate, aIdLease, aIdCustomer,aIdSlip);
        this.numberOfDays = aNumberOfDays;
        //use calendar to add 1year to start date
        setEndDate(startDate);
        // invoke superclass setAmount method after getting
        //fee amount from calculateFee mehod 
        setAmount(calculateFee());
    }// end constructor with parameters
    
    // SETTERS
    
    /**
     * @param aDaylyRate the daylyRate to set
     */
    public void setDaylyRate(double aDaylyRate) {
        this.daylyRate = aDaylyRate;
    }// end  setDaylyRate     
    
    @Override
	public void setEndDate(Date startDate) {
            
            GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(startDate);
		cal.add(Calendar.DATE, numberOfDays);

		endDate = cal.getTime();

	}

	/**
     * @param numberOfDays the numberOfDays to set
     */
    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }// end  setNumberOfDays

    // GETTERS
    /**
     * @return the daylyRate
     */
    public double getDaylyRate() {
        return daylyRate;
    }// end  getDaylyRate
    
    /**
     * @return the numberOfDays
     */
    public double getNumberOfDays() {
        return numberOfDays;
    }// end  getNumberOfDays   
    
    /**
     * 
     * @return 
     */
    public Date getEndDate() {
        
        
        return endDate;
    }// end  setNumberOfDays
    
    @Override
    public double calculateFee() {
        if (numberOfDays > 30){            
            amount = getDaylyRate() * ( 30 + (getNumberOfDays() - 30)*DISCOUNT_RATE);
        }
        else {           
            amount = getDaylyRate() * numberOfDays;          
        } 
        return amount;
    }// end  method calculateFee

    // end method toString       

    @Override
	public String toString() {
		return super.toString() + "\n Type of Lease: DailyLease" + "\nDISCOUNT_RATE: $" + DISCOUNT_RATE + "\nDayly Rate: $"
				+ daylyRate + "\nNumber of Days:" + numberOfDays;
	}

	
    
}// end class DailyLease
