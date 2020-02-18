
package grocery.pojos;
import java.util.Date;
import javax.persistence.*;

import org.springframework.stereotype.Component;

/**
 * @author Madanbalaji.tengale
 * This class for create purchase_order table   
 */
@Component
@Entity
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	private boolean isOrderPlaced;
	private double totalAmount;
	private Date deliveryDate;
	//one to one mapping customer to purchase order
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "cust_id",foreignKey = @ForeignKey(name="cust_id"))
	Customer cust_id;
	//one to one mapping product to purchase order which customer this particular buy
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "prod_id")
	Product prod_id;
	
	public PurchaseOrder() {
		System.out.println("in purchase order constr...");
	}
	
	public PurchaseOrder(boolean isOrderPlaced, double totalAmount, Date deliveryDate, Customer cust_id,
			Product prod_id) {
		super();
		this.isOrderPlaced = isOrderPlaced;
		this.totalAmount = totalAmount;
		this.deliveryDate = deliveryDate;
		this.cust_id = cust_id;
		this.prod_id = prod_id;
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public boolean isOrderPlaced() {
		return isOrderPlaced;
	}
	public void setOrderPlaced(boolean isOrderPlaced) {
		this.isOrderPlaced = isOrderPlaced;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Customer getCust_id() {
		return cust_id;
	}
	public void setCust_id(Customer cust_id) {
		this.cust_id = cust_id;
	}
	public Product getProd_id() {
		return prod_id;
	}
	public void setProd_id(Product prod_id) {
		this.prod_id = prod_id;
	}
	
}
