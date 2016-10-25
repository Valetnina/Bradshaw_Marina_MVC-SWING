/**
 * Class that Sets the FormEvent object to allow messages to be sent from the view to the controller
 */
package programming2.bradshawMarina.gui;

/**
 * @author Valentina
 */
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.EventObject;

import programming2.bradshawMarina.model.Boat;
import programming2.bradshawMarina.model.Lease;

public class FormEvent extends EventObject {
    //variables to store customer form retrieved values

    private String id;
    private String fName;
    private String lName;
    private String phone;
    private String address;
    private Boat boat;
    private Lease lease;
    private boolean isActive;

    //variables to store boat form retrieved values
    private String registrationNo;
    private double length;
    private double width;
    private String manufacturer;
    private int year;
    private String type;
    private int numberSails;
    private Double depth;
    private String engineType;
    private int numberEngines;
    private String fuelType;
    //variables to store slip form retrieved values
    private String idSlip;
    private Boolean isCovered;
    private String slipWidth;
    //variables to store lease form retrieved values
    private Date startDate;
    private int idLease;
    private String typeOfPayement;
    private int daysN;
    private String typeOfLease;

    public FormEvent(Object source, Boolean isCovered) {
        super(source);
        this.isCovered = isCovered;
    }

    public FormEvent(Object source, String id, double length, double width) {
        super(source);
        this.id = id;
        this.length = length;
        this.width = width;
    }

    public String getTypeOfLease() {
        return typeOfLease;
    }

    public void setTypeOfLease(String typeOfLease) {
        this.typeOfLease = typeOfLease;
    }

    public int getIdLease() {
        return idLease;
    }

    public void setIdLease(int idLease) {
        this.idLease = idLease;
    }

    public String getIdSlip() {
        return idSlip;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTypeOfPayement() {
        return typeOfPayement;
    }

    public void setTypeOfPayement(String typeOfPayement) {
        this.typeOfPayement = typeOfPayement;
    }

    public int getDaysN() {
        return daysN;
    }

    public void setDaysN(int daysN) {
        this.daysN = daysN;
    }

    public void setIdSlip(String idSlip) {
        this.idSlip = idSlip;
    }

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String id, String fName, String lName,
            String phone, String address, Boat boat, Lease lease,
            boolean isActive) {
        super(source);
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        this.boat = boat;
        this.lease = lease;
        this.isActive = isActive;
    }

    public FormEvent(Object source, String id, String registrationNo,
            double length, double width, String manufacturer, int year,
            String type, int numberSails, Double depth, String engineType,
            int numberEngines, String fuelType, String slipId, Boolean isCovered) {
        super(source);
        this.id = id;
        this.registrationNo = registrationNo;
        this.length = length;
        this.width = width;
        this.manufacturer = manufacturer;
        this.year = year;
        this.type = type;
        this.numberSails = numberSails;
        this.depth = depth;
        this.engineType = engineType;
        this.numberEngines = numberEngines;
        this.fuelType = fuelType;
        this.idSlip = slipId;
        this.isCovered = isCovered;
    }

    public Boolean getIsCovered() {
        return isCovered;
    }

    public void setIsCovered(Boolean isCovered) {
        this.isCovered = isCovered;
    }

    public String getSlipWidth() {
        return slipWidth;
    }

    public void setSlipWidth(String slipWidth) {
        this.slipWidth = slipWidth;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumberSails() {
        return numberSails;
    }

    public void setNumberSails(int numberSails) {
        this.numberSails = numberSails;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Lease getLease() {
        return lease;
    }

    public void setLease(Lease lease) {
        this.lease = lease;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public FormEvent(Object source, String id, Date startDate, int idLease,
            String typeOfLease, String idSlip, String typeOfPayement, int daysN) {
        super(source);
        this.id = id;
        this.startDate = startDate;
        this.idLease = idLease;
        this.idSlip = idSlip;
        this.typeOfLease = typeOfLease;
        this.typeOfPayement = typeOfPayement;
        this.daysN = daysN;
    }

    public FormEvent(Object source, String idSlip) {
        super(source);
      //  this.id = idCustomer;
        this.idSlip = idSlip;
    }


}
