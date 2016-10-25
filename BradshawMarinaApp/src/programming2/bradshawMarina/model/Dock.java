/**
 * Class to define Dock
 */
package programming2.bradshawMarina.model;

/**
 *
 * @author nazarholyanskyy
 */
public class Dock {

    private String dockId;
    private String location;
    private boolean electricity;
    //we consider that all the slips in a dock are covered, so the property covered belongs to dock
    private boolean covered;
    private boolean water;

    // default constructor 
    public Dock() {
    }

    // constructor with parameters
    public Dock(String aDockId, String aLocation, boolean aElectricity, boolean aWater, boolean isCovered) {
        this.dockId = aDockId;
        this.location = aLocation;
        this.electricity = aElectricity;
        this.water = aWater;
        this.covered = isCovered;
    }

    /**
     * @return the dockId
     */
    public String getDockId() {
        return dockId;
    }

    /**
     * @param aDockId the dockId to set
     */
    public void setDockId(String aDockId) {
        this.dockId = aDockId;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param aLocation the location to set
     */
    public void setLocation(String aLocation) {
        this.location = aLocation;
    }

    /**
     * @return the electricity
     */
    public boolean isElectricity() {
        return electricity;
    }

    /**
     * @param aElectricity the electricity to set
     */
    public void setElectricity(boolean aElectricity) {
        this.electricity = aElectricity;
    }

    /**
     * @return the water
     */
    public boolean isWater() {
        return water;
    }

    /**
     * @param aWater the water to set
     */
    public void setWater(boolean aWater) {
        this.water = aWater;
    }

    public boolean isCovered() {
        return covered;
    }

    public void setCovered(boolean covered) {
        this.covered = covered;
    }

    @Override
    public String toString() {
        return ", dockId=" + dockId + ", location=" + location
                + (electricity ? ", Has electricity" : ", No electricity") + (water ? ", Has Water" : ", No water");
    }

} // end class Dock
