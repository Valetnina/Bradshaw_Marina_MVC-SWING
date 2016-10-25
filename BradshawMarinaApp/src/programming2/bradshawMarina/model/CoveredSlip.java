/*
 *Class to define CoveredSlip 
 */
package programming2.bradshawMarina.model;

/**
 *
 * @author nazarholyanskyy
 */
public class CoveredSlip extends Slip {
	private static final double POSSIBLE_SLIP_FEES_COVERED[] = {25, 28.50, 32.3};
	private final int SLIP_HEIGHT = 50;
    
    private int slipHeight;
    private boolean door;
    
  
    // default constructor 
    
    public CoveredSlip(){
    	setIsCovered(true);
    	setDoor(true);
    	setSlipHeight(SLIP_HEIGHT);
        setDock(getDock());
    }

    public CoveredSlip(String idSlip) {
    	super(idSlip);
        setIsCovered(true);
    	setDoor(true);
    	setSlipHeight(SLIP_HEIGHT);
    	
    
    }
    

   @Override
	public double leaseSlip() {
    	for (int i = 0; i < POSSIBLE_SLIP_FEES_COVERED.length; i++) {
            if (getSlipWidth() == getPossibleSlipWidths()[i]) {
               setLeasefee( POSSIBLE_SLIP_FEES_COVERED[i]);
            } else {
                continue;
            }
    	}
		return getLeasefee();
    }


	/**
     * @return the slipHeight
     */
    public int getSlipHeight() {
        return slipHeight;
    }

    /**
     * @param aSlipHeight the slipHeight to set
     */
    public void setSlipHeight(int aSlipHeight) {
        this.slipHeight = aSlipHeight;
    }

    /**
     * @return the door
     */
    public boolean getDoor() {
        return door;
    }

    /**
     * @param aDoor the door to set
     */
    public void setDoor(boolean aDoor) {
        this.door = aDoor;
    }

    @Override
    public String toString() {
        return super.toString() + ", slip height= " + slipHeight + ", door= " + (door ? "Yes" : "No");
    }
    
    
    
    
} // end class CoveredSlip
