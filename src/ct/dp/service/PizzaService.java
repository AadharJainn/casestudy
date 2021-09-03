package ct.dp.service;

import java.util.List;
import java.util.Map;

import ct.dp.business.bean.PizzaOrderBean;

public interface PizzaService {
	
	List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill);
	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean);
	Map<Integer, String> findAllPizzaDetails();

}
