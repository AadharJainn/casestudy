package ct.dp.dao;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ct.dp.business.bean.PizzaBean;
import ct.dp.business.bean.PizzaOrderBean;
import ct.dp.entity.PizzaEntity;
import ct.dp.entity.PizzaOrderEntity;

@Repository
@Transactional(value = "txManager")
public class PizzaDaoWrapper {
	@Autowired
	private PizzaDao pizzaDao;
	@Autowired
	private PizzaOrderDao pizzaOrderDao;
	PizzaEntity pizzaEntity;
	@PersistenceContext
	private EntityManager entityManager;

	public List<PizzaBean> findAllPizzaDetails() {

		List<PizzaEntity> pizzaEntity = pizzaDao.findAllPizzaDetails();
		List<PizzaBean> pizzaBean = new ArrayList<PizzaBean>();
		BeanUtils.copyProperties(pizzaEntity, pizzaBean);
		return pizzaBean;

	}

	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {

		PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);
		pizzaOrderDao.save(pizzaOrderEntity);
		BeanUtils.copyProperties(pizzaOrderEntity, pizzaOrderBean);
		return pizzaOrderBean;

	}

	public Double getPizzaPrice(Integer pizzaId) {

		Double pizzaEntity = entityManager.find(PizzaEntity.class, pizzaId).getPrice();
		return pizzaEntity;
	};

	@SuppressWarnings("unchecked")
	public List<PizzaOrderBean> getOrderDetails(double fromPrice, double toPrice) {
		Query q = entityManager.createQuery("select u from pizza u where u.price between :fromPrice and :toPrice")
				.setParameter("fromPrice", fromPrice).setParameter("toPrice", toPrice);

		List<PizzaOrderBean> pizzaBean = new ArrayList<PizzaOrderBean>();
		List<PizzaOrderEntity> pizzaOrderEntity = new ArrayList<PizzaOrderEntity>();
		for (PizzaOrderEntity pizzaOrder : pizzaOrderEntity) {
			BeanUtils.copyProperties(pizzaOrder, pizzaBean);
			pizzaBean.addAll(q.getResultList());
		}
		return pizzaBean;
	};
}
