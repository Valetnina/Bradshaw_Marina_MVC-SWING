package programming2.bradshawMarina.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import javax.swing.JOptionPane;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

/*
 * @author Valentina, Valeryi
 */
public class XMLDatabase {

    private List<Customer> customers;
    private List<Boat> boats;
    private List<Lease> contracts = new ArrayList<Lease>();

    private File leaseFile;
    private File file;
    private File boatFile;
    private DocumentBuilderFactory docFactory;
    private DocumentBuilder docBuilder;

    private String id;
    private String fName = "";
    private String lName = "";
    private String phone = "";
    private String address = "";
    private String boatNo = "noBoat";
    private String leaseNo = "noLease";
    private String isActive = "false";

    private String registrationNo;
    private double length;
    private double width;
    private String manufacturer;
    private int year;
    private String type;
    private int sailBoat;
    private double depth;
    private String engineType;
    private int numberEngines;
    private String fuelType;

    private Date startDate = new Date();
    private int idLease;
    private String idSlip;
    private Boolean typeOfPayement;
    private int daysN;
    private String typeOfLease;
    private SlipDAo slipDao;

    private final String[] data = {"CUSTOMERID", "FIRSTNAME", "LASTNAME", "PHONE", "ADDRESS", "BOAT", "LEASE", "ISACTIVE"};

    private String[] data1 = new String[data.length];
    private String[] xmlValues = new String[data.length];

    private final String[] dataBoats = {"CUSTOMERID", "REGISTRATIONNUMBER", "LENGTH", "WIDTH", "MANUFACTURER", "YEAR", "TYPE", "SAILSNUMBER", "DEPTH", "ENGINETYPE", "NUMBERENGINES", "FUELTYPE"};
    private String[] valuesBoats = new String[dataBoats.length];
    private String[] xmlBoatValues = new String[dataBoats.length];

    private final String[] dataLeases = {"CUSTOMERID", "SLIPID", "LEASEID", "STARTDATE", "TYPEOFLEASE", "TYPEOFPAYEMENT", "NOOFDAYS"};
    private String[] valuesLeases = new String[dataLeases.length];
    private String[] xmlLeaseValues = new String[dataLeases.length];
    private List<Slip> unavailableSlips;

    public XMLDatabase() {
        customers = new LinkedList<Customer>();
        boats = new LinkedList<Boat>();
        slipDao = new SlipDAo();
        unavailableSlips = new ArrayList<Slip>();
    }

    /**
     * return a list of all the customers from the database
     *
     * @return customers
     */
    public List<Customer> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    /**
     * return a list of all the boats from the database
     *
     * @return boats
     */
    public List<Boat> getBoat() {
        return Collections.unmodifiableList(boats);
    }

    /**
     * Method to remove a customer object(by its index) from the customers list
     *
     * @param index
     */
    public void removePerson(int index) {
        customers.remove(index);

    }

    /**
     * Method to locate the XML files (eventually connect to the database)
     *
     * @throws FileNotFoundException
     */
    public void connect() throws FileNotFoundException {
        file = new File("../src/Files/Database.xml");//for netbeans
        boatFile = new File("../src/Files/BoatDatabase.xml");// /for netbeans
        leaseFile = new File("../src/Files/LeaseDatabase.xml");// /for netbeans
        /*file = new File("src/Files/Database.xml");//for eclipse 
        boatFile = new File("src/Files/BoatDatabase.xml");//for eclipse
        leaseFile = new File("src/Files/LeaseDatabase.xml"); //for eclipse*/
        docFactory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to loop in the Customer objects list and read the elements and
     * store them write them into XML File(eventually insert into a database)
     *
     * @throws Exception
     */
    public void saveToCustomers() throws Exception {
        // Implement how to save to XML file

        try {
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("CUSTOMERS");
            doc.appendChild(rootElement);
            // Parse the List of customers and assign the values to the appropriate fields
            for (Customer customer : customers) {
                id = customer.getId();
                fName = customer.getFirstName();
                lName = customer.getLastName();
                phone = customer.getPhoneNo();
                address = customer.getAddress();
                boatNo = "" + customer.getBoat();

                leaseNo = "" + customer.getLease();
                isActive = customer.isActive() ? "true" : "false";

                int index = 0;
                data1[index] = "" + id;
                data1[++index] = fName;
                data1[++index] = lName;
                data1[++index] = phone;
                data1[++index] = address;
                data1[++index] = boatNo;
                data1[++index] = leaseNo;
                data1[++index] = isActive;

                // create root element of the XML File
                Element rootElementCustomer = doc.createElement("CUSTOMER");
                rootElement.appendChild(rootElementCustomer);
                //iterate through the customers list and write the appropriate values in the appropriate tags   
                for (int j = 0; j < data.length; j++) {

                    Element elementInside = doc.createElement(data[j]);
                    Text text = doc.createTextNode(data1[j]);
                    elementInside.appendChild(text);
                    rootElementCustomer.appendChild(elementInside);

                }

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);
            }
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }

    /**
     * 	 * Method save data to the XML File when the option save from file is
     * chosen from the File menu
     *
     * @param file
     * @throws IOException
     */
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Customer[] customers = this.customers.toArray(new Customer[this.customers.size()]);

        oos.writeObject(customers);

        oos.close();

    }

    /**
     * Method load data from an XML File when the controller sends the message
     * that the load button from the File menu was pressed
     *
     * @param file
     * @throws IOException
     */
    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Customer[] customers = (Customer[]) ois.readObject();

            this.customers.clear();

            this.customers.addAll(Arrays.asList(customers));

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ois.close();
    }

    /**
     * Method to add a Customer object to the Customer objects list
     *
     * @param customer
     */
    public void addCustomer(Customer customer) {
        customers.add(customer);

    }

    /**
     * Method to add a boat object to the list of Boat objects      *
     * @param boat
     */
    public void addBoat(Boat boat) {
        // TODO Auto-generated method stub
        boats.add(boat);
    }

    /**
     * Method to load the list of customers from the XML Database File
     *
     * @throws Exception
     */
    public void loadCustomers() throws Exception {
        customers.clear();
        Document document = docBuilder.parse(file);
        Element docEle = document.getDocumentElement();
        NodeList nl = docEle.getChildNodes();
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    if (el.getNodeName().contains("CUSTOMER")) {
                        for (int j = 0; j < data.length; j++) {
                            xmlValues[j] = el.getElementsByTagName(data[j]).item(0).getTextContent();

                        }
                        int index = 0;
                        id = xmlValues[index];
                        fName = xmlValues[++index];
                        lName = xmlValues[++index];
                        phone = xmlValues[++index];
                        address = xmlValues[++index];
                        boatNo = xmlValues[++index];
                        leaseNo = xmlValues[++index];
                        isActive = xmlValues[++index];

                        Customer customer = new Customer(id, fName, lName, phone, address, boatNo, leaseNo, Boolean.parseBoolean(isActive));
                        customers.add(customer);

                    }
                }
            }
        }
    }

    /**
     * Method to retrieve the boats list from the XML Database File
     *
     * @throws Exception
     */
    public void loadBoats() throws Exception {
        boats.clear();
        Document document = docBuilder.parse(boatFile);
        Element docEle = document.getDocumentElement();
        NodeList nl = docEle.getChildNodes();
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    if (el.getNodeName().contains("BOAT")) {
                        for (int j = 0; j < dataBoats.length; j++) {
                            xmlBoatValues[j] = el.getElementsByTagName(dataBoats[j]).item(0).getTextContent();

                        }
                        int index = 0;
                        id = xmlBoatValues[index];
                        registrationNo = xmlBoatValues[++index];
                        length = Double.parseDouble(xmlBoatValues[++index]);
                        width = Double.parseDouble(xmlBoatValues[++index]);
                        manufacturer = xmlBoatValues[++index];
                        year = Integer.parseInt(xmlBoatValues[++index]);
                        type = xmlBoatValues[++index];
                        sailBoat = Integer.parseInt(xmlBoatValues[++index]);
                        depth = Double.parseDouble(xmlBoatValues[++index]);
                        engineType = xmlBoatValues[++index];
                        numberEngines = Integer.parseInt(xmlBoatValues[++index]);
                        fuelType = xmlBoatValues[++index];

                        Boat boat = (type.compareTo("Sailboat") == 0) ? new Sailboat(registrationNo, length, width, manufacturer, year, id, depth, sailBoat, engineType)
                                : new Powerboat(registrationNo, length, width, manufacturer, year, id, numberEngines, fuelType);
                        boats.add(boat);

                    }
                }
            }
        }
    }

    /**
     * Method to loop in the Boat objects list and read the elements and store
     * them write them into XML File(eventually insert into a database)
     */
    public void saveToBoats() {
        // TODO Auto-generated method stub
        // Implement how to save to XML file
        // Parse the List of boats and assign the values to the appropriate fields
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("BOATS");
            doc.appendChild(rootElement);
            for (Boat boat : boats) {
                id = boat.getCustomerID();
                registrationNo = boat.getStateRegistrationNo();
                length = boat.getBoatLength();
                width = boat.getBoatWidth();
                manufacturer = boat.getManufacturer();
                year = boat.getYear();
                type = boat.getClass().getSimpleName();
                sailBoat = ((boat instanceof Sailboat) ? ((Sailboat) boat).getNumberSails() : 0);
                depth = ((boat instanceof Sailboat) ? ((Sailboat) boat).getKeelDepth() : 0);
                engineType = (boat instanceof Sailboat) ? ((Sailboat) boat).getMotorType() : "not supported";
                numberEngines = 0;
                numberEngines = ((boat instanceof Powerboat) ? ((Powerboat) boat).getNumberEngines() : 0);
                fuelType = (boat instanceof Powerboat) ? ((Powerboat) boat).getFuelType() : "not supported";

                int index = 0;
                valuesBoats[index] = id;

                valuesBoats[++index] = (registrationNo == null ? "" : registrationNo);
                valuesBoats[++index] = "" + length;
                valuesBoats[++index] = "" + width;
                valuesBoats[++index] = manufacturer;
                valuesBoats[++index] = "" + year;
                valuesBoats[++index] = type;
                valuesBoats[++index] = "" + sailBoat;
                valuesBoats[++index] = "" + depth;
                valuesBoats[++index] = engineType;
                valuesBoats[++index] = "" + numberEngines;
                valuesBoats[++index] = fuelType;

                // reate root element of the XML File
                Element rootElementCustomer = doc.createElement("BOAT");
                rootElement.appendChild(rootElementCustomer);

                for (int j = 0; j < dataBoats.length; j++) {

                    Element elementInside = doc.createElement(dataBoats[j]);

                    Text text = doc.createTextNode(valuesBoats[j]);
                    elementInside.appendChild(text);
                    rootElementCustomer.appendChild(elementInside);

                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(boatFile);
                transformer.transform(source, result);
            }
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

    /**
     * Method to write in the Xml file the values passed in from the FormEvent
     * Object to the contracts object list
     */
    public void saveToLeases() {
        // TODO Auto-generated method stub
        // Implement how to save to XML file
        // Parse the List of customers and assign the values to the appropriate fields

        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        try {
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("CONTRACTS");
            doc.appendChild(rootElement);
            for (Lease lease : contracts) {

                int index = 0;

                id = lease.getIdCustomer();
                idSlip = lease.getIdSlip();
                idLease = lease.getIdLease();
                startDate = lease.getStartDate();
                typeOfLease = lease.getClass().getSimpleName();
                typeOfPayement = ((lease instanceof AnnualLease) ? ((AnnualLease) lease).isPayMonthly() : false);
                daysN = (int) ((lease instanceof DailyLease) ? ((DailyLease) lease).getNumberOfDays() : 0);

                valuesLeases[index] = id;
                valuesLeases[++index] = idSlip;
                valuesLeases[++index] = "" + idLease;
                valuesLeases[++index] = "" + startDate;
                valuesLeases[++index] = typeOfLease;
                valuesLeases[++index] = Boolean.toString(typeOfPayement);
                valuesLeases[++index] = "" + daysN;

                // reate root element of the XML File
                Element rootElementCustomer = doc.createElement("LEASE");
                rootElement.appendChild(rootElementCustomer);

                for (int j = 0; j < dataLeases.length; j++) {

                    Element elementInside = doc.createElement(dataLeases[j]);

                    Text text = doc.createTextNode(valuesLeases[j]);
                    elementInside.appendChild(text);
                    rootElementCustomer.appendChild(elementInside);

                }
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(leaseFile);
                transformer.transform(source, result);
            }
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }

    /**
     * Return the list of Lease Objects
     *
     * @return
     */
    public List<Lease> getLeaseContract() {
        return Collections.unmodifiableList(contracts);
    }

    /**
     * Add lease object to the lease objects list
     *
     * @param lease
     */
    public void addLease(Lease lease) {
        // TODO Auto-generated method stub
        contracts.add(lease);
    }

    /**
     * Method to retrieve the contracts and add them to the Lease object list
     *
     * @throws Exception
     */
    public void loadLeases() throws Exception {
        // TODO Auto-generated method stubint loop = 0;
        contracts.clear();
        Document document = docBuilder.parse(leaseFile);
        Element docEle = document.getDocumentElement();
        NodeList nl = docEle.getChildNodes();
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {
                if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element el = (Element) nl.item(i);
                    if (el.getNodeName().contains("LEASE")) {
                        for (int j = 0; j < dataLeases.length; j++) {
                            xmlLeaseValues[j] = el.getElementsByTagName(dataLeases[j]).item(0).getTextContent();
                        }

                        int index = 0;

                        id = xmlLeaseValues[index];
                        idSlip = xmlLeaseValues[++index];
                        idLease = Integer.parseInt(xmlLeaseValues[++index]);

                        String target = xmlLeaseValues[++index];

                        try {
                            DateFormat df = new SimpleDateFormat("EEE MMM dd kk:mm:ss z yyyy", Locale.ENGLISH);
                            Date result = df.parse(target);

                            /*SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
	 	        		    Date result1 =  formatter.parse(result);  */
                            startDate = result;

                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        typeOfLease = xmlLeaseValues[++index];
                        typeOfPayement = Boolean.parseBoolean(xmlLeaseValues[++index]);
                        daysN = Integer.parseInt(xmlLeaseValues[++index]);

                        Slip slip = new Slip(idSlip, slipDao.getSlipWidthById(idSlip), slipDao.getSlipLengthById(idSlip), slipDao.getSlipISCoveredById(idSlip));
                       slip.setIsAvailable(false);
                       Lease lease = (typeOfLease.compareTo("DailyLease") == 0) ? new DailyLease(startDate, idLease, id, idSlip, daysN, slip) {
                        }
                                : new AnnualLease(typeOfPayement, startDate, idLease, id, idSlip, slip);
                        contracts.add(lease);
                    }
                }
            }
        }
    }
}
