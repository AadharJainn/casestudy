package ct.dp.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ct.dp.entity.PizzaEntity;

@Transactional(value = "txManager")
public interface PizzaDao  extends JpaRepository<PizzaEntity, Integer> {
	
	@Query(name="PizzaOrderEntity.findAllPizzaDetails")
	public List<PizzaEntity> findAllPizzaDetails();
	
}
