package ct.dp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "pizza")
public class PizzaEntity {
	@Id
	private int pizzaId;

	private String pizzaName;

	private double price;

	@Override
	public String toString() {
		return "PizzaEntity [pizzaId=" + pizzaId + ", pizzaName=" + pizzaName + ", price=" + price + "]";
	}

	public PizzaEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PizzaEntity(int pizzaId, String pizzaName, double price) {
		super();
		this.pizzaId = pizzaId;
		this.pizzaName = pizzaName;
		this.price = price;
	}

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

}
