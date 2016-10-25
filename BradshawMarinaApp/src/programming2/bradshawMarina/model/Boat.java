/*
 * Create abstract class Boat
 */

package programming2.bradshawMarina.model;


/**
 *
 * @author Olga
 */
public abstract class Boat {
	@Override
    public String toString(){
        return "Boat Registration Number: " + getStateRegistrationNo()  +"\nBoat Length: " + getBoatLength() + "\nBoat Width: " + getBoatWidth() + "\nManufacturer: " + getManufacturer() + "\nYear: " + getYear();
    }


private String stateRegistrationNo;
private double boatLength;
private double boatWidth;
private String manufacturer;
private int year;
private String customerID;

    
public Boat(){
    this.stateRegistrationNo = "";
    this.boatLength = 0;
    this.boatWidth = 0;
    this.manufacturer = "";
    this.year = 0;
    this.customerID = "";
}

public Boat(String stateRegistrationNo, double boatLength, double boatWidth,
        String manufacturer, int year, String customerID){
    
    this.stateRegistrationNo = stateRegistrationNo;
    this.boatLength = boatLength;
    this.boatWidth = boatWidth;
    this.manufacturer = manufacturer;
    this.year = year;
    this.customerID = customerID;
}


    public String getStateRegistrationNo() {
        return stateRegistrationNo;
    }

    
    public void setStateRegistrationNo(String stateRegistrationNo) {
        this.stateRegistrationNo = stateRegistrationNo;
    }

    
    public double getBoatLength() {
        return boatLength;
    }

    
    public void setBoatLength(double boatLength) {
        this.boatLength = boatLength;
    }

    
    public double getBoatWidth() {
        return boatWidth;
    }

    
    public void setBoatWidth(double boatWidth) {
        this.boatWidth = boatWidth;
    }

    
    public String getManufacturer() {
        return manufacturer;
    }

    
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    
    public int getYear() {
        return year;
    }

    
    public void setYear(int year) {
        this.year = year;
    }

    
    public String getCustomerID() {
        return customerID;
    }

    
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    
    
}//end class
