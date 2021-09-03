package ct.dp.business.bean;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class PizzaOrderBean {
	@NotNull(message = "order id cannot be empty")
	private int orderId;
	@NotNull(message = "pizza id cannot be empty")
	private int pizzaId;
	@NotNull
	@Pattern(regexp = "[a-zA-Z]{3,30}$", message = "Customer Name should have length between 3 and 30")
	private String customerName;
	@NotNull
	@Pattern(regexp = "[0-9]", message="Contact Number should have length 10")
	@Column(length = 10)
	private String contactNumber;
	@NotNull
	private double bill;
	@NotNull
	@Size(min = 1, message = "Quantity should not be empty")
	private int numberOfPiecesOrdered;

	public PizzaOrderBean(int orderId, int pizzaId, String customerName, String contactNumber, double bill,
			int numberOfPiecesOrdered) {
		super();
		this.orderId = orderId;
		this.pizzaId = pizzaId;
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.bill = bill;
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}

	public PizzaOrderBean() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public int getNumberOfPiecesOrdered() {
		return numberOfPiecesOrdered;
	}

	public void setNumberOfPiecesOrdered(int numberOfPiecesOrdered) {
		this.numberOfPiecesOrdered = numberOfPiecesOrdered;
	}
}
