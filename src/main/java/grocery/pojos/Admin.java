package grocery.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author Madanbalaji.tengale
 * This class for create Admin_Table  
 */
@Entity
@Table(name="AdminTable")
public class Admin {
	
	int  adminId;
	String adminUserName;
	String password;

	//For Testing purpose to check executes this code
	public Admin() {
		System.out.println("in Admin costructor...");
	}

	public Admin(String adminUserName, String password) {
		super();
		this.adminUserName = adminUserName;
		this.password = password;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	
	@Column(length=50,unique=true)
	public String getAdminUserName() {
		return adminUserName;
	}
	@Column(unique=true)
	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminUserName=" + adminUserName + ", password=" + password + "]";
	}
	

}
