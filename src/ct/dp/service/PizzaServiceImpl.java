package ct.dp.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.dao.PizzaDaoWrapper;


@Service
public class PizzaServiceImpl implements PizzaService{
	
	@Autowired
	private PizzaDaoWrapper pizzaDaoWrapper;

	@Override
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double tobill) {
		List<PizzaOrderBean> pizzaOrderBean=new ArrayList<PizzaOrderBean>();
		
		return pizzaOrderBean;
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaBean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
