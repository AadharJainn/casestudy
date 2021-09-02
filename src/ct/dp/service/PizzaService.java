package ct.dp.service;

import java.util.List;
import java.util.Map;

import ct.dp.business.bean.PizzaOrderBean;

public interface PizzaService {
	
	List<PizzaOrderBean> getOrderDetails(Double fromBill, Double tobill);
	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean);
	Map<Integer, String> findAllPizzaDetails();

}
