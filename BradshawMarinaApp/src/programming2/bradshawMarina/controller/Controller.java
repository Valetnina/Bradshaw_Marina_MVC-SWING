/**
 * Class to make connection between GUI and Model classes to support Three Tier Architecture and Model View Controller design Pattern
 *
 * @author Valentina
 */
package programming2.bradshawMarina.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import programming2.bradshawMarina.gui.FormEvent;
import programming2.bradshawMarina.model.AnnualLease;
import programming2.bradshawMarina.model.Boat;
import programming2.bradshawMarina.model.Customer;
import programming2.bradshawMarina.model.DailyLease;
import programming2.bradshawMarina.model.Lease;
import programming2.bradshawMarina.model.Powerboat;
import programming2.bradshawMarina.model.Sailboat;
import programming2.bradshawMarina.model.Slip;
import programming2.bradshawMarina.model.SlipDAo;
import programming2.bradshawMarina.model.XMLDatabase;

public class Controller {

    //Declare instance variables
    XMLDatabase db = new XMLDatabase();
    private SlipDAo slipDao = new SlipDAo();
    List<Slip> availableSlipsByWidth = new ArrayList<Slip>();

    /**
     * Method to send the message from view to the model to return the list of
     * customer objects
     *
     * @return db.getCustomers();
     */
    public List<Customer> getCustomers() {
        return db.getCustomers();
    }

    /**
     * Method to send the message from view to the model to return the list of
     * customer objects
     *
     * @return db.getBoat()
     */
    public List<Boat> getBoat() {
        return db.getBoat();
    }

    /**
     * Method to send the message from the view to the model to remove a
     * customer object from the Customers list
     *
     * @param index
     */
    public void removeCustomer(int index) {
        db.removePerson(index);
    }

    /**
     * Method to sent the message from the view to the model to locate the files
     * (eventually connect to the database)
     *
     * @throws Exception
     */
    public void connect() throws Exception {
        db.connect();
    }
    public void save()  throws Exception {
		db.saveToCustomers();	
	}
    /**
     * Method to send the message from the view to the model to loop in the
     * Customer objects list and read the elements and store them write them
     * into an XML File(eventually insert into a database)
     *
     * @throws Exception
     */
    public void saveToCustomers() throws Exception {
        db.saveToCustomers();
    }

    /**
     * Method to send the message from the view to the model to loop in the Boat
     * objects list and read the elements and store them write them into an XML
     * File(eventually insert into a database)
     *
     * @throws Exception
     */
    public void saveToBoats() throws Exception {
        db.saveToBoats();
    }

    /**
     * Method to send the message from the view to the model to loop in the
     * LEase objects list and read the elements and store them write them into
     * an XML File(eventually insert into a database)
     *
     * @throws Exception
     */
    public void saveToLease() throws Exception {
        db.saveToLeases();
    }

    /**
     * Method to receive an FormEvent object from the view and instantiate an
     * Customer object to be sent do the database
     *
     * @param ev
     */
    public void addCustomers(FormEvent ev) {
        String id = ev.getId();
        String fName = ev.getfName();
        String lName = ev.getlName();
        String phone = ev.getPhone();
        String address = ev.getAddress();
        Boat boat = ev.getBoat();
        Lease lease = ev.getLease();
        Boolean isActive = ev.isActive();

        Customer customer = new Customer(id, fName, lName, phone, address, boat, lease, isActive);

        db.addCustomer(customer);

    }

    /**
     * Method to send message from the view to the database handler to save data
     * to the XML File when the option save from file is chosen from the File
     * menu
     *
     * @param filed
     * @throws IOException
     */
    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    /**
     * Method to send message from the view to the database Handler to load data
     * from an XML File when the option load from file is chosen from the File
     * menu
     *
     * @param file
     * @throws IOException
     */
    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }

    /**
     * Method to send the message from the view to the database handler to load
     * the list of customers from the XML Database File
     *
     * @throws Exception
     */
    public void load() throws Exception {
        db.loadCustomers();

    }

    /**
     * Method to to send message from the view to the database handler to
     * retrieve the boats list from the XML Database File
     *
     * @throws Exception
     */
    public void loadBoats() throws Exception {
        db.loadBoats();
    }

    /**
     * Method to send the message from the view to the database handler to load
     * the list of lease objects from the XML Database File
     *
     * @throws Exception
     */
    public void loadLeases() throws Exception {
        db.loadLeases();
    }

    /**
     * Method to send the message from the view to add a boat object created
     * with the properties passed in by the FormEvent object, to the list of
     * Boat objects
     *
     * @param e
     */
    public void addBoat(FormEvent e) {
        String customerId = e.getId();
        String registrationNo = e.getRegistrationNo();
        double length = e.getLength();
        double width = e.getWidth();
        String manufacturer = e.getManufacturer();
        int year = e.getYear();
        String type = e.getType();
        int numberSails = e.getNumberSails();
        double depth = e.getDepth();
        String engineType = e.getEngineType();
        int numberEngines = e.getNumberEngines();
        String fuelType = e.getFuelType();

        Boat boat = (type.compareTo("Sailboat") == 0) ? new Sailboat(registrationNo, length, width,
                manufacturer, year, customerId, depth, numberSails, engineType) : new Powerboat(registrationNo, length, width,
                manufacturer, year, customerId, numberEngines, fuelType);

        db.addBoat(boat);
    }

    /**
     * Method to send to the database handlers the message to display the
     * information fro a particular customer
     *
     * @throws Exception
     */
    public void showCustomerdetails() throws Exception {
        db.loadBoats();
        db.loadLeases();

    }

    /**
     * Method to send to the database handlers the message to display the
     * information fro a particular customer
     *
     * @throws Exception
     */
    public void addLease(FormEvent e) {
        String customerId = e.getId();
        int contractNo = e.getIdLease();
        Date startDate = e.getStartDate();

        //Boolean typeOfPayement = true;
        Boolean typeOfPayement = (e.getTypeOfPayement().compareTo("monthly") == 0) ? true : false;
        int daysNo = e.getDaysN();
        String typeOfLease = e.getTypeOfLease();
        String slipId = e.getIdSlip();

        Lease lease = (typeOfLease.compareTo("Daily") == 0) ? new DailyLease(startDate, contractNo, customerId, slipId, daysNo)
                : new AnnualLease(typeOfPayement, startDate, contractNo, customerId, slipId);
        {
        };

        db.addLease(lease);

    }

    /**
     * Method to send the message to the Database Handler to get the Lease
     * objects list
     *
     * @return
     */
    public List<Lease> getLeaseContract() {
        return db.getLeaseContract();
    }

    /**
     * Method to send the message to the SlipDao to retrieve the list of
     * available slips
     *
     * @return
     */
    public List<Slip> getAvailableSlips() {
        return slipDao.getAllSlips();
    }

    /**
     * Method to send the message to the SlipDao to retrieve the list of
     * available slips filtered by particular properties
     *
     * @param boatWidth
     * @param isCovered
     * @return
     * @throws Exception
     */
    public List<Slip> getAvailableSlipsByWidth(double boatWidth, boolean isCovered) throws Exception {
        connect();
        loadLeases();
        List<Lease> contracts = getLeaseContract();
        List<Slip> unavailableSlips = new ArrayList<Slip>();
        List<Slip> availableSlipsByWidth = slipDao.getAllSlipsByWidth(boatWidth, isCovered);
        for (Lease lease : contracts) {

            unavailableSlips.add(lease.getSlip());
        }
        Iterator<Slip> it = availableSlipsByWidth.iterator();
        while (it.hasNext()) {
            Slip s = it.next(); // must be called before you can call i.remove()
            // Do something
            for (Slip unavailableSlip : unavailableSlips) {
                if (s.getSlipId().compareTo(unavailableSlip.getSlipId()) == 0) {
                    it.remove();
                }
            }

        }

        return availableSlipsByWidth;
    }

    /**
     * Method to send the message to the SliDao to aassign a particular boat to
     * a particular slip
     *
     * @param slip
     */
    public void assignSlipToBoat(Slip slip) {
        slipDao.assignSlipToBoat(slip);
    }

    /**
     * Method to send the message to the SlipDao to get the price when it's
     * requested by the view
     *
     * @param boatWidth
     * @param typeOfPayement
     * @param isCovered
     * @return
     */
    public double getPrices(double boatWidth, String typeOfPayement, boolean isCovered) {
        return slipDao.getPrice(boatWidth, typeOfPayement, isCovered);

    }
}
