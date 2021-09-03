package ct.dp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ct.dp.business.bean.PizzaBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.dao.PizzaDaoWrapper;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaDaoWrapper pizzaDaoWrapper;

	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) {
		List<PizzaOrderBean> pizzaOrderBean = pizzaDaoWrapper.getOrderDetails(fromBill, toBill);
		if (pizzaOrderBean == null) {
			throw new NullPointerException("Sorry, No data found!!");
		}
		return pizzaOrderBean;
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {
		Double price = pizzaDaoWrapper.getPizzaPrice(pizzaOrderBean.getPizzaId());
		if (price == null) {
			throw new NullPointerException("Sorry, cannot find pizza price");
		}
		Integer pieces = pizzaOrderBean.getNumberOfPiecesOrdered();
		Double bill = price * pieces;
		pizzaOrderBean.setBill(bill);
		return pizzaDaoWrapper.addPizzaOrderDetails(pizzaOrderBean);

	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() {
		Map<Integer, String> map = new HashMap<Integer, String>();

		List<PizzaBean> list = pizzaDaoWrapper.findAllPizzaDetails();
		if (list == null) {
			throw new NullPointerException("Sorry, No data found currently");
		}
		for (PizzaBean pizzaBean : list) {
			map.put(pizzaBean.getPizzaId(), pizzaBean.getPizzaName());
		}

		return map;
	}

}
