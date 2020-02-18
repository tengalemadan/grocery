package grocery.pojos;
import javax.persistence.*;

/**
 * @author Madanbalaji.tengale
 * This class for create Customers_table    
 */
@Entity
@Table(name="CustomersTable")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cust_id;
	private String customerName;
	private String customerAddress;
	private String contactNo;
	private String email;
	private String password;
	
	public Customer() {
		System.out.println("In customer constructor...");
	}
	public Customer(int cust_id) {
		super();
		this.cust_id = cust_id;
	}

	public Customer(String customerName, String customerAddress, String contactNo, String email, String password) {
		super();
		this.customerName = customerName;
		this.customerAddress = customerAddress;
		this.contactNo = contactNo;
		this.email = email;
		this.password = password;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
		
}
