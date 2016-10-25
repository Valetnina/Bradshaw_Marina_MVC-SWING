/**
 * Class to make connection between the View and the Model
 */
package programming2.bradshawMarina.model;

import java.util.ArrayList;
import java.util.List;

public class SlipDAo {
	private Slip slip = new Slip();
	private List<Dock> docks = new ArrayList<Dock>();
	private List<Slip> slips = new ArrayList<Slip>();
	private List<Slip> availableSlips = new ArrayList<Slip>();
	private List<Slip> slipsByWidth = new ArrayList<Slip>();
	private List<Slip> uanvailableSlips= new ArrayList<Slip>();

	// dock.addSlipToDock(this);

	/**
	 * Method to generate all the possible docks
	 * 
	 * @return docks of type List<Dock>
	 */
	public SlipDAo() {
		generateDocks();
		generateSlips();
	}

	public List<Dock> generateDocks() {
		Dock dockA = new Dock("A", "East Side", true, true, true);
		Dock dockB = new Dock("B", "West Side", false, false, false);
		Dock dockC = new Dock("C", "North Side", true, true, false);
		Dock dockD = new Dock("D", "South Side", false, true, false);

		docks.add(dockA);
		docks.add(dockB);
		docks.add(dockC);
		docks.add(dockD);
		return docks;
	}

	public List<Slip> generateSlips() {
		int maxNnumberOfSlips = slip.getMAXIMUM_SLIPS_IN_DOCK();
		int possibleWidths = slip.getPossibleSlipWidths().length;

		for (Dock dock : docks) {
			int count = 0;
			if (dock.isCovered()) {

                                       for (int j = 0; j < possibleWidths; j++) {
                                           
						for (int k = 0; k < Math.floor(maxNnumberOfSlips
								/ possibleWidths); k++) {
                                                   
                                        slip = new CoveredSlip(dock.getDockId() + (++count));          
					slip.setSlipWidth(slip.getPossibleSlipWidths()[0]);

					slip.setSlipLenght(slip.getDEFAULT_LENGTH());
					slip.setBoat(null);
					slip.setDock(dock);
                                        slip.setSlipWidth(slip.getPossibleSlipWidths()[j]);
                                        slips.add(slip);
                                       
                                }
					
                                       }
			} else {
                                        for (int j = 0; j < possibleWidths; j++) {
                                           
						for (int k = 0; k < Math.floor(maxNnumberOfSlips
								/ possibleWidths); k++) {
					slip = new Slip(dock.getDockId() + (++count));
					slip.setSlipWidth(slip.getPossibleSlipWidths()[0]);
					
							slip.setSlipWidth(slip.getPossibleSlipWidths()[j]);

					slip.setSlipLenght(slip.getDEFAULT_LENGTH());

					slip.setBoat(null);
					slip.setDock(dock);
					slips.add(slip);
                                                }
				}

			}

		}
		return slips;
	}

	public List<Slip> geteAvailablelips() {
		// I have to add methods to check all the slips that are not available
		return availableSlips;
	}

	public List<Slip> getAllSlips() {
		return slips;
	}
        public List<Slip> getAllSlipsByWidth(double boatWidth, boolean isCovered) {
            double slipWidth = getSlipWidthChosen(boatWidth);
            for(Slip slip: getAllSlips()) {
		if(slip.getSlipWidth() == slipWidth && slip.isCovered() == isCovered) {
                    slipsByWidth.add(slip);
                }
            }
            return slipsByWidth;
	}

	public void assignSlipToBoat(Slip slip) {
		for (Slip slipElement : slips) {
			if (slip.getSlipId() == slipElement.getSlipId()) {
				slipElement.setIsAvailable(false);
			}
		}
	}

	public double getSlipWidthById(String idSlip) {
		double slipWidth = 0;
                
		for (Slip slip : slips) {
			if (slip.getSlipId().compareTo(idSlip) == 0) {
				slipWidth = slip.getSlipWidth();
			}
		}
		return slipWidth;
	}

	public double getSlipLengthById(String idSlip) {
		double slipLength = 0;
		for (Slip slip : slips) {
			if (slip.getSlipId().compareTo(idSlip) == 0) {
				slipLength = slip.getSlipLenght();
			}
		}
		return slipLength;
	}

	public boolean getSlipISCoveredById(String idSlip) {
		boolean isCovered = false;
		for (Slip slip : slips) {
			if (slip.getSlipId().compareTo(idSlip) == 0) {
				isCovered = slip.isIsCovered();
			}
		}
		return isCovered;
	}
	

	public void addSlipToBoat(Slip slip, Boat boat) {
		availableSlips.remove(slip);
		slip.setBoat(boat);
	}
         public double getSlipWidthChosen(double boatWidth){
            double slipWidth = slip.getchooseSlipWidth(boatWidth);
          return slipWidth;
      }
	public static void main(String[] args) {
		SlipDAo app = new SlipDAo();
		List<Slip> slips = app.getAllSlips();
		for (Slip slip : slips) {
		}
	}

	public double getPrice(double boatWidth, String typeOfPayement, boolean isCovered) {
		Slip slip = isCovered ? new CoveredSlip() : new Slip();
		slip.getchooseSlipWidth(boatWidth);
		Lease lease = (typeOfPayement.compareTo("Annual") == 0 ) ? new AnnualLease(): new DailyLease(); 
		lease.setSlip(slip);
	    double price = 0;
		if(lease instanceof AnnualLease) {
			double discount = ((AnnualLease) lease).getDISCOUNT_RATE();
			price = slip.leaseSlip() - slip.leaseSlip()* discount;
		} else {
			price = slip.leaseSlip();
		}
 		
		
	return 	price;
		
		
	}
}