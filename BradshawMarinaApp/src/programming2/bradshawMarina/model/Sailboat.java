/*
 * Create subclass Powerboat
 */

package programming2.bradshawMarina.model;

/**
 *
 * @author Olga
 */
public class Sailboat extends Boat {
   
private double keelDepth;  
private int numberSails;
private String motorType;


public Sailboat(){
    super();
    this.keelDepth = 0;
    this.numberSails = 0;
    this.motorType = "";
}

public Sailboat(String stateRegistrationNo, double boatLength, double boatWidth,
        String manufacturer, int year, String customerID, double keelDepth, 
        int numberSails, String motorType){
    super(stateRegistrationNo, boatLength, boatWidth, manufacturer, year, 
            customerID);
    this.keelDepth = keelDepth;
    this.numberSails = numberSails;
    this.motorType = motorType;
}





    public double getKeelDepth() {
        return keelDepth;
    }

    
    public void setKeelDepth(double keelDepth) {
        this.keelDepth = keelDepth;
    }

    
    public int getNumberSails() {
        return numberSails;
    }

    
    public void setNumberSails(int numberSails) {
        this.numberSails = numberSails;
    }

    
    public String getMotorType() {
        return motorType;
    }

    
    public void setMotorType(String motorType) {
        this.motorType = motorType;
    }

	@Override
	 public String toString(){
        return "Boat Registration Number: " + getStateRegistrationNo() +
                "\nBoat Length: " + getBoatLength() + "\nBoat Width: " + 
                getBoatWidth() + "\nManufacturer: " + getManufacturer() + 
                "\nYear: " + getYear() + "\nNumber of Sails: " + getNumberSails() +
                "\nKeel Depth: " + getKeelDepth()+ "\nMotor Type: " + getMotorType();
    }



    
}//end class Sailboat
