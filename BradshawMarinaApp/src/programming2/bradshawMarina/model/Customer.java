/*
 * Class to define a Customer
 */
package programming2.bradshawMarina.model;

/*
 * @author Valentina Migalatii
 */
public class Customer {
	//declare variables
	private String id;
	private String firstName;
	private String lastName;
	private String phoneNo;
	private String address;
	private Boat boat;
	private Lease lease;
	private boolean isActive;
	private String boatNo;
	private String leaseNo;
	
	//Define the no-argument constructor
	public Customer() {
	}

	//Define the argument constructor
	public Customer(String id, String firstName, String lastName, String phoneNo,
			String address, Boat boat, Lease lease, boolean isActive) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.boat = boat;
		this.lease = lease;
		this.isActive = isActive;
	}
	
	

	public Customer(String id, String firstName, String lastName, String phoneNo,
			String address, boolean isActive, String boatNo, String leaseNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.isActive = isActive;
		this.boatNo = boatNo;
		this.leaseNo = leaseNo;
	}

	public String getBoatNo() {
		return boatNo;
	}

	public void setBoatNo(String boatNo) {
		this.boatNo = boatNo;
	}

	public String getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(String leaseNo) {
		this.leaseNo = leaseNo;
	}

	public Customer(String id, String firstName, String lastName, String phoneNo,
			String address, String boatNo, String leaseNo, boolean isActive) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.isActive = isActive;
		this.boatNo = boatNo;
		this.leaseNo = leaseNo;
	}

	public Lease getLease() {
		return lease;
	}

	public void setLease(Lease lease) {
		this.lease = lease;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNo=" + phoneNo
				+ ", address=" + address + ", boat=" + boat + ", lease="
				+ lease + ", isActive=" + isActive + ", boatNo=" + boatNo
				+ ", LeaseNo=" + leaseNo + "]";
	}
	
	
	
	
}
