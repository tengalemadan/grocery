
package grocery.pojos;

import java.util.Arrays;
import javax.persistence.*;
/**
 * @author Madanbalaji.tengale
 * This class for create productinfo table   
 */
@Entity
@Table(name="ProductInfo")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer prod_id;
	private String name;
	private double price;
	private String type;
	private double qty;
	private String unit;
	private boolean isOrganic;
	private double discount;
	// @JsonIgnore
	private byte[] productImg;

	public Product() {
		System.out.println("in product default constructor");
	}
	
	public Product(Integer prod_id) {
		super();
		this.prod_id = prod_id;
	}
	
	public Product(String name, double price, String type, double qty, String unit, boolean isOrganic,
			double discount) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.qty = qty;
		this.unit = unit;
		this.isOrganic = isOrganic;
		this.discount = discount;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getQty() {
		return qty;
	}

	public void setQty(double qty) {
		this.qty = qty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public boolean isOrganic() {
		return isOrganic;
	}

	public void setOrganic(boolean isOrganic) {
		this.isOrganic = isOrganic;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public byte[] getProductImg() {
		return productImg;
	}

	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", name=" + name + ", price=" + price + ", type=" + type + ", qty=" + qty
				+ ", unit=" + unit + ", isOrganic=" + isOrganic + ", discount=" + discount + ", productImg="
				+ Arrays.toString(productImg) + "]";
	}

}
