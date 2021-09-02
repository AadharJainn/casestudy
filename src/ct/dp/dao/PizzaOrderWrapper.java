package ct.dp.dao;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ct.dp.business.bean.PizzaBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.entity.PizzaEntity;
import ct.dp.entity.PizzaOrderEntity;

@Repository
@Transactional(value = "txManager")
public class PizzaOrderWrapper {
	@Autowired
	private PizzaDao pd;
	@Autowired
	private PizzaOrderDao pod;
	PizzaEntity pz;
	@PersistenceContext
	private EntityManager entityManager;

	List<PizzaBean> findAllPizzaDetails() {
		List<PizzaBean> pizzaBean = new ArrayList<PizzaBean>();
		List<PizzaEntity> pizzaEntity = entityManager
				.createNamedQuery("PizzaEntity.findAllPizzaDetails", PizzaEntity.class).getResultList();
		BeanUtils.copyProperties(pizzaEntity, pizzaBean);
		return pizzaBean;

	}

	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {

		PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);
		return null;
	}

	Double getPizzaPrice(Integer pizzaId) {
		return pd.findOne(pizzaId).getPrice();

	};

	@SuppressWarnings("unchecked")
	List<PizzaOrderBean> getOrderDetails(double fromPrice, double toPrice) {
		Query q = entityManager.createQuery("select u from pizza u where u.price between :fromPrice and :toPrice")
				.setParameter("fromPrice", fromPrice).setParameter("toPrice", toPrice);

		return q.getResultList();
	};

}
