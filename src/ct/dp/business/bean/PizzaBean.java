package ct.dp.business.bean;

public class PizzaBean {
	
	private int pizzaId;
	private String pizzaName;
	private double price;
	public int getPizzaId() {
		return pizzaId;
	}
	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}
	public String getPizzaName() {
		return pizzaName;
	}
	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public PizzaBean(int pizzaId, String pizzaName, double price) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.price = price;
	}
	public PizzaBean() {
		super();
		// TODO Auto-generated constructor stub
	}

}
