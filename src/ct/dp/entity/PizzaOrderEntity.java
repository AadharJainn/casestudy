package ct.dp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "pizza_order")
public class PizzaOrderEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int orderId;

	private int pizzaId;

	private String customerName;

	private String contactNumber;

	private double bill;

	private int numberOfPiecesOrdered;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public int getNumberofPiecesOrdered() {
		return numberOfPiecesOrdered;
	}

	public void setNumberOfPiecesOrdered(int numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}

	public PizzaOrderEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PizzaOrderEntity(int orderId, int pizzaId, String customerName, String contactNumber, double bill,
			int numberOfPiecesOrdered) {
		super();
		this.orderId = orderId;
		this.pizzaId = pizzaId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.bill = bill;
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}

	@Override
	public String toString() {
		return "PizzaOrderEntity [orderId=" + orderId + ", pizzaId=" + pizzaId + ", customerName=" + customerName
				+ ", contactNumber=" + contactNumber + ", bill=" + bill + ", numberOfPiecesOrdered="
				+ numberOfPiecesOrdered + "]";
	}

}
