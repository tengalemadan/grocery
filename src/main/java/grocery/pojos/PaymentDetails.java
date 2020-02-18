//TODO
/*package grocery.pojos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PaymentDetails")
public class PaymentDetails {

	Long payMentId;
	Long transactionId;
	double paidAmount;
	String paymentType;
	String payMentDateAndTime;
	PurchaseOrder orderId;
	public PaymentDetails() {
		System.out.println("In PaymentDetails Constructor...");
	}
	
	public PaymentDetails(Long transactionId, double paidAmount, PurchaseOrder orderId, String payMentDateAndTime) {
		super();
		this.transactionId = transactionId;
		this.paidAmount = paidAmount;
		this.orderId = orderId;
		this.payMentDateAndTime = payMentDateAndTime;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getPayMentId() {
		return payMentId;
	}
	public void setPayMentId(Long payMentId) {
		this.payMentId = payMentId;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
	}
	public PurchaseOrder getOrderId() {
		return orderId;
	}
	public void setOrderId(PurchaseOrder orderId) {
		this.orderId = orderId;
	}
	public String getPayMentDateAndTime() {
		return payMentDateAndTime;
	}
	public void setPayMentDateAndTime(String payMentDateAndTime) {
		this.payMentDateAndTime = payMentDateAndTime;
	}
	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public String toString() {
		return "PaymentDetails [payMentId=" + payMentId + ", transactionId=" + transactionId + ", paidAmount="
				+ paidAmount + ", orderId=" + orderId + ", payMentDateAndTime=" + payMentDateAndTime + "]";
	}
	
	
	
}*/
