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
	private PizzaDao pizzaDao;
	@Autowired
	private PizzaOrderDao pizzaOrderDao;
	PizzaEntity pizzaEntity;
	@PersistenceContext
	private EntityManager entityManager;

	List<PizzaBean> findAllPizzaDetails() {

		List<PizzaEntity> pizzaEntity = pizzaDao.findAllPizzaDetails();
		List<PizzaBean> pizzaBean = new ArrayList<PizzaBean>();
		BeanUtils.copyProperties(pizzaEntity, pizzaBean);
		return pizzaBean;

	}

	PizzaOrderEntity addPizzaOrderDetails(PizzaOrderBean pizzaOrderBean) {

		PizzaOrderEntity pizzaOrderEntity = new PizzaOrderEntity();
		BeanUtils.copyProperties(pizzaOrderBean, pizzaOrderEntity);
		return pizzaOrderDao.save(pizzaOrderEntity);
	}

	Double getPizzaPrice(Integer pizzaId) {

		Double pizzaEntity = entityManager.find(PizzaEntity.class, pizzaId).getPrice();
		return pizzaEntity;
	};

	@SuppressWarnings("unchecked")
	List<PizzaOrderBean> getOrderDetails(double fromPrice, double toPrice) {
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
