/*
 * Create subclass Powerboat
 */

package programming2.bradshawMarina.model;


/**
 *
 * @author Olga
 */
public class Powerboat extends Boat {
private int numberEngines;
private String fuelType;


public Powerboat(){
    super();
    this.numberEngines = 0;
    this.fuelType = "";
}    

public Powerboat(String stateRegistrationNo, double boatLength, double boatWidth,
        String manufacturer, int year, String customerID, int numberEngines, 
        String fuelType){
    super(stateRegistrationNo, boatLength, boatWidth, manufacturer, year, 
            customerID);
    this.numberEngines = numberEngines;
    this.fuelType = fuelType;
}   


    public int getNumberEngines() {
        return numberEngines;
    }

    
    public void setNumberEngines(int numberEngines) {
        this.numberEngines = numberEngines;
    }

    
    public String getFuelType() {
        return fuelType;
    }

    
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString(){
        return "Boat Registration Number: " + getStateRegistrationNo() +
                "\nBoat Length: " + getBoatLength() + "\nBoat Width: " + 
                getBoatWidth() + "\nManufacturer: " + getManufacturer() + 
                "\nYear: " + getYear() + "\nNumber of Engines: " + getNumberEngines() +
                "\nFuel Type: " + getFuelType();
    }

    
    
    
    
}//end class
