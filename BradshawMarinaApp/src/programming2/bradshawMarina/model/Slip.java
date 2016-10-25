/*
 * Class Slip
 */
package programming2.bradshawMarina.model;

import javax.swing.JOptionPane;

/**
 *
 * @author nazarholyanskyy
 */
public class Slip {
  
    private static final double POSSIBLE_SLIP_WIDTHS[] = {15, 19, 21};
    
    private static final double POSSIBLE_SLIP_FEES[] = {20, 24.50, 27.3};
    private final int MAXIMUM_SLIPS_IN_DOCK = 30;
    
    private final double DEFAULT_LENGTH = 30;
    
    private String slipId;
    private double slipWidth;
    private double slipLenght;
    
    private Boat boat;
    private Dock dock;
    private boolean isAvailable;
    private boolean isCovered;
    private double leasefee;

    // default constructor 
    /**
     * constructor to create slips in a particular dock
     *
     * @param anId
     * @param aWidth
     * @param aSlipLength
     */
    public Slip(String anId, int aWidth, double aSlipLength) {
        setSlipId(anId);
        setSlipWidth(aWidth);
        setSlipLenght(aSlipLength);
        setBoat(null);
       
        //dock.addSlipToDock(this);
    }
    
    public Slip() {
    }

    public Slip(String id) {
        this.slipId = id;
        this.isAvailable = true;
        this.isCovered = false;
    }
    ///////////////////////////////////////////////////////////////

    public Slip(String slipId, double slipWidthvdf, boolean isCovereddfs) {
        this.slipId = slipId;
        this.slipWidth = slipWidthvdf;
        this.isCovered = isCovereddfs;
        this.isAvailable = true;
        leaseSlip();
        //getLeasefee();
        
    }

    // constructor with parameters
    public Slip(String aSlipId, double aSlipWidth, double aSlipLenght, Boat aBoat, Dock aDock) {
        slipId = aSlipId;
        this.slipWidth = aSlipWidth;
        this.slipLenght = aSlipLenght;
        this.boat = aBoat;
        this.dock = aDock;
        this.slipLenght = DEFAULT_LENGTH;
        
    }

    ////////////////////////////////////////////////////////////////////////////
    public Slip(String aSlipId, double aSlipWidth, double aSlipLenght, boolean isCovered) {
        slipId = aSlipId;
        this.slipWidth = aSlipWidth;
        this.slipLenght = aSlipLenght;
        this.isCovered = isCovered;
    }
    public double leaseSlip() {
        for (int i = 0; i < getPossibleSlipWidths().length; i++) {
            if (getSlipWidth() == getPossibleSlipWidths()[i]) {
                leasefee = getPossibleSlipFees()[i];
            } else {
                continue;
            }
            
        }
        
        return leasefee;
    } // end method leaseSlip
    public static double[] getPossibleSlipWidths() {
        return POSSIBLE_SLIP_WIDTHS;
    }

    public double getDEFAULT_LENGTH() {
        return DEFAULT_LENGTH;
    }

    /**
     * @return the slipId
     */
    public String getSlipId() {
        return slipId;
    }

    /**
     * @param slipId the slipId to set
     */
    public void setSlipId(String slipId) {
        this.slipId = slipId;
    }

    /**
     * @return the slipWidth
     */
    public double getSlipWidth() {
        return slipWidth;
    }

    /**
     * @param slipWidth the slipWidth to set
     */
    public void setSlipWidth(double slipWidth) {
        this.slipWidth = slipWidth;
    }

    /**
     * @return the slipLenght
     */
    public double getSlipLenght() {
        return slipLenght;
    }

    public double getLeasefee() {
		return leasefee;
	}

	public void setLeasefee(double leasefee) {
		this.leasefee = leasefee;
	}

	/**
     * @param slipLenght the slipLenght to set
     */
    public void setSlipLenght(double slipLenght) {
        this.slipLenght = slipLenght;
    }

    /**
     * @return the boat
     */
    public Boat getBoat() {
        return boat;
    }

    /**
     * @param boat the boat to set
     */
    public void setBoat(Boat boat) {
        this.boat = boat;
    }
    
    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public boolean isCovered() {
        return isCovered;
    }

    public void setCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }

    public static double[] getPossibleSlipFees() {
		return POSSIBLE_SLIP_FEES;
	}

	@Override
    public String toString() {
        return slipId + ", Width=" + slipWidth
                + ", Lenght=" + slipLenght + ", boat=" + ((boat == null) ? " No Boat": boat.getStateRegistrationNo())
                + (isCovered ? ", Covered" : ", Uncovered" +  ", Dock: " + dock) ;
    }
  
    

    

    // method to get number of slips available
    /**
     * @return the isAvailable
     */
    public boolean isIsAvailable() {
        return isAvailable;
    }

    /**
     * @param isAvailable the isAvailable to set
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     * @return the isCovered
     */
    public boolean isIsCovered() {
        return isCovered;
    }

    /**
     * @param isCovered the isCovered to set
     */
    public void setIsCovered(boolean isCovered) {
        this.isCovered = isCovered;
    }

    /**
     * @return the MAX_NUMBER_OF_SLIPS
     */
    
    public int getMAXIMUM_SLIPS_IN_DOCK() {
        // TODO Auto-generated method stub
        return MAXIMUM_SLIPS_IN_DOCK;
    }
    
    public double getchooseSlipWidth(double boatWidth) {
        
        if (boatWidth < POSSIBLE_SLIP_WIDTHS[0]) {
            slipWidth = POSSIBLE_SLIP_WIDTHS[0];
        } else if (boatWidth < POSSIBLE_SLIP_WIDTHS[1]) {
            slipWidth = POSSIBLE_SLIP_WIDTHS[1];
        } else if (boatWidth < POSSIBLE_SLIP_WIDTHS[2]) {
            slipWidth = POSSIBLE_SLIP_WIDTHS[2];
        } else {
            JOptionPane.showMessageDialog(null, "This boat is too large for our slips " + boatWidth, "Error Message", JOptionPane.ERROR_MESSAGE);
        }
        return slipWidth;
    }
   
 } // end class Slip
